package com.sqlitebase.sqliteappbase.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "peopledata.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME = "people"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CPF = "cpf"
        const val COLUMN_AGE = "age"

    }

    override fun onCreate(db: SQLiteDatabase) {

        val queryDatabase = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT NOT NULL,
                $COLUMN_CPF TEXT NOT NULL,
                $COLUMN_AGE INTEGER NOT NULL
            )
        """.trimIndent()

        db.execSQL(queryDatabase)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}