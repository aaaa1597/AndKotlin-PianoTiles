package com.example.pianotiles

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("aaaaa", "onCreate aaaaaaaaaa")
    }

    override fun onResume() {
        super.onResume()
        Log.d("aaaaa", "onResume aaaaaaaaaa")
    }

    override fun onPause() {
        super.onPause()
        Log.d("aaaaa", "onPause aaaaaaaaaa")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("aaaaa", "onDestroy aaaaaaaaaa")
    }
}