package com.example.pianotiles

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pianotiles.databinding.FragmentMainMenuBinding
import kotlinx.coroutines.launch

enum class GameLevel {easy,normal,hard}

class MainMenuFragment : Fragment() {
    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private lateinit var _binding: FragmentMainMenuBinding
    private lateinit var viewModel: MainMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainMenuViewModel::class.java]
        viewModel.setJukebox(Jukebox(requireActivity()))
        viewModel.playSong()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* ミュートボタン押下 */
        _binding.fabMute.setOnClickListener{ viewModel.toggleMute() }
        /* 設定ボタン押下 -> 設定画面へ */
        _binding.fabSettings.setOnClickListener {
            parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, SettingFragment.newInstance())
            .commit()
        }
        /* Jukebox初期化 */
        _binding.txtSongName.text = viewModel.getNowSongName()

        /* 曲選択 */
        _binding.txtSongName.setOnClickListener { viewModel.nextSong() }

        /* レベル設定 */
        _binding.btnEasy.setOnClickListener{ viewModel.setLevel(GameLevel.easy) }
        _binding.btnNormal.setOnClickListener{ viewModel.setLevel(GameLevel.normal) }
        _binding.btnHard.setOnClickListener{ viewModel.setLevel(GameLevel.hard) }

        /* ゲーム開始ボタン押下 */
        _binding.btnStart.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack("MainMenuFragment")
                .replace(R.id.fragment_container, GameplayFragment.newInstance())
                .commit()
        }

        /* 一時停止確認用 */
        _binding.aaa.setOnClickListener{
            if ((it as TextView).text == "再生中") {
                it.text = "停止"
                viewModel.pauseSong()
            }
            else {
                it.text = "再生中"
                viewModel.resumeSong()
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                /* ミュートボタン押下、でviewModel.muteを監視 */
                launch {
                    viewModel.mute.collect {
                        if(it)
                            _binding.fabMute.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.volume_off_48))
                        else
                            _binding.fabMute.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.volume_on_48))
                    }
                }

                /* 楽曲ラベル押下、でviewModel.nowidxを監視 */
                launch {
                    viewModel.nowidx.collect {
                        _binding.txtSongName.text = viewModel.getNowSongName()
                    }
                }

                /* easy/normal/hardボタン押下、でviewModel.levelを監視 */
                launch {
                    viewModel.level.collect {
                        when(it) {
                            GameLevel.easy -> {
                                /* ボタン背景設定 */
                                _binding.btnEasy.setBackgroundResource(R.drawable.round_green_button)
                                _binding.btnNormal.setBackgroundResource(R.drawable.round_gray_button)
                                _binding.btnHard.setBackgroundResource(R.drawable.round_gray_button)
                                /* Text色変更 */
                                _binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                                _binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                                _binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                            }
                            GameLevel.normal -> {
                                /* ボタン背景設定 */
                                _binding.btnEasy.setBackgroundResource(R.drawable.round_gray_button)
                                _binding.btnNormal.setBackgroundResource(R.drawable.round_yellow_button)
                                _binding.btnHard.setBackgroundResource(R.drawable.round_gray_button)
                                /* Text色変更 */
                                _binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                                _binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
                                _binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                            }
                            GameLevel.hard -> {
                                /* ボタン背景設定 */
                                _binding.btnEasy.setBackgroundResource(R.drawable.round_gray_button)
                                _binding.btnNormal.setBackgroundResource(R.drawable.round_gray_button)
                                _binding.btnHard.setBackgroundResource(R.drawable.round_red_button)
                                /* Text色変更 */
                                _binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                                _binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                                _binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                            }
                        }
                    }
                }
            }
        }

    }

    fun changeVolume(vol: Int) {
        viewModel.setVolume(vol.toFloat())
    }

    fun setDefault() {
        viewModel.init()
    }
}