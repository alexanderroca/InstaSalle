package Menus;

import Estructures_Auxiliars.Interes;
import Estructures_Auxiliars.TracteJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Classe que defineix el menú principal del programa, a partir d'aquesta
 * la resta de classes es relacionaran amb ella.
 *
 * @author Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Menu {

    /**
     *Procediment per visualitzar el menú principal, el qual s'executarà fins que no es seleccioni l'opció 4 (sortir)
     */
    public void mostraMenu(String[] args) {
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

        if (args == null) {

            // Pintem el menú
            do {
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
                        sc.nextLine();
                        break;
                    case "3":

                        opcio = Integer.valueOf(cas);
                        System.out.print("Insereix-hi nom usuari: ");
                        username = sc.nextLine();
                        try {
                            posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                        } catch (NullPointerException e) {
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

                if (opcio > 0) {
                    submenu.mostraSubMenuOrd(opcio, posts, latitudO, longitudO, username, taulaHash);
                }   //if
            } while (!cas.equals("4"));
        }   //if
        else{
            TracteJSON tracteJson = new TracteJSON();
            if(args[0].equals("MergeSort")){
                System.out.println("MergeSort en execució:");
                int i = 1;
                while(i < args.length){
                    MergeSort mergeSort = new MergeSort();
                    switch(args[i]){
                        case "1":
                            System.out.println("Funcionalitat 1");
                            posts = taulaHash.extractPosts(taulaHash);
                            posts = mergeSort.ordenaMergeI(posts, 0, posts.size() -1, 0, 0, 1, null
                                    , null, null);
                            break;
                        case "2":
                            System.out.println("Funcionalitat 2");
                            posts = taulaHash.extractPosts(taulaHash);
                            System.out.print("Insereix-hi latitud: ");
                            latitudO = sc.nextDouble();
                            System.out.print("Insereix-hi longitud: ");
                            longitudO = sc.nextDouble();
                            posts = mergeSort.ordenaMergeI(posts, 0, posts.size() -1, latitudO, longitudO, 2, null
                                    , null, null);
                            sc.nextLine();
                            break;
                        case "3":
                            System.out.println("Funcionalitat 3");
                            System.out.print("Insereix-hi nom usuari: ");
                            username = sc.nextLine();
                            try {
                                posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                                Interes interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                                posts = mergeSort.ordenaMergeI(posts, 0, posts.size() -1, 0, 0, 3, taulaHash.getHashtable()
                                        , username, interes);
                            } catch (NullPointerException e) {
                                System.out.println("L'usuari inserit no existeix.");
                            }
                            break;
                            default:

                                System.out.println("Error, funcionalitat inexistent.");
                                break;
                    }   //switch

                    tracteJSON.serializeJSON(posts, Integer.parseInt(args[i]));
                    i++;
                }   //while
                System.out.println("\nGracies per utilitzar el nostre programa !\n");
            }   //if
            else{
                if(args[0].equals("QuickSort")){
                    System.out.println("QuickSort en execució:");
                    int i = 1;
                    while(i < args.length){
                        QuickSort quickSort = new QuickSort();
                        Parametre parametre = new Parametre(posts);
                        switch(args[i]){
                            case "1":
                                System.out.println("Funcionalitat 1");
                                posts = taulaHash.extractPosts(taulaHash);
                                posts = quickSort.QuicksortI(parametre, 0, 0, 1, null
                                        , null, null);
                                break;
                            case "2":
                                System.out.println("Funcionalitat 2");
                                posts = taulaHash.extractPosts(taulaHash);
                                System.out.print("Insereix-hi latitud: ");
                                latitudO = sc.nextDouble();
                                System.out.print("Insereix-hi longitud: ");
                                longitudO = sc.nextDouble();
                                posts = quickSort.QuicksortI(parametre, latitudO, longitudO, 2, null
                                        , null, null);
                                break;
                            case "3":
                                System.out.println("Funcionalitat 3");
                                System.out.print("Insereix-hi nom usuari: ");
                                username = sc.nextLine();
                                try {
                                    posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                                    Interes interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                                    posts = quickSort.QuicksortI(parametre, 0, 0, 3, taulaHash.getHashtable()
                                            , username, interes);
                                } catch (NullPointerException e) {
                                    System.out.println("L'usuari inserit no existeix.");
                                }
                                break;
                            default:

                                System.out.println("Error, funcionalitat inexistent.");
                                break;
                        }   //switch

                        tracteJSON.serializeJSON(posts, Integer.parseInt(args[i]));
                        i++;
                    }   //while
                    System.out.println("\nGracies per utilitzar el nostre programa !\n");
                }   //if
                else{
                    if(args[0].equals("SelectionSort")){
                        System.out.println("SelectionSort en execució:");
                        int i = 1;
                        while(i < args.length){
                            SelectionSort selectionSort = new SelectionSort();
                            switch(args[i]){
                                case "1":
                                    System.out.println("Funcionalitat 1");
                                    posts = taulaHash.extractPosts(taulaHash);
                                    posts = selectionSort.selectionSort(posts, 0, 0, 1, null
                                            , null, null);
                                    break;
                                case "2":
                                    System.out.println("Funcionalitat 2");
                                    posts = taulaHash.extractPosts(taulaHash);
                                    System.out.print("Insereix-hi latitud: ");
                                    latitudO = sc.nextDouble();
                                    System.out.print("Insereix-hi longitud: ");
                                    longitudO = sc.nextDouble();
                                    posts = selectionSort.selectionSort(posts, latitudO, longitudO, 2, null
                                            , null, null);
                                    sc.nextLine();
                                    break;
                                case "3":
                                    System.out.println("Funcionalitat 3");
                                    System.out.print("Insereix-hi nom usuari: ");
                                    username = sc.nextLine();
                                    try {
                                        posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                                        Interes interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                                        posts = selectionSort.selectionSort(posts, 0, 0, 3, taulaHash.getHashtable()
                                                , username, interes);
                                    } catch (NullPointerException e) {
                                        System.out.println("L'usuari inserit no existeix.");
                                    }
                                    break;
                                default:

                                    System.out.println("Error, funcionalitat inexistent.");
                                    break;
                            }   //switch

                            tracteJSON.serializeJSON(posts, Integer.parseInt(args[i]));
                            i++;
                        }   //while
                        System.out.println("\nGracies per utilitzar el nostre programa !\n");
                    }   //if
                    else{
                        if(args[0].equals("RadixSort")){
                            System.out.println("RadixSort en execució:");
                            int i = 1;
                            while(i < args.length){
                                RadixSort radixSort = new RadixSort();
                                switch(args[i]){
                                    case "1":
                                        System.out.println("Funcionalitat 1");
                                        posts = taulaHash.extractPosts(taulaHash);
                                        posts = radixSort.radixSort(posts, 1, 0, 0, null,
                                                null, null);
                                        break;
                                    case "2":
                                        System.out.println("Funcionalitat 2");
                                        posts = taulaHash.extractPosts(taulaHash);
                                        System.out.print("Insereix-hi latitud: ");
                                        latitudO = sc.nextDouble();
                                        System.out.print("Insereix-hi longitud: ");
                                        longitudO = sc.nextDouble();
                                        posts = radixSort.radixSort(posts, 2, latitudO, longitudO, null,
                                                null, null);
                                        sc.nextLine();
                                        break;
                                    case "3":
                                        System.out.println("Funcionalitat 3");
                                        System.out.print("Insereix-hi nom usuari: ");
                                        username = sc.nextLine();
                                        try {
                                            posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), username);
                                            Interes interes = taulaHash.extractInteres(taulaHash.getHashtable(), username);
                                            posts = radixSort.radixSort(posts, 3, 0, 0, taulaHash.getHashtable(),
                                                    username, interes);
                                        } catch (NullPointerException e) {
                                            System.out.println("L'usuari inserit no existeix.");
                                        }
                                        break;
                                    default:

                                        System.out.println("Error, funcionalitat inexistent.");
                                        break;
                                }   //switch

                                tracteJSON.serializeJSON(posts, Integer.parseInt(args[i]));
                                i++;
                            }   //while
                            System.out.println("JSONS generat a la carpeta 'jsons'.");
                            System.out.println("\nGracies per utilitzar el nostre programa !\n");
                        }   //if
                        else{
                            System.out.println("Error, s'ha inserit incorrectament el nom del metode d'ordenacio.\n " +
                                    "Tancant programa.");
                        }   //else
                    }   //else
                }
            }   //else
        }   //else
    }
}
