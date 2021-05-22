package com.example.tp1arrayadapater;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private SQLiteDatabase db;
    private MySqLiteHelper dbHelper;
    private String[] lesColumns = { "_id","nom", "prenom" };
    public DataSource(Context context) {
        dbHelper = new MySqLiteHelper(context);
    }
    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    public Contact creerContact(String nom, String prenom) {
        ContentValues values = new ContentValues();
        values.put("nom", nom);
        values.put("prenom", prenom);
        long idAdherentInsere = db.insert("contact", null,values);
        Cursor myCursor = db.query("contact", lesColumns, "_id=" + idAdherentInsere, null, null,
                null, null);
        myCursor.moveToFirst();
        Contact c = new Contact(myCursor.getInt(0), myCursor.getString(1), myCursor.getString(2));
        myCursor.close();
        return c;
    }
    public void updateContact(Contact c){
        ContentValues values = new ContentValues();
        values.put("nom", c.getNom());
        values.put("prenom", c.getPrenom());
        db.update("contact", values, "_id" + " = ? ", new String[] { String.valueOf(c.getId()) });
    }
    public void deleteContact(Contact c) {
        long id = c.getId();
        db.delete("contact", "_id = " + id, null);
    }
    public List<Contact> getContacts() {
        List<Contact> lstContacts = new ArrayList<Contact>();
        Cursor myCursor = db.query("contact", lesColumns, null, null, null, null, null);
        myCursor.moveToFirst();
        while (!myCursor.isAfterLast()) {
            lstContacts.add(new Contact(myCursor.getInt(0), myCursor.getString(1),
                    myCursor.getString(2)));
            myCursor.moveToNext();
        }
        myCursor.close();
        return lstContacts;
    }
}

