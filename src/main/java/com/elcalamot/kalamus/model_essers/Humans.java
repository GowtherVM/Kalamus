/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

/**
 *
 * @author A200238614
 */
public class Humans extends Essers {
    private int edad;
    private boolean genere;

    public Humans(String esser,int edad, String genere) {
        super(esser);
        this.edad = edad;
        this.genere = FuncionesModelo_Essers.elegirGenere(genere, "");
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenere() {
        String genere = FuncionesModelo_Essers.getGenere(this.genere, "");
        return genere;
    }

    public void setGenere(String genere) {       
        this.genere = FuncionesModelo_Essers.elegirGenere(genere, "");
    }
    
    
    
}
