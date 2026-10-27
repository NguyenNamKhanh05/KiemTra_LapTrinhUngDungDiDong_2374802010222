package com.example.kiemtra_2374802010222

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById (không dùng ViewBinding)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtPassword = findViewById<EditText>(R.id.edt_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            // Kiểm tra dữ liệu theo thứ tự, lỗi đầu tiên được thông báo
            val errorMessage = when {
                email.isEmpty() && password.isEmpty() -> "Vui lòng nhập Email và Mật khẩu!"
                email.isEmpty() -> "Vui lòng nhập Email!"
                password.isEmpty() -> "Vui lòng nhập Mật khẩu!"
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Email không đúng định dạng!"
                password.length < 6 -> "Mật khẩu phải có ít nhất 6 ký tự!"
                else -> null
            }

            if (errorMessage != null) {
                tvStatus.text = errorMessage
                tvStatus.setTextColor(getColor(R.color.status_error))
            } else {
                tvStatus.text = "Xác thực thành công!"
                tvStatus.setTextColor(getColor(R.color.status_success))
            }
        }
    }
}
