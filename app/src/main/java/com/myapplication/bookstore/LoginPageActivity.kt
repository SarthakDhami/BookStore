package com.myapplication.bookstore

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPageActivity : AppCompatActivity() {
    private lateinit var mSP : SP

    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        databaseHelper = DataBaseHelper(this)
        inputValidation = InputValidation(this)
        mSP = SP(this)
        var username = mSP.getString(this,SP_Keys.USERNAME,"s")
        var password = mSP.getString(this,SP_Keys.USERNAME,"s")

        if (username == "s" && password == "s"){

        }else{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        tv_noAccount.setOnClickListener  { view ->
            startActivity(Intent(this, RegistartionActivity::class.java))
            finish()
        }
        btn_login.setOnClickListener { view->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

            if (!inputValidation!!.isInputEditTextFilled(ed_userName, textInput_ed_userName, getString(R.string.error_message_email))) {
                return@setOnClickListener
            }
            if (!inputValidation!!.isInputEditTextFilled(ed_passwordlogin!!, textinput_passwordlogin!!, getString(R.string.error_message_email))) {
                return@setOnClickListener
            }
            if (databaseHelper!!.checkUser(ed_userName?.text.toString().trim { it <= ' ' }, ed_passwordlogin?.text.toString().trim { it <= ' ' })) {
                mSP.setString(this,SP_Keys.USERNAME,ed_userName?.text.toString().trim{it <=' '})
                mSP.setString(this,SP_Keys.PASSWORD,ed_passwordlogin?.text.toString().trim{it <=' '})

                val accountsIntent = Intent(this, MainActivity::class.java)
                accountsIntent.putExtra("EMAIL", ed_userName?.text.toString().trim { it <= ' ' })
                emptyInputEditText()
                startActivity(accountsIntent)
                finish()



            } else {


                // Snack Bar to show success message that record is wrong
                Snackbar.make(rel_loginMain, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show()
            }
            }
        }

    private fun emptyInputEditText() {
        ed_userName?.text = null
        ed_passwordlogin.text = null
    }
}