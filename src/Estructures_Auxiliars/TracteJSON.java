package Estructures_Auxiliars;

import GsonObjects.Post;
import GsonObjects.Usuari;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

/**
 *Classe que defineix el procés de lectura d'un JSON ajudant-se de la llibreria Gson
 *
 * @author: Alexander Roca
 * @version 17/11/2018 - 0.1
 */

public class TracteJSON {

    /**
     *Funció que realitza la lectura del JSON (gràcies a funcionalitats de la llibreria Gson que està en la
     * carpeta library) a un arrayLists d'objectes
     *
     * @param path: String que conté la direcció del JSON que és vol llegir
     * @return ArrayList d'usuaris
     */
    public Usuari[] readJSON(String path){
        Gson gson = new GsonBuilder().create();
        Usuari[] usuaris = null;
        try{
            usuaris = gson.fromJson(new BufferedReader(new FileReader(path)),Usuari[].class);
        }catch (FileNotFoundException e){
            System.out.println("No s'ha llegit correctament el JSON");
        }
        return usuaris;
    }

    public void serializeJSON(ArrayList<Post> posts){

        try (Writer writer = new FileWriter("jsons/resultSorted.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(posts, writer);
        } catch (IOException e) {
            System.out.println("Problema en crear el JSON del resultat de l'ordenacio.");;
        }
    }
}
