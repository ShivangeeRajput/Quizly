package com.example.quizly

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class LogIn : AppCompatActivity() {
    //declaring variables

    private lateinit var edt_email: EditText
    private lateinit var edt_password : EditText
    private lateinit var btnlogin: TextView
    private lateinit var btnsignupp : TextView
    //firebase
    private lateinit var mAuth : FirebaseAuth




    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()
        mAuth= FirebaseAuth.getInstance()


        edt_email=findViewById(R.id.edt_email)
        edt_password=findViewById(R.id.edt_password)
        btnsignupp=findViewById(R.id.btnsignupp)
        btnlogin= findViewById(R.id.btnlogin)



            //redirecting user to signup page
            btnsignupp.setOnClickListener{
                intent= Intent(this@LogIn,SignUp::class.java)
                startActivity(intent)
            }

            //logic for logging in user
                btnlogin.setOnClickListener{
                val email=edt_email.text.toString()
                val password=edt_password.text.toString()

                login(email,password);
            }
        }

        private fun login(email: String,password: String){
        //logic for logging in
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // code for logging in user
                        val intent=Intent(this@LogIn, MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this@LogIn,"User does not exist",Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }



