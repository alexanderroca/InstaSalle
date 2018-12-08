package Menus;

import Estructures_Auxiliars.TracteJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Classe que defineix el menú principal del programa, a partir d'aquesta
 * la resta de classes es relacionaran amb ella.
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Menu {

    /**
     *Procediment per visualitzar el menú principal, el qual s'executarà fins que no es seleccioni l'opció 4 (sortir)
     */
    public void mostraMenu(){
        SubMenu submenu = new SubMenu();
        TaulaHash taulaHash;

        double latitudO = 0, longitudO = 0;
        String username = null;
        int opcio = 0;

        String cas;
        Scanner sc = new Scanner(System.in);

        TracteJSON tracteJSON = new TracteJSON();
        Usuari[] usuaris = tracteJSON.readJSON(submenu.mostraSubMenuJson());

        taulaHash = new TaulaHash(usuaris);

        ArrayList<GsonObjects.Post> posts = null;

        // Pintem el menú
        do{
            System.out.println("Menu:");
            System.out.println("1. Segons temporalitat");
            System.out.println("2. Segons ubicació");
            System.out.println("3. Segons combinació de prioritats");
            System.out.println("4. Sortir\n");
            System.out.print("Sel·lecciona una opcio: ");
            cas = sc.nextLine();

            switch (cas) {
                case "1":
                    
                    opcio = Integer.valueOf(cas);
                    posts = taulaHash.extractPosts(taulaHash);
                    break;
                case "2":
                    
                    opcio = Integer.valueOf(cas);
                    System.out.print("Insereix-hi latitud: ");
                    latitudO = sc.nextDouble();
                    System.out.print("Insereix-hi longitud: ");
                    longitudO = sc.nextDouble();
                    posts = taulaHash.extractPosts(taulaHash);
                    break;
                case "3":
                    
                    opcio = Integer.valueOf(cas);
                    System.out.print("Insereix-hi nom usuari: ");
                    username = sc.nextLine();
                    try {
                        posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                    }catch(NullPointerException e){
                        opcio = 0;
                        System.out.println("L'usuari inserit no existeix.");
                    }
                    break;
                case "4":
                    
                    System.out.println("\nGracies per utilitzar el nostre programa !\n");
                    break;
                default:
                    
                    opcio = 0;
                    System.out.println("\nError, opció incorrecta\n");

            }
            
            if(opcio > 0){
                submenu.mostraSubMenuOrd(opcio,posts, latitudO, longitudO, username, taulaHash);
            }   //if
        }while(!cas.equals("4"));
    }
}
