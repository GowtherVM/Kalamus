/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.vistas;

import com.elcalamot.kalamus.model.Planeta;

/**
 *
 * @author Admin
 */
public class Vistas {
    public static void mostrarPlaneta(Planeta planeta){
        System.out.println( planeta.getNomplan() + ": " + planeta.getClima() + " ,"+planeta.getPoblacio_max()+" , Flora vermella: " + planeta.getFlora_vermella()+" , Vida acuatica: " + planeta.getEssers_aquatics());
    }
}
