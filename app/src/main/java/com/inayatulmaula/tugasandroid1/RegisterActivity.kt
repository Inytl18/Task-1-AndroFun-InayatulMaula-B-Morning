package com.inayatulmaula.tugasandroid1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var name : EditText
    private lateinit var pass : EditText
    private lateinit var confirmPass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name = findViewById(R.id.etName)
        pass = findViewById(R.id.etPass)
        confirmPass = findViewById(R.id.etConfirmPass)

        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnRegister -> {
                val bundle = Bundle()
                bundle.putString("username", name.text.toString())
                bundle.putString("password", pass.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}