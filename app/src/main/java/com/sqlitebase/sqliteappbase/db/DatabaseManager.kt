package com.sqlitebase.sqliteappbase.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.sqlitebase.sqliteappbase.helper.DatabaseHelper
import com.sqlitebase.sqliteappbase.model.PersonData

class DatabaseManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    // Inserindo os dados das pessoas pelo DB
    fun insertPerson(person: PersonData) {
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, person.name)
            put(DatabaseHelper.COLUMN_CPF, person.cpf)
            put(DatabaseHelper.COLUMN_AGE, person.age)
        }

        val db = dbHelper.writableDatabase
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    //Atualizando o banco de dados de pessoas
    fun updatePerson(person: PersonData) {
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, person.name)
            put(DatabaseHelper.COLUMN_CPF, person.cpf)
            put(DatabaseHelper.COLUMN_AGE, person.age)
        }

        val db = dbHelper.writableDatabase
        db.update(
            DatabaseHelper.TABLE_NAME,
            values,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(person.id.toString())
        )

    }

    // Deletando o ID do banco de dados
    fun deletePerson(id: Long) {
        val db = dbHelper.writableDatabase
        db.delete(
            DatabaseHelper.TABLE_NAME,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString())
        )
        db.close()
    }

    @SuppressLint("Range")
    fun getAllPerson() : List<PersonData>{
        val peopleList = mutableListOf<PersonData>()

        val db = dbHelper.readableDatabase
        val cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null)

        while(cursor.moveToNext()){
            val id = cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID))
            val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
            val cpf = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CPF))
            val age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE))

            val person = PersonData(id, name, cpf, age)
            peopleList.add(person)
        }

        cursor.close()
        db.close()
        return peopleList
    }


}