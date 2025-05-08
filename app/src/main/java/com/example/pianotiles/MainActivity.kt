package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
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

        /* 縦画面固定 */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

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
}
