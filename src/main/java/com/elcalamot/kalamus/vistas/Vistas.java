/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.vistas;

import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Kingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.model_planetas.Planeta;

/**
 *
 * @author Admin
 */
public class Vistas {
    public static void mostrarPlaneta(Planeta planeta){
        System.out.println( planeta.getNomplan() + ": " + planeta.getClima() + " ,"+planeta.getPoblacio_max()+" , Flora vermella: " + planeta.getFlora_vermella()+" , Vida acuatica: " + planeta.getEssers_aquatics());
    }
    
    public static void mostrarHumans(Humans huma){
        System.out.println("            Nombre: "+ huma.getNom());
        System.out.println("                Edad: "+huma.getEdad());
        System.out.println("                Genere: "+huma.getGenere());
    }
    public static void mostrarAndorians(Andorians andor){
        System.out.println("            Nombre: "+ andor.getNom());
        System.out.println("                Rango: "+ andor.getRango().toString());
    }
    public static void mostrarFerengi(Ferengi fer){
        System.out.println("            Nombre: "+ fer.getNom());
        System.out.println("                Latinum: "+ fer.getLatinum());
    }
    public static void mostrarKlingon(Kingon kling){
        System.out.println("            Nombre: "+ kling.getNom());
        System.out.println("                Fuerza: "+ kling.getFuerza());
    }
    public static void mostrarNibirians(Nibirians nib){
        System.out.println("            Nombre: "+ nib.getNom());
        System.out.println("                Peix: "+ nib.isPeix());
    }
    
    public static void mostrarVulcanians(Vulcanians vulc){
        System.out.println("            Nombre: "+ vulc.getNom());
        System.out.println("                Meditacio: "+ vulc.getMeditacio());
    }
    
}
