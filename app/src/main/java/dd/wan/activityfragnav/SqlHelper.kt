package dd.wan.activityfragnav

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import dd.wan.activityfragnav.model.User
import java.lang.Exception

class SqlHelper(context: Context) :
    SQLiteOpenHelper(context, "Navigation", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE User (email TEXT, password TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS User")
        onCreate(db)
    }


    fun checkEmail(email: String): Boolean {
        var list = allData()
        for (item in list) {
            if (item.email.equals(email))
                return false
        }
        return true
    }

    fun insertData(email: String, password: String): Boolean {
        if (checkEmail(email)) {
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("email", email)
            contentValues.put("password", password)
            db.insert("User", null, contentValues)
            db.close()
            return true
        } else {
            return false
        }
    }

    fun updateData(email: String, password: String):
            Boolean {
        if (!checkEmail(email)) {
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("password", password)
            db.update("User", contentValues, "email = ?", arrayOf(email))
            db.close()
            return true
        }
        return false
    }

    fun allData(): ArrayList<User> {
        var arrayList: ArrayList<User> = ArrayList()
        val db = this.writableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("SELECT * FROM User", null)
        } catch (e: Exception) {
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
            do {
                val user = User(cursor.getString(0).toString(), cursor.getString(1).toString())
                arrayList.add(user)
            } while (cursor.moveToNext())
        }
        db.close()
        return arrayList
    }
}







