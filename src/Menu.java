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

        double latitudO, longitudO;

        String cas;
        Scanner sc = new Scanner(System.in);

        LlegeixJSON llegeixJSON = new LlegeixJSON();
        Usuari[] usuaris = llegeixJSON.readJSON(submenu.mostraSubMenuJson());

        taulaHash = new TaulaHash(usuaris);

        ArrayList posts = taulaHash.extractPosts(taulaHash);

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
                    submenu.mostraSubMenuOrd(Integer.valueOf(cas), posts, 0, 0);
                    break;
                case "2":
                    System.out.print("Insereix-hi latitud: ");
                    latitudO = sc.nextDouble();
                    System.out.print("Insereix-hi longitud: ");
                    longitudO = sc.nextDouble();

                    submenu.mostraSubMenuOrd(Integer.valueOf(cas), posts, latitudO, longitudO);
                    break;
                case "3":
                    submenu.mostraSubMenuOrd(Integer.valueOf(cas),null, 0, 0);
                    break;
                case "4":
                    System.out.println("\nGracies per utilitzar el nostre programa !\n");
                    break;
                default:
                    System.out.println("\nError, opció incorrecta\n");

            }
        }while(!cas.equals("4"));
    }
}
