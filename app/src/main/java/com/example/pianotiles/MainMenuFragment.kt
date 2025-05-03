package com.example.pianotiles

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class MainMenuFragment : Fragment() {
    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private val mediaPlayer: MediaPlayer? = null
    private val fragmentListener: FragmentListener? = null
    private val musicList: List<Music> = MusicFiles.music.toList()
    private val musicStarted = false
    private val nowPlaying = 0
    private val volume = 1f
    private val backgroundId = 0
    var mute: Boolean = false
    private lateinit var viewModel: MainMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainMenuViewModel::class.java]
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
        = inflater.inflate(R.layout.fragment_main_menu, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(1, false)
        view.findViewById<Button>(R.id.normal).setBackgroundResource(R.color.yellow)
//        view.findViewById<FloatingActionButton>(R.id.fab_musicflg).setCompatElevationResource(R.drawable.music_on_48)

    }

    fun play() {
//        TODO("Not yet implemented")
    }

    fun pauseSound() {
//        TODO("Not yet implemented")
    }

    fun resumeSound() {
//        TODO("Not yet implemented")
    }

    fun changeVolume(vol: Int) {

    }

    fun changeBackground(id: Int) {

    }

    fun setDefault() {
//        TODO("Not yet implemented")
    }

    fun isMute(): Boolean {
        return false
    }
}