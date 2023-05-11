/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import static com.elcalamot.kalamus.enums.Enums.Clima.CALID;
import static com.elcalamot.kalamus.enums.Enums.Clima.FRED;
import static com.elcalamot.kalamus.enums.Enums.Esser.ANDORIANS;
import static com.elcalamot.kalamus.enums.Enums.Esser.VULCANIANS;
import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.SistemasDB;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author A200238614
 */
public class FuncionesModelo_Essers {

    public static void crearEsser(String[] args) throws IOException {
        SistemasDB sis = SistemasDB.getInstance();
        Planeta planeta = sis.comprobarPlaneta(args[4]);

        switch (args[3].toLowerCase()) {
            case "huma":
                if (DemanarDades.demanarEnter(Integer.parseInt(args[5]), 0, 130, "La edad a de ser mes gran que ") == true) {

                    Humans huma = new Humans(args[2], "humans", Integer.parseInt(args[5]), args[6]);
                    planeta.addEsser(huma);
                }

                break;
            case "andoria":

                Andorians andor = new Andorians(args[2], "andorians", args[5]);

                if (reglasVA(andor, planeta) == true) {
                    planeta.addEsser(andor);
                }
                break;
            case "ferengi":
                if (reglasFerengi(planeta) == true && DemanarDades.demanarEnter(Integer.parseInt(args[5]), 0, "La edad a de ser mes gran que ") == true) {
                    Ferengi fer = new Ferengi(args[2], "ferengi", Double.parseDouble(args[5]));
                    planeta.addEsser(fer);
                }
                break;
            case "vulcania":
                if (DemanarDades.demanarEnter(Integer.parseInt(args[5]), 0, 10, "La meditacio a de ser mes gran que ") == true) {
                    Vulcanians vulc = new Vulcanians(args[2], "vulcanians", Integer.parseInt(args[5]));
                    if (reglasVA(vulc, planeta) == true) {
                        planeta.addEsser(vulc);
                    }
                }
                break;
            case "nibirian":
                Nibirians nib = new Nibirians(args[2], "nibirians", getPeix(args[5]));

                if (reglasNibirians(nib, planeta) == true) {
                    planeta.addEsser(nib);
                }
                break;

            case "klingon":
                if (reglasKlingon(planeta) == true && DemanarDades.demanarEnter(Integer.parseInt(args[5]), 50, 350, "La força a de ser mes gran que ") == true) {
                    Klingon kling = new Klingon(args[2], "klingon", Integer.parseInt(args[5]));
                    planeta.addEsser(kling);
                }
                break;

        }
    }

    public static String getGenere(boolean opcio) {
        if (opcio == true) {
            return "masculi";
        } else if (opcio == false) {
            return "femeni";
        }

        return "femenino";

    }

    public static boolean getPeix(String opcio) {
        if (opcio.equalsIgnoreCase("si")) {
            return true;
        } else if (opcio.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Opcio incorrecta amb la alimentacio.");
        }

        return false;

    }

    public static String getPeix(boolean opcio) {
        if (opcio == true) {
            return "Si";
        } else if (opcio == false) {
            return "No";
        }

        return "No";

    }

    public static boolean elegirGenere(String opcio, String mensaje) {
        if (opcio.equalsIgnoreCase("masculi")) {
            return true;
        } else if (opcio.equalsIgnoreCase("femeni")) {
            return false;
        } else {
            System.out.println(mensaje);
        }

        return false;

    }

    public static boolean reglasVA(Essers va, Planeta destino) {
        ArrayList<Essers> poblacion_planeta = destino.getLista();
        switch (va.getEsser()) {
            case VULCANIANS:
                for (Essers esser : poblacion_planeta) {
                    if (esser.getEsser() == ANDORIANS) {
                        System.out.println("Un Vulcania no pot conbiura amb un Andoria.");
                        return false;
                    }
                }
                break;
            case ANDORIANS:
                for (Essers esser : poblacion_planeta) {
                    if (esser.getEsser() == VULCANIANS) {
                        System.out.println("Un Andoria no pot conbiura amb un Vulcania");
                        return false;

                    }
                }
                break;
        }

        return true;
    }

    public static boolean reglasKlingon(Planeta destino) {
        if (destino.getClima() == CALID) {
            System.out.println("Klingon no pot viura en clima CALID.");
            return false;
        }

        return true;
    }

    public static boolean reglasFerengi(Planeta destino) {
        if (destino.getClima() == FRED) {
            System.out.println("Ferengi no pot viura en clima FRED.");
            return false;
        }

        return true;
    }

    public static boolean reglasNibirians(Nibirians nib, Planeta destino) {
        if (destino.getFlora_vermella().equalsIgnoreCase("No")) {
            System.out.println("Nibirians necesiten flora vermella.");
            return false;
        }
        if (nib.isPeix().equalsIgnoreCase("Si") && destino.getEssers_aquatics().equalsIgnoreCase("No")) {
            System.out.println("Aquet Nibiria necesita peixus al planeta.");
            return false;
        }

        return true;
    }

    public static void testEssers() {
        SistemasDB sis = SistemasDB.getInstance();
        Planeta tierra = sis.comprobarPlaneta("Tierra");
        Planeta marte = sis.comprobarPlaneta("Marte");

        Humans nuevo = new Humans("Sarah", "humans", 21, "femeni");
        Humans nuevo1 = new Humans("Pau", "humans", 23, "masculi");
        Klingon kling = new Klingon("Eric", "klingon", 5);
        Nibirians nib = new Nibirians("Nibpez","nibirians",true);
        Andorians andor = new Andorians("Andor1", "andorians","defensor");
        Vulcanians vulc = new Vulcanians("Vulc1","vulcanians",5);
        tierra.addEsser(vulc);
        
        if (reglasVA(andor, tierra) == true) {
                    tierra.addEsser(andor);
                }
        
        if (reglasNibirians(nib, marte) == true) {
                    marte.addEsser(nib);
                }
        
        tierra.addEsser(nuevo);
        tierra.addEsser(nuevo1);
        if (reglasKlingon(marte) == true){
            marte.addEsser(kling);
        }
        
    }
}
