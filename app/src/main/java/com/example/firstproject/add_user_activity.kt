package com.example.firstproject

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class add_user_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val viewDate: TextView = findViewById(R.id.view_date)
        val buttonShowAlertDialog: Button = findViewById(R.id.button_show_alert_dialog)
        val buttonDatePicker : Button = findViewById(R.id.select_date_button)




        GettingCurrentDate(viewDate)

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            UpdateLable(myCalendar, viewDate)
        }

        buttonDatePicker.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        buttonShowAlertDialog.setOnClickListener {
            ShowDialog()
        }

    }
    fun GettingCurrentDate(viewDate : TextView){
        val dateFormat = SimpleDateFormat("d MMM yyyy")
        val currentDate = dateFormat.format(Date())
        val textDate = "Дата $currentDate"

        viewDate.text = textDate
    }
    fun UpdateLable(myCalendar: Calendar, viewDate: TextView){
        val sdf = SimpleDateFormat("d MMM yyyy")
        viewDate.text = "Дата ${sdf.format(myCalendar.time)}"
    }
    fun ShowDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val builder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Создание нового события")

        val mAlertDialog = builder.show()
        val button : Button = mDialogView.findViewById(R.id.dialogBtn)
        val editText : EditText = mDialogView.findViewById(R.id.et_editText)
        button.setOnClickListener {
            mAlertDialog.dismiss()
            Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
        }
    }
    fun CreateSubjectList(subjectList : List<Subject>){

    }
}