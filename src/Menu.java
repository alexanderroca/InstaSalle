import GsonObjects.Usuari;

import java.util.Scanner;

public class Menu {

    public void mostraMenu(){
        SubMenu submenu = new SubMenu();
        int cas;
        Scanner sc = new Scanner(System.in);

        llegeixJSON llegeixJSON = new llegeixJSON();
        Usuari[] usuaris = llegeixJSON.readJSON(submenu.mostraSubMenuJson());


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
