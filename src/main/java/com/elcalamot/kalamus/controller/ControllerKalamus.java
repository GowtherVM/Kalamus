/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.controller;

import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.model_planetas.FuncionesModelo_Planetas;

import com.elcalamot.kalamus.model_planetas.SistemasDB;
import com.elcalamot.kalamus.persistencia.Persistencia;

/**
 *
 * @author Admin
 */
public class ControllerKalamus {

    private SistemasDB sistemas;
    private Persistencia persistencia;
    private DemanarDades demanar;

    public ControllerKalamus(SistemasDB sistemas, Persistencia persistencia, DemanarDades demanar) {
        this.sistemas = sistemas;
        this.persistencia = persistencia;
        this.demanar = demanar;
    }

    public void iniciarKalamus(String[] args) throws PlanetaExcepcio {
        FuncionesModelo_Planetas.testsPlanetas();

        switch (args[0]) {
            case "planet":
                 try {
                switch (args[1]) {

                    case "add":
                        FuncionesModelo_Planetas.crearPlaneta(args);
                        break;
                    case "list":
                        sistemas.listPlanetas();
                        break;
                    default:
                        System.out.println("Comando no existe");
                }
                break;
            } catch (PlanetaExcepcio e) {
                e.getMessage();
            }

            case "being":
                switch (args[1]) {
                    case "add":
                        break;
                    case "list":
                        break;
                    default:
                        System.out.println("Comando no existe");
                }
                break;
            default:
                System.out.println("Caso incorrecto.");

        }

    }
}
