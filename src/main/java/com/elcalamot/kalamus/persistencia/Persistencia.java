/*+
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.persistencia;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.exceptions.PlanetaException;

import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.Ferengi;
import static com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers.getPeix;

import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.SistemasDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class Persistencia {

    public void comprobarRuta(String nombre, String extension) throws IOException {

        File directorio = new File(System.getProperty("user.home") + "/.kalamus");
        if (!directorio.exists()) {
            directorio.mkdir();

        }

        File file = new File(System.getProperty("user.home") + "/.kalamus/" + nombre + extension);

        if (!file.exists()) {

            file.createNewFile();
            FileWriter archivo = new FileWriter(file, true);
            PrintWriter write = new PrintWriter(archivo);
            if (nombre.equalsIgnoreCase("/planets")) {
                write.println("nom_planeta,galaxia,poblacio_max,clima,flora_vermella,essets_aquatics,poblacio_actual");
            }

            write.close();

        }

    }

    public static void anadirEsser(Essers esser, Planeta planeta) throws IOException {
        SistemasDB sis = SistemasDB.getInstance();
        String galaxia = sis.devolverGalaxiaP(planeta.getNomplan());
        File file = new File(System.getProperty("user.home") + "/.kalamus/beings.csv");
        String contenido = "ERROR";

        if (esser instanceof Humans) {
            Humans huma = (Humans) esser;
            contenido = huma.getNom() + "," + "huma" + "," + huma.getEdad() + "," + huma.getGenere() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Andorians) {
            Andorians andor = (Andorians) esser;
            contenido = andor.getNom() + "," + "andoria" + "," + andor.getRango() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Ferengi) {
            Ferengi fer = (Ferengi) esser;
            contenido = fer.getNom() + "," + "ferengi" + "," + fer.getLatinum() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Klingon) {
            Klingon kin = (Klingon) esser;
            contenido = kin.getNom() + "," + "klingon" + "," + kin.getFuerza() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Nibirians) {
            Nibirians nib = (Nibirians) esser;
            contenido = nib.getNom() + "," + "nibiria" + "," + nib.isPeix() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        } else if (esser instanceof Vulcanians) {
            Vulcanians vul = (Vulcanians) esser;
            contenido = vul.getNom() + "," + "vulcania" + "," + vul.getMeditacio() + "," + planeta.getNomplan().toLowerCase() + "," + galaxia.toUpperCase();
        }

        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }

    public static void anadirPlaneta(Planeta planeta, String galaxia) throws IOException {
        String contenido = planeta.getNomplan() + "," + galaxia + "," + String.valueOf(planeta.getPoblacio_max()) + "," + planeta.getClima() + "," + planeta.getFlora_vermella() + "," + planeta.getEssers_aquatics() + "," + planeta.getLista().size();
        File file = new File(System.getProperty("user.home") + "/.kalamus/planets.csv");
        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }

    public void buscarAlgo(String buscar, File fil) throws FileNotFoundException, IOException {

        BufferedReader archivo = new BufferedReader(new FileReader(fil));
        String linea;

        while ((linea = archivo.readLine()) != null) {
            if (linea.contains(buscar.toUpperCase())) {

                System.out.println(linea);

            }
        }

    }

    public static void cambiarDatosP(String tipodedato, String nuevodato, String planeta) throws FileNotFoundException, IOException {
        SistemasDB sis = SistemasDB.getInstance();
        File file = new File(System.getProperty("user.home") + "/.kalamus/planets.csv");
        Planeta plan = sis.comprobarPlaneta(planeta);
        BufferedReader archivo = new BufferedReader(new FileReader(file));
        String linea;
        String antiguo = "0";
        StringBuilder Output = new StringBuilder();
        while ((linea = archivo.readLine()) != null) {
            if (linea.contains(planeta.toLowerCase()) && linea != null) {
                antiguo = linea;
                String[] split = linea.split(",");
                switch (tipodedato.toLowerCase()) {
                    case "nom_planeta":
                        split[0] = nuevodato;
                        break;
                    case "galaxia":
                        split[1] = nuevodato;
                        break;
                    case "poblacio_max":
                        split[2] = nuevodato;
                        break;
                    case "clima":
                        split[3] = nuevodato;
                        break;
                    case "flora_vermella":
                        split[4] = nuevodato;
                        break;
                    case "essers_aquatics":
                        split[5] = nuevodato;
                        break;
                    case "poblacio_actual":
                        System.out.println("hola");
                        split[6] = String.valueOf(plan.getLista().size());
                        String nuevo = String.join(",", split);
                        Output.append(linea.replace(linea,nuevo));
                        break;
                    default:
                        System.out.println("No existe este tipo de dato.");

                }

            }
        }

        
        

    }

    public static void generarDBP() throws FileNotFoundException, IOException, PlanetaException {
        System.out.println(".");
        SistemasDB db = SistemasDB.getInstance();
        String galaxia;
        File file = new File(System.getProperty("user.home") + "/.kalamus/planets.csv");
        BufferedReader archivo = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = archivo.readLine()) != null) {
            if (!linea.contains("nom_planeta,")) {
                String[] split = linea.split(",");
                galaxia = split[1];
                Planeta añadir = new Planeta(split[0], Integer.parseInt(split[2]), Enums.elegirClima(split[3]), split[4], split[5]);
                if (db.comprobarGalaxia(galaxia) == null) {
                    db.addGalaxia(galaxia);
                }

                db.addPlaneta(galaxia, añadir);
            }
        }
    }

    public static void generarDBE() throws FileNotFoundException, IOException, PlanetaException {
        System.out.println(".");
        SistemasDB db = SistemasDB.getInstance();
        Planeta planeta;
        File file = new File(System.getProperty("user.home") + "/.kalamus/beings.csv");
        BufferedReader archivo = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = archivo.readLine()) != null) {

            String[] split = linea.split(",");
            switch (split[1].toLowerCase()) {
                case "huma":

                    planeta = db.comprobarPlaneta(split[4].toLowerCase());
                    Humans huma = new Humans(split[0].toLowerCase(), "huma", Integer.parseInt(split[2]), split[3]);
                    planeta.addEsser(huma);

                    break;
                case "andoria":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Andorians andor = new Andorians(split[0].toLowerCase(), "andoria", split[2]);

                    planeta.addEsser(andor);

                    break;
                case "ferengi":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Ferengi fer = new Ferengi(split[0].toLowerCase(), "ferengi", Double.parseDouble(split[2]));
                    planeta.addEsser(fer);

                    break;
                case "vulcania":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Vulcanians vulc = new Vulcanians(split[0].toLowerCase(), "vulcania", Integer.parseInt(split[2]));
                    planeta.addEsser(vulc);
                    break;
                case "nibirian":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Nibirians nib = new Nibirians(split[0].toLowerCase(), "nibiria", getPeix(split[2]));
                    planeta.addEsser(nib);

                    break;

                case "klingon":
                    planeta = db.comprobarPlaneta(split[3].toLowerCase());
                    Klingon kling = new Klingon(split[0].toLowerCase(), "klingon", Integer.parseInt(split[2]));
                    planeta.addEsser(kling);

                    break;

            }

        }
    }

}
