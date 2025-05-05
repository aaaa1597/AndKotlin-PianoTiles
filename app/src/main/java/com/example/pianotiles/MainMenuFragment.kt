package com.example.pianotiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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
    private val binding get() = _binding
    private lateinit var viewModel: MainMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainMenuViewModel::class.java]
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* ミュートボタン押下 */
        _binding.fabMute.setOnClickListener{ viewModel.toggleMute() }
        /* 設定ボタン押下 */
        _binding.fabSettings.setOnClickListener {

        }
        /* Jukebox初期化 */
        viewModel.setJukebox(Jukebox(requireActivity()))
        binding.txtSongName.text = viewModel.getNowSongName()
        viewModel.setVolume(1f)
        viewModel.playSong()

        /* 曲選択 */
        _binding.txtSongName.setOnClickListener { viewModel.nextSong() }

        /* レベル設定 */
        _binding.btnEasy.setOnClickListener{ viewModel.setLevel(GameLevel.easy) }
        _binding.btnNormal.setOnClickListener{ viewModel.setLevel(GameLevel.normal) }
        _binding.btnHard.setOnClickListener{ viewModel.setLevel(GameLevel.hard) }

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