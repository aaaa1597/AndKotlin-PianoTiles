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
    private lateinit var gameViewModel: GameplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameViewModel = ViewModelProvider(requireActivity())[GameplayViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pause, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* resume押下 */
        view.findViewById<Button>(R.id.btn_resume).setOnClickListener {
            /* pause解除 */
            gameViewModel.setPause(false)
            /* このFragmentを消去 */
            parentFragmentManager.beginTransaction().remove(this).commit()
            /* GameplayFragment画面に戻る */
            parentFragmentManager.popBackStack("GameplayFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        /* 再スタート押下 */
        view.findViewById<Button>(R.id.btn_restart).setOnClickListener {
            gameViewModel.init()
            parentFragmentManager.beginTransaction().remove(this).commit()
            parentFragmentManager.popBackStack("GameplayFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        /* 終了ボタン押下 */
        view.findViewById<Button>(R.id.btn_quit).setOnClickListener {
            /* pause解除 */
            gameViewModel.init()
            /* このFragmentを消去 */
            parentFragmentManager.beginTransaction().remove(this).commit()
            parentFragmentManager.popBackStack("MainMenuFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PauseFragment()
    }
}