package com.swati.programmingquestions

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val tag = "Programming Questions"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RotationalCipher
        val encrypt1 = RotationalCipher.encrypt("Zebra-493?", 3)
        Log.v(tag, encrypt1.toString())
        val encrypt2 = RotationalCipher.encrypt("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39)
        Log.v(tag, encrypt2.toString())
    }
}