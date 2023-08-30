package com.sqlitebase.sqliteappbase.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sqlitebase.sqliteappbase.R
import com.sqlitebase.sqliteappbase.databinding.ActivityMainBinding
import com.sqlitebase.sqliteappbase.db.DatabaseManager
import com.sqlitebase.sqliteappbase.model.PersonData

class MainActivity : AppCompatActivity() {

    val dbManager = DatabaseManager(this)
    private lateinit var binding: ActivityMainBinding
    private val person = PersonData(id = 1, name = "Vini", cpf = "405.281.842-23", age = 30)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this,"Bem vindo ao aplicativo", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onCreate(): ")


    }

}
