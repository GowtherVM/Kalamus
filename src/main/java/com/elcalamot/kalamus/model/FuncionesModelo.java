/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FuncionesModelo {

    public static void crearPlaneta(String[] args) throws PlanetaExcepcio{
        SistemasDB sistemas = SistemasDB.getInstance();
        Enums.Clima clima = Enums.elegirClima(args[5]);
        Enums.Respuesta opcion1 = Enums.elegirOpcion(args[6]);
        Enums.Respuesta opcion2 = Enums.elegirOpcion(args[7]);
        if (sistemas.comprobarGalaxia(args[3].toUpperCase()) != null) {
            throw new PlanetaExcepcio(0);
        }
        sistemas.addGalaxia(args[3].toUpperCase());

        if (sistemas.comprobarPlaneta(args[2].toLowerCase(), args[3].toUpperCase()) != null) {
               throw new PlanetaExcepcio(1);
        }

        Planeta nuevoplaneta = new Planeta(args[2].toLowerCase(), Integer.parseInt(args[4]), clima, opcion1, opcion2);
        sistemas.addPlaneta(args[3].toUpperCase(), nuevoplaneta);
    }
    

}
