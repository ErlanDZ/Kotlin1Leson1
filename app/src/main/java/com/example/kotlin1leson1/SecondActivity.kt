package com.example.kotlin1leson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1leson1.MainActivity.Companion.INTENT_TEXT
import com.example.kotlin1leson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val text = "нет данных для отображения"
    private val duration = Toast.LENGTH_SHORT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dataAcceptance()
        sendingData()
    }

    private fun sendingData() {
        binding.btn2.setOnClickListener{
            if (binding.txtText.text.toString().trim().isEmpty()) {
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                val message = binding.txtText.text.toString()
                intent.putExtra(INTENT_TEXT, message)
                startActivity(intent)

            }

        }
    }

    private fun dataAcceptance() {
        val message = intent.getStringExtra("message_key")
        binding.txtText.text = message
    }
}