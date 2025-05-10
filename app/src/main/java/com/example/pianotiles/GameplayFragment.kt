package com.example.pianotiles

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pianotiles.GameLevel.*
import com.example.pianotiles.databinding.FragmentGameplayBinding
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch

val PERIODIC_TIME_EASY  = 2000f
val PERIODIC_TIME_NORMAL= (2000*0.9).toFloat()
val PERIODIC_TIME_HARD  = (2000*0.8).toFloat()

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameViewModel = ViewModelProvider(this, GameplayViewModel.Factory(_volume, requireActivity().application)).get(GameplayViewModel::class.java)
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
        /* pauseボタン押下 */
        _binding.btnPause.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack("GameplayFragment")
                .replace(R.id.fragment_container, PauseFragment.newInstance())
                .commit()
        }
        /* 画面ミスタッチ -> GameOver */
        _binding.rlvRuledline.setOnTouchListener(object: OnTouchListener{
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                if(event.action == MotionEvent.ACTION_DOWN) {
                    parentFragmentManager.beginTransaction()
                        /* TODO GameOver画面を作成する */
                        .replace(R.id.fragment_container, GameplayFragment.newInstance(_level, _volume))
                        .commit()
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
        /* ゲーム開始準備(onViewCreatedではw,hがとれないので確定してから実行する) */
        view.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                gameViewModel.getReady(_level, view.width, view.height)
                _screenH = view.height.toFloat()
            }
        })
        /* ゲーム開始カウントダウン */
        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _binding.txtCountdown.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                _binding.btnPause.isEnabled = true
                _binding.txtCountdown.visibility = View.GONE
                /* ゲーム開始 */
                Handler(Looper.getMainLooper()).post(run)
            }
        }.start()

        /* ゲーム処理メイン */
        run = Runnable {
            /* タイル情報取得 */
            if(gameViewModel.tiles.isEmpty()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, GameclearFragment.newInstance())
                    .commit()
                return@Runnable
            }

            /* 鍵盤生成 */
            val tileview = TileView(requireContext(), gameViewModel.tiles.removeFirst(), _screenH, _level)
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