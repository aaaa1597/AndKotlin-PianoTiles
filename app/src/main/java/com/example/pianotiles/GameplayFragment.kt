package com.example.pianotiles

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.core.view.allViews
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pianotiles.GameLevel.*
import com.example.pianotiles.databinding.FragmentGameplayBinding
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch

const val PERIODIC_TIME_EASY  = 2000f
const val PERIODIC_TIME_NORMAL= (2000*0.9).toFloat()
const val PERIODIC_TIME_HARD  = (2000*0.8).toFloat()

class GameplayFragment: Fragment() {
    companion object {
        fun newInstance(level: GameLevel, volume: Float)
            = GameplayFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("LEVEL", level)
                    putFloat("VOLUME", volume)
                }
            }
    }

    private lateinit var _binding: FragmentGameplayBinding
    private lateinit var gameViewModel: GameplayViewModel
    private lateinit var _level: GameLevel
    private lateinit var run: Runnable      /* ゲーム処理メイン */
    private var _volume: Float = 0f
    private var _screenH: Float = 0f
    private lateinit var _countDownTimer: CountDownTimer
    @Volatile
    private var isPause: Boolean = false /* 中断フラグ(Setting画面移行とかGameOverになったときとか) */
        set(value) {
            /* これでpostDelayした分は停止/再開する */
            field = value
            /* ついでに現在実行中のTileViewのアニメを停止/再開する */
            _binding.flyTiles.allViews.forEach {
                if(it is TileView)
                    if(value) it.pause()
                    else      it.resume()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameViewModel = ViewModelProvider(this, GameplayViewModel.Factory(requireActivity().application))[GameplayViewModel::class.java]
        arguments?.let {
            _level = it.getSerializable("LEVEL", GameLevel::class.java)!!
            _volume= it.getFloat("VOLUME")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentGameplayBinding.inflate(inflater, container, false)
        return _binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* pause画面でのResumeボタン押下検知のCallBack設定 */
        _binding.fragmentPause.getFragment<PauseFragment>().setOnResumeButtonClickCallback(
            object: PauseFragment.OnResumeButtonClickCallback{
                override fun onResumeButtonClick() {
                    isPause = false
                    _binding.fragmentPause.visibility = View.GONE
                }
            })
        /* pause画面でのReStartボタン押下検知のCallBack設定 */
        _binding.fragmentPause.getFragment<PauseFragment>().setOnReStartButtonClickCallback(
            object: PauseFragment.OnReStartButtonClickCallback{
                override fun onReStartButtonClick() {
                    _binding.fragmentPause.visibility = View.GONE
//                    Handler(Looper.getMainLooper()).removeAllMessages() /* もうすでにないはず */
                    _binding.flyTiles.removeAllViews()
                    _binding.txtCountdown.visibility = View.VISIBLE
                    _binding.txtEndmessage.visibility = View.GONE
                    _binding.btnRestart2.visibility = View.GONE
                    _countDownTimer.start()
                }
            })
        /* pause画面でのQuitボタン押下検知のCallBack設定 */
        _binding.fragmentPause.getFragment<PauseFragment>().setOnQuitButtonClickCallback(
            object: PauseFragment.OnQuitButtonClickCallback{
                override fun onQuitButtonClick() {
                    _binding.fragmentPause.visibility = View.GONE
                    _binding.flyTiles.removeAllViews()
                    _binding.txtCountdown.visibility = View.VISIBLE
                    _binding.txtEndmessage.visibility = View.GONE
                    _binding.btnRestart2.visibility = View.GONE
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MainMenuFragment.newInstance())
                        .commit()
                }
            })

        /* pauseボタン押下 */
        _binding.btnPause.setOnClickListener {
            isPause = true
            _binding.fragmentPause.visibility = View.VISIBLE
        }
        _binding.fragmentPause.visibility = View.GONE
        /* 画面ミスタッチ -> GameOver */
        _binding.rlvRuledline.setOnTouchListener(object: OnTouchListener{
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                if(event.action == MotionEvent.ACTION_DOWN) {
                    isPause = true
                    _binding.txtEndmessage.visibility = View.VISIBLE
                    _binding.txtEndmessage.text = getString(R.string.gameover)
                    _binding.btnRestart2.visibility = View.VISIBLE
                    return true
                }
                return false
            }
        })
        /* スコア表示 */
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    gameViewModel.score.collect {
                        _binding.txtScore.text = gameViewModel.score.value.toString()
                    }
                }
            }
        }
        /* ゲームクリア後の再スタートボタン */
        _binding.btnRestart2.setOnClickListener {
            _binding.txtEndmessage.visibility = View.GONE
            _binding.btnRestart2.visibility = View.GONE
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainMenuFragment.newInstance())
                .commit()
        }

        /* ゲーム開始準備(onViewCreatedではw,hがとれないので確定してから実行する) */
        view.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                gameViewModel.getReady(_level, view.width, view.height)
                _screenH = view.height.toFloat()
            }
        })
        /* ゲーム開始カウントダウン */
        _countDownTimer = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _binding.txtCountdown.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                isPause = false
                _binding.btnPause.isEnabled = true
                _binding.txtCountdown.visibility = View.GONE
                /* ゲーム開始 */
                Handler(Looper.getMainLooper()).post(run)
            }
        }
        /* カウントダウン開始 */
        _countDownTimer.start()

        /* ゲーム処理メイン */
        run = Runnable {
            /* pause中は処理しない */
            while(isPause)
                return@Runnable

            /* タイル情報が空ならゲームクリア!! */
            if(gameViewModel.tiles.isEmpty()) {
                _binding.txtEndmessage.visibility = View.VISIBLE
                _binding.txtEndmessage.text = getString(R.string.congratulations_gaeme_cleared)
                _binding.btnRestart2.visibility = View.VISIBLE
                return@Runnable
            }

            /* 鍵盤生成 */
            val tileview = TileView(requireContext(), gameViewModel.tiles.removeFirst(), _screenH, _level)
            /* タイルが端についちまった検知(タイルが端についちまったらGameover) */
            tileview.setOnReachEdgeCallback(object : TileView.OnReachEdgeCallback {
                override fun onReachEdge() {
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                            launch {
                                isPause = true
                                _binding.txtEndmessage.visibility = View.VISIBLE
                                _binding.txtEndmessage.text = getString(R.string.gameover)
                                _binding.btnRestart2.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            })

            /* タイルタッチで消去検知 */
            tileview.setOnRemoveViewCallback(object : TileView.OnRemoveViewCallback {
                override fun onRemoveView() {
                    gameViewModel.score.value++
                }
            })

            /* タイルタッチで消去の検知 */
            _binding.flyTiles.addView(tileview)
            /* 次の準備 */
            val periodictime = when(_level) {
                easy  -> (PERIODIC_TIME_EASY/4).toLong()
                normal-> (PERIODIC_TIME_NORMAL/4).toLong()
                hard  -> (PERIODIC_TIME_HARD/4).toLong()
            }
            /* 次実行 */
            Handler(Looper.getMainLooper()).postDelayed(run, periodictime)
        }
    }
}