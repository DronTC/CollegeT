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
        val task: EditText = findViewById(R.id.task_add)
        val taskList: LinearLayout = findViewById(R.id.tasks_list)
        val helloUser: TextView = findViewById(R.id.hello_textView)
        helloUser.text = "Приветствуем, ${GlobalVariables.login}"

        buttonAdd.setOnClickListener {
            var taskText = task.text.toString().trim()

            if(taskText==""){
                Toast.makeText(this, "Необходимо заполнить поле",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                val textView = TextView(this)
                textView.text = taskText
                taskList.addView(textView)
            }
        }
    }
}