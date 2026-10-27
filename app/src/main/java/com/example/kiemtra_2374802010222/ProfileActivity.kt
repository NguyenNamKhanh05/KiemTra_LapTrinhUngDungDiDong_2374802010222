package com.example.kiemtra_2374802010222

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_profile)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById
        val tvEmail = findViewById<TextView>(R.id.tv_email)
        val btnLogout = findViewById<Button>(R.id.btn_logout)

        // Nhận dữ liệu Email được truyền từ LoginActivity qua Intent
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: "Chưa có dữ liệu"
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng ProfileActivity và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
