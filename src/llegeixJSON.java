import GsonObjects.Usuari;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *Classe que defineix el procés de lectura d'un JSON ajudant-se de la llibreria Gson
 *
 * @author: Alexander Roca
 * @version 17/11/2018 - 0.1
 */

public class llegeixJSON {

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
}
