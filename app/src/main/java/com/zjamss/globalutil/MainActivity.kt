package com.zjamss.globalutil

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zjamss.library.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCall.setOnClickListener {
            PermissionX.request(
                this,
                android.Manifest.permission.CALL_PHONE,
                android.Manifest.permission.CAMERA
            ) { allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call() {
        startActivity(Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:10086")
        })
    }
}