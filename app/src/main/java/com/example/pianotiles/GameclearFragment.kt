package com.example.pianotiles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton

class GameclearFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gameclear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<AppCompatButton>(R.id.btn_restart2).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainMenuFragment.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameclearFragment()
    }
}