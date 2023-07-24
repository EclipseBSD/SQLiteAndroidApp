package com.sqlitebase.sqliteappbase.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sqlitebase.sqliteappbase.R
import com.sqlitebase.sqliteappbase.db.DatabaseManager
import com.sqlitebase.sqliteappbase.model.PersonData

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val dbManager = DatabaseManager(this)
    val person = PersonData(id = 1, name = "Vini", cpf = "405.281.842-23", age = 30)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this,"Bem vindo ao aplicativo", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onCreate(): ")

        Log.d("onCreate: ", "Creating person: $person")
    }

}
