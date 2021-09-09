package com.example.kotlin1leson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1leson1.databinding.ActivityMainBinding
import com.example.kotlin1leson1.MainActivity.Companion.INTENT_TEXT as INTENT_TEXT

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   private val text = "Ведите текст!!"
    private val duration = Toast.LENGTH_SHORT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dataAcceptance()
        sendingData()
    }

    private fun sendingData() {
        val messages = intent.getStringExtra(INTENT_TEXT)
        binding.txtMainActivity.text = messages
    }

    private fun dataAcceptance() {
        binding.btn1.setOnClickListener{
            if (binding.etText.text.toString().trim().isEmpty()) {
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }else{
                val intent = Intent(this, SecondActivity::class.java)
                val message = binding.etText.text.toString()
                intent.putExtra("message_key", message)
                startActivity(intent)

            }

        }
    }

    companion object{
        const val INTENT_TEXT = "text"
    }

}