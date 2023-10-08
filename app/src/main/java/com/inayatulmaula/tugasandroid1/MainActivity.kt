package com.inayatulmaula.tugasandroid1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textIdentity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textIdentity = findViewById(R.id.tvIdentitas)

        val name = intent.getParcelableExtra<User>("User")?.name
        val pass = intent.getParcelableExtra<User>("User")?.pass
        textIdentity.text = "Username: $name dan Password: $pass"

        val btnImplicit: Button = findViewById(R.id.implicitBtn)
        btnImplicit.setOnClickListener(this)

        val btnFragment : Button = findViewById(R.id.btnfragment)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.implicitBtn -> {
                val intent = Intent()
                intent.putExtra("history", "Anda Sudah Login!")
                setResult(RESULT_OK, intent)
                finish()

//                val message = "Infinite Learning, Mobile Dev."
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
//                startActivity(intent)
            }

            R.id.btnfragment -> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}