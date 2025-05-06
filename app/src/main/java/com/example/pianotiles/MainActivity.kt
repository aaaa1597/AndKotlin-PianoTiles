package com.example.pianotiles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainModelView: MainMenuViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainModelView = ViewModelProvider(this)[MainMenuViewModel::class.java]
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainMenuFragment.newInstance())
            .commit()
    }

    override fun onPause() {
        super.onPause()
        mainModelView.pauseSong()
    }

    override fun onResume() {
        super.onResume()
        mainModelView.resumeSong()
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
}
