package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_interface)

        val buttonAdd: Button = findViewById(R.id.button_add)
        val taskList: LinearLayout = findViewById(R.id.tasks_list)
        val helloUser: TextView = findViewById(R.id.hello_textView)
        helloUser.text = "Приветствуем, ${GlobalVariables.login}"

        buttonAdd.setOnClickListener {
            val intent = Intent(this, add_user_activity::class.java)
            startActivity(intent)
        }
    }
}