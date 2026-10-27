package com.example.kiemtra_2374802010222

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
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
        val lvSkills = findViewById<ListView>(R.id.lv_skills)

        // Nhận dữ liệu Email được truyền từ LoginActivity qua Intent
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: "Chưa có dữ liệu"
        tvEmail.text = "Email: $email"

        // Câu 3: dữ liệu danh sách và ArrayAdapter
        val skills = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skills)
        lvSkills.adapter = adapter

        // Bắt sự kiện click vào từng item: hiển thị Toast đúng tên phần tử được chọn
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Bạn đã chọn: ${skills[position]}", Toast.LENGTH_SHORT).show()
        }

        // Đăng xuất: đóng ProfileActivity và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
