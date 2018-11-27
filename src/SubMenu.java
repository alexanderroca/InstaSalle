import java.util.Scanner;

/**
 *Classe que defineix els submenus que usarem per determinar quin JSON llegirà
 * i quin mètode d'ordenació s'usarà
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class SubMenu {

    /**
     *Procediment per visualitzar el submenú per seleccionar el mètode d'ordenació
     */
    public void mostraSubMenuOrd(){
        int cas;
        Scanner sc = new Scanner(System.in);

        // Pintem el menú:
        System.out.println("Metodes d'ordenacio:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quicksort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Radix Sort\n");
        System.out.print("Sel·lecciona una opcio: ");
        cas = sc.nextInt();


        switch (cas) {
            case 1:
                System.out.println("\nNo implementat\n");   //TODO: falten passar variables a submenu
                break;
            case 2:
                System.out.println("\nNo implementat\n");   //TODO: falten passar variables a submenu
                break;
            case 3:
                System.out.println("\nNo implementat\n");   //TODO: falten passar variables a submenu
                break;
            case 4:
                System.out.println("\nNo implementat\n");  //TODO: falten passar variables a submenu
                break;
            default:
                System.out.println("\nError, opció incorrecta\n");

        }
    }

    /**
     *Procediment per visualitzar el submenú per seleccionar el JSON (els JSONs estan en la carpeta jsons)
     * el qual voldrem llegir
     */
    public String mostraSubMenuJson(){
        int cas;
        Scanner sc = new Scanner(System.in);
        String json = "jsons/";
        // Pintem el menú:
        do {
            System.out.println("Fitxers JSON:");
            System.out.println("1. m_dataset.json");
            System.out.println("2. s_dataset.json");
            System.out.println("3. xs_dataset.json");
            System.out.print("Sel·lecciona una opcio: ");
            cas = sc.nextInt();


            switch (cas) {
                case 1:
                   json = json.concat("m_dataset.json");
                    break;
                case 2:
                    json = json.concat("s_dataset.json");
                    break;
                case 3:
                    json = json.concat("xs_dataset.json");
                    break;
                default:
                    System.out.println("\nError, opció incorrecta\n");

            }
        }while((cas != 1) &&(cas != 2) && (cas != 3));
        return json;
    }
}
