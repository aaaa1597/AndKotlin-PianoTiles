package com.example.pianotiles

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pianotiles.databinding.FragmentGameplayBinding
import com.example.pianotiles.databinding.FragmentMainMenuBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GameplayFragment : Fragment() {

    companion object {
        fun newInstance() = GameplayFragment()
    }

    private lateinit var _binding: FragmentGameplayBinding
    private val gameViewModel: GameplayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            gameViewModel.setPause(true)
            parentFragmentManager.beginTransaction()
                .addToBackStack("GameplayFragment")
                .replace(R.id.fragment_container, PauseFragment.newInstance())
                .commit()
        }
        /* 画面タッチ */
        _binding.rlvBackground.setOnTouchListener(object: OnTouchListener{
            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
                return true
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                /* スコア表示 */
                launch {
                    gameViewModel.score.collect {
                        _binding.txtScore.text = gameViewModel.score.value.toString()
                    }
                }

            }
        }

    }
}