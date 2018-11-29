import GsonObjects.Usuari;

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

        int cas;
        Scanner sc = new Scanner(System.in);

        llegeixJSON llegeixJSON = new llegeixJSON();
        Usuari[] usuaris = llegeixJSON.readJSON(submenu.mostraSubMenuJson());

        taulaHash = new TaulaHash(usuaris);

        // Pintem el menú
        do{
            System.out.println("Menu:");
            System.out.println("1. Segons temporalitat");
            System.out.println("2. Segons ubicació");
            System.out.println("3. Segons combinació de prioritats");
            System.out.println("4. Sortir\n");
            System.out.print("Sel·lecciona una opcio: ");
            cas = sc.nextInt();


            switch (cas) {
                case 1:
                    System.out.println("\nNo implementat\n");
                    //TODO: passar els camps: opcio d'ordenacio, taulaHash
                    submenu.mostraSubMenuOrd();
                    break;
                case 2:
                    System.out.println("\nNo implementat\n");
                    submenu.mostraSubMenuOrd();
                    break;
                case 3:
                    System.out.println("\nNo implementat\n");
                    submenu.mostraSubMenuOrd();
                    break;
                case 4:
                    System.out.println("\nGracies per utilitzar el nostre programa !\n");
                    break;
                default:
                    System.out.println("\nError, opció incorrecta\n");

            }
        }while(cas != 4);
    }
}
