package com.example.bai_tap_tuan_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bai_tap_tuan_2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val ageStr = edtAge.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty()) {
                tvResult.text = "Vui lòng nhập đầy đủ thông tin!"
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null || age < 0) {
                tvResult.text = "Tuổi không hợp lệ!"
                return@setOnClickListener
            }

            val category = when {
                age >= 65 -> "Người già"
                age in 18..64 -> "Người lớn"
                age in 6..17 -> "Trẻ em"
                else -> "Em bé"
            }

            tvResult.text = "Tên: $name\nPhân loại: $category"
        }
    }
}
