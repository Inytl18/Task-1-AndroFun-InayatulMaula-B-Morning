package com.inayatulmaula.tugasandroid1

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var name: EditText
    private lateinit var pass: EditText
    private lateinit var history: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.etname)
        pass = findViewById(R.id.etPassword)
        history = findViewById(R.id.history)

        val bundle = intent.extras
        if (bundle != null) {
            name.setText(bundle.getString("username"))
            pass.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.btnlogin)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnlogin -> {
                val intent = Intent (this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(name.text.toString(), pass.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}

