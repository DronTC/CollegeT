package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val userLogin: EditText = findViewById(R.id.user_login)
        val userPassword: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_authorization)

        linkToReg.setOnClickListener{
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == "")
                showToast("Необходимо заполнить все поля")
            else{
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, password)

                if(isAuth){
                    showToast("Пользователь $login авторизован")
                    GlobalVariables.login = login
                    val intent = Intent(this, UserActivity::class.java)
                    startActivity(intent)
                }
                else
                    showToast("Пользователь $login не авторизован")

                userLogin.text.clear()
                userPassword.text.clear()
            }
        }
    }
    private fun showToast(str: String){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}