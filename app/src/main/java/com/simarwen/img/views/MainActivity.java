package com.simarwen.img.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.simarwen.img.R;
import com.simarwen.img.controllers.ProfilController;
import com.simarwen.img.model.Profil;
import com.simarwen.img.outils.Serializer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }
    // propriétés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private ProfilController controller;

    private void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.radioHomme);
        rdFemme = (RadioButton) findViewById(R.id.radioFemme);
        lblIMG = (TextView) findViewById(R.id.lblImg);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        this.controller = ProfilController.getInstance(this);
        ecouteCalcul();
        recupProfil();
    }
    private void ecouteCalcul() {
        ((Button) findViewById(R.id.BtnCalcul)).setOnClickListener(v ->{

                    //Toast.makeText(MainActivity.this,  "Si Marwen Tarchoun", Toast.LENGTH_SHORT).show();

                    Integer poids = 0;
                    Integer taille = 0;
                    Integer age = 0;
                    Integer sexe = 0;

                    try {
                        poids = Integer.parseInt(txtPoids.getText().toString());
                        taille = Integer.parseInt(txtTaille.getText().toString());
                        age = Integer.parseInt(txtAge.getText().toString());
                    } catch (Exception e) {}
                    if (rdHomme.isChecked()) {
                        sexe = 1;
                    }

                    if (poids == 0 || taille == 0 || age == 0) {
                        Toast.makeText(MainActivity.this,  "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                    } else {

                        afficherResult(poids, taille, age, sexe);

                    }


                }



        );
    }


    private void afficherResult(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.controller.creerProfil(poids, taille, age, sexe,this);

        float img = this.controller.getImg();
        String message = this.controller.getMessage();

        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.happyface);
            lblIMG.setTextColor(Color.GREEN);
        } else {
            lblIMG.setTextColor(Color.RED);
            if (message == "trop faible") {
                imgSmiley.setImageResource(R.drawable.sadface);
            } else {
                imgSmiley.setImageResource(R.drawable.fat);
            }
        }

        lblIMG.setText(String.format("%.01f", img) + ": IMG " + message);


    }

    /*
     * récupération du profil s'il a été serialisé
     */
    private void recupProfil() {
        if (controller.getPoids() != null) {
            txtPoids.setText(controller.getPoids().toString());
            txtTaille.setText(controller.getTaille().toString());
            txtAge.setText(controller.getAge().toString());
            if (controller.getSexe() == 1) {
                rdHomme.setChecked(true);
            }
            ((Button)findViewById(R.id.BtnCalcul)).performClick();
        }
    }



}