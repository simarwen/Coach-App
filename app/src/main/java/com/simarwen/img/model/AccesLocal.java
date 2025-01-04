package com.simarwen.img.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simarwen.img.outils.MySqlLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AccesLocal {
    //private static final String TAG = "MainActivity";

    // propriétés
    private String nomBase = "bdCoach.sqlite";
    private Integer versionBase = 1;
    private MySqlLiteOpenHelper accesBD;

    private SQLiteDatabase bd;

    // Constructeur
    // @param contexte
    public AccesLocal(Context contexte) {
        accesBD = new MySqlLiteOpenHelper(contexte, nomBase, null, versionBase);
    }

    // ajouter d'un profil dans la db
    //Pour corriger la vulnérabilité d'injection SQL, utilisez des requêtes paramétrées:

    public void ajouter(Profil profil) {
        bd = accesBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("datemesure", profil.getdateMesure().toString());
        values.put("poids", profil.getPoids());
        values.put("taille", profil.getTaille());
        values.put("age", profil.getAge());
        values.put("sexe", profil.getSexe());
        bd.insert("profil", null, values);
    }

    public Profil recupDernier() {
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        Profil profil = null;
        String req = "select * from profil";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast()) {
            String dateStr = curseur.getString(curseur.getColumnIndexOrThrow("datemesure"));
            int poids = curseur.getInt(curseur.getColumnIndexOrThrow("poids"));
            int taille = curseur.getInt(curseur.getColumnIndexOrThrow("taille"));
            int age = curseur.getInt(curseur.getColumnIndexOrThrow("age"));
            int sexe = curseur.getInt(curseur.getColumnIndexOrThrow("sexe"));

            //Convertissez dateStr en objet Date à l'aide de SimpleDateFormat .
            profil = new Profil( poids, taille, age, sexe,convertToDate(dateStr));

            //Log.d(TAG, "profil => "+profil);

        }
        curseur.close();
        return profil;
    }


    // Convertir dateStr en objet Date à l'aide de SimpleDateFormat
    private Date convertToDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }














}
