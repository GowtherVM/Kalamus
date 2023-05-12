/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.exceptions.PlanetaException;
import com.elcalamot.kalamus.persistencia.Persistencia;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FuncionesModelo_Planetas {

    public static void crearPlaneta(String[] args) throws IOException {

        try {
            SistemasDB sistemas = SistemasDB.getInstance();
            Enums.Clima clima = Enums.elegirClima(args[5]);

            if (sistemas.comprobarGalaxia(args[3].toUpperCase()) == null) {

                sistemas.addGalaxia(args[3].toUpperCase());
                System.out.println("Se ha generado una nueva galaxia llamada " + args[3].toUpperCase());
            } else {
                System.out.println("La galaxia ya existia.");

            }

            if (sistemas.comprobarPlaneta(args[2].toLowerCase()) == null) {
                Planeta nuevoplaneta = new Planeta(args[2].toLowerCase(), Integer.parseInt(args[4]), clima, args[6], args[7]);
                sistemas.addPlaneta(args[3].toUpperCase(), nuevoplaneta);
                Persistencia.anadirPlaneta(nuevoplaneta, args[3].toUpperCase());
                System.out.println("Se ha generado el nuevo planeta " + nuevoplaneta.getNomplan() + " en la galaxia " + args[3].toUpperCase());
            } else {
                System.out.println("El planeta ya existia.");
            }

        } catch (PlanetaException e) {
            System.out.println("Error crear planeta.");
        }
    }


    public static boolean elegirOpcion(String opcio, String mensaje) throws PlanetaException {
        if (opcio.equalsIgnoreCase("si")) {
            return true;
        } else if (opcio.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println(mensaje);
        }

        return false;

    }

}
