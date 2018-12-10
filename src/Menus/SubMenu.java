package Menus;

import Estructures_Auxiliars.Interes;
import Estructures_Auxiliars.TaulaHash;
import Estructures_Auxiliars.TracteJSON;
import GsonObjects.Post;
import Sort.*;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Classe que defineix els submenus que usarem per determinar quin JSON llegirà
 * i quin mètode d'ordenació s'usarà
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

class SubMenu {

    /**
     * Procediment que s'encarrega de mostrar el menú del metode d'ordenació a triar
     * @param opcio : funcionalitat seleccionada en l'anterior menú
     * @param posts : ArrayList de Post
     * @param latitudO : latitud si es que s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud si es que s'ha seleccionat la funcionalitat 2
     * @param username : nom d'usuari si es que s'ha seleccionat la funcionalitat 3
     * @param taulaHash : Objecte que conté el HashTable si es que s'ha seleccionat la funcionalitat 3
     */
    void mostraSubMenuOrd(int opcio, ArrayList<Post> posts, double latitudO, double longitudO, String username,
                          TaulaHash taulaHash){
        String cas;
        Scanner sc = new Scanner(System.in);

        TracteJSON tracteJSON = new TracteJSON();
        Interes interes = null;

        // Pintem el menú:
        System.out.println("Metodes d'ordenacio:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quicksort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Radix Sort\n");
        System.out.print("Sel·lecciona una opcio: ");
        cas = sc.nextLine();

        long startTime = System.nanoTime();
        switch (cas) {
            case "1":
                MergeSort mergeSort = new MergeSort();
                if(opcio == 3){
                    interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                }
                posts = mergeSort.ordenaMergeI(posts, 0, posts.size() -1, latitudO, longitudO, opcio, taulaHash.getHashtable()
                        , username, interes);

                tracteJSON.serializeJSON(posts, 0);
                break;
            case "2":
                QuickSort quickSort = new QuickSort();
                Parametre parametre = new Parametre(posts);
                if(opcio == 3){
                    interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                }
                posts = quickSort.QuicksortI(parametre, latitudO, longitudO, opcio, taulaHash.getHashtable()
                        , username, interes);

                tracteJSON.serializeJSON(posts, 0);
                break;
            case "3":

                SelectionSort selectionSort = new SelectionSort();
                if(opcio == 3){
                    interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                }   //if
                posts = selectionSort.selectionSort(posts, latitudO, longitudO, opcio, taulaHash.getHashtable()
                        , username, interes);

                tracteJSON.serializeJSON(posts, 0);
                break;
            case "4":

                RadixSort radixSort = new RadixSort();
                if(opcio == 3){
                    interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                }   //if
                posts = radixSort.radixSort(posts, opcio, latitudO, longitudO, taulaHash.getHashtable(),
                        username, interes);

                tracteJSON.serializeJSON(posts, 0);
                break;
            default:
                System.out.println("\nError, opció incorrecta\n");
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println(endTime);
    }
    /**
     *Procediment per visualitzar el submenú per seleccionar el JSON (els JSONs estan en la carpeta jsons)
     * el qual voldrem llegir
     */
    String mostraSubMenuJson(){
        String cas;
        Scanner sc = new Scanner(System.in);
        String json = "jsons/";
        // Pintem el menú:
        do {
            System.out.println("Fitxers JSON:");
            System.out.println("1. m_dataset.json");
            System.out.println("2. s_dataset.json");
            System.out.println("3. xs_dataset.json");
            System.out.println("4. posts_1K5_dataset.json");
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
                    json = json.concat("posts_1K5_dataset.json");
                default:
                    System.out.println("\nError, opció incorrecta\n");

            }
        }while((!cas.equals("1")) &&(!cas.equals("2")) && (!cas.equals("3")) && (!cas.equals("4")));
        return json;
    }
}
