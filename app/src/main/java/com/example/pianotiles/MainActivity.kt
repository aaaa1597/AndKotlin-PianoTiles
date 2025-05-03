package com.example.pianotiles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var  fragmentManager: FragmentManager
    private lateinit var  mainMenuFragment: MainMenuFragment
//    private lateinit var  gameplayFragment: GameplayFragment
//    private lateinit var  settingFragment: SettingFragment
//    private lateinit var  pauseFragment: PauseFragment
//    private lateinit var  gameOverFragment: GameOverFragment
//    private lateinit var  highScoreFragment: HighScoreFragment
    private var fcurrent: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainMenuFragment = MainMenuFragment()
        fragmentManager = this.supportFragmentManager
        fragmentManager.addOnBackStackChangedListener {
            fcurrent = fragmentManager.findFragmentById(R.id.fragment_container)!!
        }
        changePage(1)
    }

    fun changePage(page: Int) {
        val ft = fragmentManager.beginTransaction()
        if (page == 1) {
            if (fcurrent != null) {
                ft.hide(fcurrent!!)
            }
            if (mainMenuFragment.isAdded) {
                mainMenuFragment.play()
                ft.show(this.mainMenuFragment)
                fcurrent = this.mainMenuFragment
            } else {
                ft.add(R.id.fragment_container, this.mainMenuFragment)
                fcurrent = this.mainMenuFragment
            }
//        } else if (page == 2) {
//            this.gameplayFragment = GameplayFragment()
//            if (fcurrent != null) {
//                ft.hide(fcurrent)
//            }
//            if (this.gameplayFragment.isAdded()) {
//                ft.show(this.gameplayFragment)
//                fcurrent = this.gameplayFragment
//            } else {
//                ft.add(R.id.fragment_container, this.gameplayFragment)
//                fcurrent = this.gameplayFragment
//            }
//        } else if (page == 3) {
//            if (fcurrent != null) {
//                ft.hide(fcurrent)
//            }
//            if (this.settingFragment.isAdded()) {
//                ft.show(this.settingFragment)
//                fcurrent = this.settingFragment
//            } else {
//                ft.add(R.id.fragment_container, this.settingFragment)
//                fcurrent = this.settingFragment
//            }
//        } else if (page == 4) {
//            this.pauseFragment = PauseFragment()
//            this.pauseFragment.changeBackground(settingFragment.getBackgroundId())
//            this.pauseFragment.setLevel(this.gameplayFragment.getLevel())
//            if (fcurrent != null) {
//                ft.hide(fcurrent)
//            }
//            if (this.pauseFragment.isAdded()) {
//                ft.show(this.pauseFragment)
//                fcurrent = this.pauseFragment
//            } else {
//                ft.add(R.id.fragment_container, this.pauseFragment)
//                fcurrent = this.pauseFragment
//            }
//        } else if (page == 5) {
//            this.gameOverFragment.changeBackground(settingFragment.getBackgroundId())
//            if (fcurrent != null) {
//                ft.hide(fcurrent)
//            }
//            if (this.gameOverFragment.isAdded()) {
//                ft.show(this.gameOverFragment)
//                fcurrent = this.gameOverFragment
//            } else {
//                ft.add(R.id.fragment_container, this.gameOverFragment)
//                fcurrent = this.gameOverFragment
//            }
//        } else if (page == 6) {
//            this.highScoreFragment.changeBackground(settingFragment.getBackgroundId())
//            if (fcurrent != null) {
//                ft.hide(fcurrent)
//            }
//            if (this.highScoreFragment.isAdded()) {
//                ft.show(this.highScoreFragment)
//                fcurrent = this.highScoreFragment
//            } else {
//                ft.add(R.id.fragment_container, this.highScoreFragment)
//                fcurrent = this.highScoreFragment
//            }
//        } else if (page == 7) {
//            ft.hide(this.fcurrent)
//            ft.show(this.gameplayFragment)
//            fcurrent = this.gameplayFragment
//            this.gameplayFragment.setPause(false)
        }
        ft.commit()
    }

    override fun onPause() {
        super.onPause()
        mainMenuFragment.pauseSound()
    }

    override fun onResume() {
        super.onResume()
        if (fcurrent === mainMenuFragment/* || fcurrent === settingFragment*/) {
            mainMenuFragment.resumeSound()
        }
    }

    fun changeVolume(vol: Int) {
        mainMenuFragment.changeVolume(vol)
    }

    fun changeBackground(id: Int) {
        mainMenuFragment.changeBackground(id)
    }

    fun setDefault() {
        mainMenuFragment.setDefault()
    }

    fun setLevel(level: Int) {
//        this.gameplayFragment.setLevel(level)
//        this.pauseFragment.setLevel(level)
    }

    fun setGamePlayToLoseState() {
//        this.gameplayFragment.setLose()
    }

    fun setScore(score: Int, level: Int) {
//        this.gameOverFragment = GameOverFragment()
//        this.highScoreFragment = HighScoreFragment()
//        if (level == 0) {
//            this.gameOverFragment.setScore(score, level)
//            if (score > sharedPreferencesHighScore.getEasy()) {
//                this.sharedPreferencesHighScore.saveEasy(score)
//                this.highScoreFragment.setScore(score, level)
//                this.changePage(6)
//            } else {
//                this.changePage(5)
//            }
//        } else if (level == 1) {
//            this.gameOverFragment.setScore(score, level)
//            if (score > sharedPreferencesHighScore.getMed()) {
//                this.sharedPreferencesHighScore.saveMed(score)
//                this.highScoreFragment.setScore(score, level)
//                this.changePage(6)
//            } else {
//                this.changePage(5)
//            }
//        } else if (level == 2) {
//            this.gameOverFragment.setScore(score, level)
//            if (score > sharedPreferencesHighScore.getHard()) {
//                this.sharedPreferencesHighScore.saveHard(score)
//                this.highScoreFragment.setScore(score, level)
//                this.changePage(6)
//            } else {
//                this.changePage(5)
//            }
//        }
    }

    fun setPause(pause: Boolean) {
//        this.gameplayFragment.setPause(pause)
    }

    fun resume() {
//        this.changePage(7)
    }

    fun getVolume(): Int {
//        return this.settingFragment.getVolume()
        return 10
    }

    fun muteSoundPool(): Boolean {
        return mainMenuFragment.isMute()
    }
}
