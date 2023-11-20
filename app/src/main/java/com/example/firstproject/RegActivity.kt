package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userPassword: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val toggleButtonGroup: com.google.android.material.button.MaterialButtonToggleGroup =
            findViewById(R.id.toggle_button_group)
        val linkToReg: TextView = findViewById(R.id.link_to_auth)
        var role: String = ""

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        toggleButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->
            if(isChecked){
                when(checkedId){

                    R.id.student_button -> role = "student"
                    R.id.lecturer_button -> role = "lecturer"
                }
            }
            else{
                if(toggleButtonGroup.checkedButtonId == View.NO_ID)
                    role = ""
            }
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == "" || role == "")
                showToast("Необходимо заполнить все поля")
            else{
                val user = User(login, password, role)

                val db = DbHelper(this, null)
                db.addUser(user)
                showToast("Пользователь $login добавлен",)
                GlobalVariables.login = login
                userLogin.text.clear()
                userPassword.text.clear()

                val intent = Intent(this, add_user_activity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun showToast(str: String){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}