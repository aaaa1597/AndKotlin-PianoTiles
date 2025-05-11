package com.example.pianotiles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider

class PauseFragment : Fragment() {
    private lateinit var _onResumeButtonClickCallback: OnResumeButtonClickCallback
    private lateinit var _onReStartButtonClickCallback: OnReStartButtonClickCallback
    private lateinit var _onQuitButtonClickCallback: OnQuitButtonClickCallback
    private lateinit var gameViewModel: GameplayViewModel
    private var _volume: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _volume= it.getFloat("VOLUME")
        }
        gameViewModel = ViewModelProvider(this, GameplayViewModel.Factory(_volume, requireActivity().application))[GameplayViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pause, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* resume押下 */
        view.findViewById<Button>(R.id.btn_resume).setOnClickListener {
            /* resume押下通知(呼び側でVisible変更するため) */
            _onResumeButtonClickCallback.onResumeButtonClick()
        }
        /* 再スタート押下 */
        view.findViewById<Button>(R.id.btn_restart).setOnClickListener {
            /* ReStart押下通知(呼び側で再開始するため) */
            _onReStartButtonClickCallback.onReStartButtonClick()
        }
        /* 終了ボタン押下 */
        view.findViewById<Button>(R.id.btn_quit).setOnClickListener {
            /* Quit押下通知(呼び側で再開始するため) */
            _onQuitButtonClickCallback.onQuitButtonClick()
        }
    }

    fun setOnResumeButtonClickCallback(callback: OnResumeButtonClickCallback) {
        _onResumeButtonClickCallback = callback
    }
    fun setOnReStartButtonClickCallback(callback: OnReStartButtonClickCallback) {
        _onReStartButtonClickCallback = callback
    }
    fun setOnQuitButtonClickCallback(callback: OnQuitButtonClickCallback) {
        _onQuitButtonClickCallback = callback
    }
    interface OnResumeButtonClickCallback {
        fun onResumeButtonClick()
    }
    interface OnReStartButtonClickCallback {
        fun onReStartButtonClick()
    }
    interface OnQuitButtonClickCallback {
        fun onQuitButtonClick()
    }

    companion object {
        @JvmStatic
        fun newInstance(volume: Float)
            = PauseFragment().apply {
                arguments = Bundle().apply {
                    putFloat("VOLUME", volume)
                }
            }
    }
}