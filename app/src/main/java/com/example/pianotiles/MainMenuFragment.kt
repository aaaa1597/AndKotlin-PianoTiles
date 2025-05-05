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

class MainMenuFragment : Fragment() {
    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private lateinit var _binding: FragmentMainMenuBinding
    private val binding get() = _binding
    private val fragmentListener: FragmentListener? = null
    private val musicList: List<Music> = MusicFiles.music.toList()
    private var musicStarted = false
    private var nowPlaying = 0
    private val backgroundId = 0
    private lateinit var viewModel: MainMenuViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this)[MainMenuViewModel::class.java]
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* ミュートボタン押下 */
        _binding.fabMute.setOnClickListener{ viewModel.toggleMute() }
        /* Jukebox初期化 */
        viewModel.setJukebox(Jukebox(requireActivity()))
        binding.txtSongName.text = viewModel.getNowSongName()
        viewModel.setVolume(50f)
        viewModel.playSong()

        _binding.btnEasy.setOnClickListener{ setLevel(0) }
        _binding.btnNormal.setOnClickListener{ setLevel(1) }
        _binding.btnHard.setOnClickListener{ setLevel(2) }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                /* ミュートボタン押下するので、viewModel.muteを監視 */
                launch {
                    viewModel.mute.collect {
                        if(it) {
                            _binding.fabMute.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.volume_on_48))
//                            mediaPlayer.setVolume(0f, 0f)
                        }
                        else {
                            _binding.fabMute.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.volume_off_48))
//                            mediaPlayer.setVolume(viewModel.getVolume(), viewModel.getVolume())
                        }
                    }
                }
//                /* 曲名Text押下 */
//                launch {
//                    viewModel.songidx.collect {
//                        Jukebox.playNext()
//                    }
//                }
            }
        }

    }

    fun play() {
//        TODO("Not yet implemented")
    }

    fun pauseSound() {
//        mediaPlayer.pause()
    }

    fun resumeSound() {
//        mediaPlayer.start()
    }

    fun changeVolume(vol: Int) {
        val fvol = viewModel.setVolume(vol.toFloat())
//        mediaPlayer.setVolume(fvol, fvol)
    }

    fun setDefault() {
        viewModel.init()
    }

    private fun mute() {
        if (viewModel.isMute()) {
            binding.fabMute.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.volume_off_48))
//            mediaPlayer.setVolume(0f, 0f)
        } else {
            binding.fabMute.setImageDrawable( ContextCompat.getDrawable( requireContext(), R.drawable.volume_on_48))
//            mediaPlayer.setVolume(viewModel.getVolume(), viewModel.getVolume())
        }
    }

    fun isMute(): Boolean {
        return false
    }

    private fun setLevel(level: Int) {
        if (level == 0) {
            binding.btnEasy.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_green_button)
            binding.btnNormal.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)
            binding.btnHard.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)

            binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            viewModel.setLevel(0)
        } else if (level == 1) {
            binding.btnEasy.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)
            binding.btnNormal.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_yellow_button)
            binding.btnHard.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)

            binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
            binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            viewModel.setLevel(1)
        } else {
            binding.btnEasy.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)
            binding.btnNormal.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_gray_button)
            binding.btnHard.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.round_red_button)

            binding.btnEasy.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            binding.btnNormal.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            binding.btnHard.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            viewModel.setLevel(2)
        }
    }
}