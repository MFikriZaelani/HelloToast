package com.example.hellotoast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mCount = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)


        buttonCountUp.setOnClickListener(View.OnClickListener {
            mCount++;
            if (mShowCount != null)
                mShowCount.text = mCount.toString()
        })
        buttonToast.setOnClickListener(View.OnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants+near+me")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

//            val tulisan: String = mShowCount?.text.toString()
//            val toast: Toast =
//                Toast.makeText(this, "Angka yang dimunculkan " + tulisan, Toast.LENGTH_LONG)
//            toast.show()
        })
    }
}
