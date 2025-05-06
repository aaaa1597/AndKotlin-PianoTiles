package com.example.pianotiles

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.lifecycle.ViewModelProvider
import com.example.pianotiles.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    companion object {
        fun newInstance() = SettingFragment()
    }

    private lateinit var _binding: FragmentSettingBinding
    private val viewModel: SettingViewModel by viewModels()
    private lateinit var mainViewModel: MainMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[MainMenuViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* 音量調整バー */
        _binding.seekBar.apply {
            /* 初期値設定 */
            progress = mainViewModel.getSeekbarValue()
            /* 音量調整 */
            setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean)
                        = mainViewModel.changeVolume(progress)
                /* 何もしない */
                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
        /* 初期値に戻すボタン */
        _binding.resetBtn.setOnClickListener {
            _binding.seekBar.progress = 100
            mainViewModel.init()
        }
        /* 完了ボタン */
        _binding.doneBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
            parentFragmentManager.popBackStack()
        }
    }
}