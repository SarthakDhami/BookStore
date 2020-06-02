package com.myapplication.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.myapplication.bookstore.Model.dataLogin
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_registartion.*
import kotlinx.android.synthetic.main.activity_registartion.textInput_ed_userName

class RegistartionActivity : AppCompatActivity() {
    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registartion)
        inputValidation = InputValidation(this)
        databaseHelper = DataBaseHelper(this)

        tv_alreadyMember.setOnClickListener { view->
            startActivity(Intent(this, LoginPageActivity::class.java))
            finish()

        }
        btn_registre.setOnClickListener { view->
            if (!inputValidation!!.isInputEditTextFilled(ed_userNameRegi, textInput_ed_userName, getString(R.string.error_message_name)))
            {return@setOnClickListener}
            if (!inputValidation!!.isInputEditTextMatches(ed_passwordRegi,ed_confirmpassword,textinput_Confirmpassword,
                    getString(R.string.error_password_match))){
                return@setOnClickListener
            }
            if (!inputValidation!!.isInputEditTextFilled(ed_passwordRegi, textinput_passwordRegi, getString(R.string.error_message_password))) {
                return@setOnClickListener
            }
            if (!inputValidation!!.isInputEditTextFilled(ed_confirmpassword, textinput_Confirmpassword, getString(R.string.error_message_password))) {
                return@setOnClickListener
            }

            if (!databaseHelper!!.checkUser(ed_userNameRegi!!.text.toString().trim())) {

                var user = dataLogin(username = ed_userNameRegi!!.text.toString().trim(),
                    passwword = ed_passwordRegi!!.text.toString().trim(),
                    extra = "extra")

                databaseHelper!!.addUser(user)
                startActivity(Intent(this, LoginPageActivity::class.java))
                finish()
                // Snack Bar to show success message that record saved successfully
                Snackbar.make(rel_main_regi, getString(R.string.success_message), Snackbar.LENGTH_LONG).show()
                emptyInputEditText()


            } else {
                // Snack Bar to show error message that record already exists
                Snackbar.make(rel_main_regi!!, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun emptyInputEditText() {
        ed_userNameRegi?.text = null
        ed_confirmpassword?.text = null
        ed_passwordRegi?.text = null
    }
}
