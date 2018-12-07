import Estructures_Auxiliars.LlegeixJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Usuari;

/**
 *Test del programa InstaSalle
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){

        LlegeixJSON llegeixJSON = new LlegeixJSON();
        Usuari[] usuaris = llegeixJSON.readJSON("jsons/prioritats.json");

        TaulaHash taulaHash = new TaulaHash(usuaris);

        taulaHash.extractPostsFromUser(taulaHash.getHashtable(), "claudia.peiro");
        taulaHash.extractInteressos(taulaHash.getHashtable(), "claudia.peiro");


    }
}
