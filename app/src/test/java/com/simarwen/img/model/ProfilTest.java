package com.simarwen.img.model;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {


    private Profil profil = new Profil(75, 168,  38,  0);

    private float img = (float) 32.4;
    private String message = "trop eleve";

    public void testGetImg() {
        assertEquals(img, profil.getImg(), (float) 0.1);

    }

    public void testGetMessage() {

        assertEquals(message, profil.getMessage());

    }
}