package com.simarwen.img.controllers;

import android.content.Context;

import com.simarwen.img.model.AccesLocal;
import com.simarwen.img.model.Profil;
import com.simarwen.img.outils.Serializer;

import java.util.Date;

public final class ProfilController {

    private static ProfilController instance = null;
    private static Profil profil;
    private static String monFic = "saveprofile";
    private static AccesLocal accesLocal ;

    private ProfilController() {
        super();
    }

    /**
     *
     * @return
     */
    public static final ProfilController getInstance(Context context) {
        if (ProfilController.instance == null) {
            ProfilController.instance = new ProfilController();
            accesLocal = new AccesLocal(context);
            profil= accesLocal.recupDernier();
           // recupSerialize(context);
        }
        return ProfilController.instance;
    }

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context) {
        profil = new Profil(poids, taille, age, sexe,new Date());
       accesLocal.ajouter(profil);
       ///Serializer.serialize(monFic, profil, context);
    }

    /**
     *
     * @return
     */

    public float getImg() {
        return profil.getImg();
    }

    public String getMessage() {
        return profil.getMessage();
    }

    private static void recupSerialize(Context contexte) {
        profil = (Profil) Serializer.deSerialize(monFic, contexte);
    }

    public Integer getPoids() {
        if (profil == null) {
            return null;
        } else {
            return profil.getPoids();
        }
    }

    public Integer getTaille() {
        if (profil == null) {
            return null;
        } else {
            return profil.getTaille();
        }
    }

    public Integer getAge() {
        if (profil == null) {
            return null;
        } else {
            return profil.getAge();
        }
    }

    public Integer getSexe() {
        if (profil == null) {
            return null;
        } else {
            return profil.getSexe();
        }

    }

}
