package com.example.sharemessagetoanotherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharemessagetoanotherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.share.setOnClickListener {
            if (binding.editText.text.isNotEmpty()){
                shareMessage(binding.editText.text.toString())
            }else{
                binding.editText.error = "Required"
            }
        }
    }

    private fun shareMessage(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(Intent.createChooser(intent, "Share Message"))
    }
}