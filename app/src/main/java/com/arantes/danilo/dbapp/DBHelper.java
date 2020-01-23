package com.arantes.danilo.dbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danilo on 11/10/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static String NOME = "bdaula.db";
    private static int VERSAO = 1;

    public DBHelper(Context context) {
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE [usuario] (\n" +
                "[codigo] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "[nome] VARCHAR(60) NOT NULL, \n" +
                "[email] VARCHAR(60) NOT NULL, \n" +
                "[telefone] VARCHAR(12) NOT NULL\n" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
