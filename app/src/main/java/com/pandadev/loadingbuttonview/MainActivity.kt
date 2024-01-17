package com.pandadev.loadingbuttonview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pandadev.loadingbuttonlibary.ButtonLoadingState
import com.pandadev.loadingbuttonview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loadingButton.borderRadius = 32f
        binding.loadingButton.textColor = Color.WHITE
        binding.loadingButton.setOnClickListener {

            if (binding.loadingButton.state == ButtonLoadingState.Loading) {
                binding.loadingButton.state = ButtonLoadingState.Text
            } else {
                binding.loadingButton.state = ButtonLoadingState.Loading
            }


        }
    }
}