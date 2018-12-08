package Menus;

import Estructures_Auxiliars.Interessos;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.RadixSort;
import Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Hashtable;
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
    public void mostraSubMenuOrd(int opcio, ArrayList<Post> posts, double latitudO, double longitudO, String username,
                                 TaulaHash taulaHash){
        String cas;
        Scanner sc = new Scanner(System.in);

        Interessos interessos = null;

        // Pintem el menú:
        System.out.println("Metodes d'ordenacio:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quicksort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Radix Sort\n");
        System.out.print("Sel·lecciona una opcio: ");
        cas = sc.nextLine();

        switch (cas) {
            case "1":
                System.out.println("\nNo implementat\n");
                break;
            case "2":
                System.out.println("\nNo implementat\n");
                break;
            case "3":

                SelectionSort selectionSort = new SelectionSort();
                if(opcio == 3){
                    interessos = taulaHash.extractInteressos(taulaHash.getHashtable(), username);
                }   //if
                posts = selectionSort.selectionSort(posts, latitudO, longitudO, opcio, taulaHash.getHashtable()
                        , username, interessos);
                break;
            case "4":

                RadixSort radixSort = new RadixSort();
                if(opcio == 3){
                    interessos = taulaHash.extractInteressos(taulaHash.getHashtable(), username);
                }   //if
                posts = radixSort.radixSort(posts, opcio, latitudO, longitudO, taulaHash.getHashtable(),
                        username, interessos);
                for(int i = 0; i < posts.size(); i++){
                    System.out.println(posts.get(i).getVincle());
                }
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
        String cas;
        Scanner sc = new Scanner(System.in);
        String json = "jsons/";
        // Pintem el menú:
        do {
            System.out.println("Fitxers JSON:");
            System.out.println("1. m_dataset.json");
            System.out.println("2. s_dataset.json");
            System.out.println("3. xs_dataset.json");
            System.out.println("4. test_distancies.json");
            System.out.print("Sel·lecciona una opcio: ");
            cas = sc.nextLine();


            switch (cas) {
                case "1":
                   json = json.concat("m_dataset.json");
                    break;
                case "2":
                    json = json.concat("s_dataset.json");
                    break;
                case "3":
                    json = json.concat("xs_dataset.json");
                    break;
                case "4":
                    json = json.concat("test_distancies.json");
                default:
                    System.out.println("\nError, opció incorrecta\n");

            }
        }while((!cas.equals("1")) &&(!cas.equals("2")) && (!cas.equals("3")) && (!cas.equals("4")));
        return json;
    }
}
