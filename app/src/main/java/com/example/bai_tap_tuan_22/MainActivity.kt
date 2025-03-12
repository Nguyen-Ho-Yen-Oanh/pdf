package com.example.bai_tap_tuan_22

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtStaff: EditText
    private lateinit var btnChange: Button
    private lateinit var btnAdd: Button
    private lateinit var bookListLayout: LinearLayout
    private lateinit var txtManage: TextView
    private lateinit var txtBooks: TextView
    private lateinit var txtStaff: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View từ layout
        edtStaff = findViewById(R.id.edtStaff)
        btnChange = findViewById(R.id.btnChange)
        btnAdd = findViewById(R.id.btnAdd)
        bookListLayout = findViewById(R.id.bookListLayout)
        txtManage = findViewById(R.id.txtManage)
        txtBooks = findViewById(R.id.txtBooks)
        txtStaff = findViewById(R.id.txtStaff)

        // Xử lý sự kiện khi bấm "Cập nhật"
        btnChange.setOnClickListener {
            val staffName = edtStaff.text.toString().trim()
            if (staffName.isNotEmpty()) {
                Toast.makeText(this, "Nhân viên cập nhật: $staffName", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng nhập tên nhân viên", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý sự kiện khi bấm "Thêm sách"
        btnAdd.setOnClickListener {
            addNewBook()
        }

        // Xử lý thanh điều hướng
        txtManage.setOnClickListener {
            Toast.makeText(this, "Chuyển đến trang Quản lý", Toast.LENGTH_SHORT).show()
        }

        txtBooks.setOnClickListener {
            Toast.makeText(this, "Chuyển đến trang Danh sách Sách", Toast.LENGTH_SHORT).show()
        }

        txtStaff.setOnClickListener {
            Toast.makeText(this, "Chuyển đến trang Nhân viên", Toast.LENGTH_SHORT).show()
        }
    }

    // Hàm thêm sách mới vào danh sách
    private fun addNewBook() {
        val newBook = CheckBox(this)
        newBook.text = "Sách Mới"
        newBook.textSize = 16f
        newBook.setPadding(8, 8, 8, 8)

        // Thêm vào layout danh sách sách
        bookListLayout.addView(newBook)
        Toast.makeText(this, "Đã thêm sách mới!", Toast.LENGTH_SHORT).show()
    }
}
