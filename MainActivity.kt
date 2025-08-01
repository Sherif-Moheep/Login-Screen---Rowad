package com.example.loginscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSignUp.setOnClickListener {
            if (validatePassword()) {
                Toast.makeText(this, "Passwords match!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnGoogleSignUp.setOnClickListener {
            Toast.makeText(this, "Signing up with Google", Toast.LENGTH_SHORT).show()
        }

        binding.btnFacebookSignUp.setOnClickListener {
            Toast.makeText(this, "Signing up with Facebook", Toast.LENGTH_SHORT).show()
        }

        binding.btnTwitterSignUp.setOnClickListener {
            Toast.makeText(this, "Signing up with Twitter", Toast.LENGTH_SHORT).show()
        }
    }

    fun validatePassword(): Boolean {
        val password = binding.etPassword.text.toString()
        val confirmPassord = binding.etConfirmPassword.text.toString()
        return password == confirmPassord
    }
}

