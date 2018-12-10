package Sort;

import GsonObjects.Post;
import GsonObjects.Usuari;
import Estructures_Auxiliars.CriteriOrdenacio;
import Estructures_Auxiliars.Interes;
import java.util.Hashtable;
import java.util.ArrayList;

/**
 *Classe que defineix el mètode d'ordenació Quicksort
 *
 * @author Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class QuickSort {

    /**
     * Funció que crida recursivament al mètode partició per ordenar els posts
     * @param parametre : Objecte Parametre
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO :longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param hashtable: Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interes : Objecte Interessos
     * @return ArrayList de Post : ordenat
     */
    public ArrayList<Post> QuicksortI(Parametre parametre, double latitudO, double longitudO, int opcio,
                                         Hashtable<String, Usuari> hashtable, String username, Interes interes){
        int s, t;

        if(parametre.getI() >= parametre.getJ())
            return parametre.getA();

        if(parametre.getI() < parametre.getJ()){
            int i = parametre.getI();
            int j = parametre.getJ();
            parametre = particio(parametre, latitudO, longitudO, opcio, hashtable, username, interes);
            s = parametre.getI();
            t = parametre.getJ();
            parametre.setI(i);
            parametre.setJ(t);
            parametre.setA(QuicksortI(parametre, latitudO, longitudO, opcio, hashtable, username, interes));
            parametre.setI(s);
            parametre.setJ(j);
            parametre.setA(QuicksortI(parametre,latitudO, longitudO, opcio, hashtable, username, interes));
        }
        return parametre.getA();
    }

    /**
     * Funció que realitza la ordenació pel mètode QuickSort
     * @param parametre: Objecte Paràmetre
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interes : Objecte Interessos
     * @return Parametre
     */
    public Parametre particio (Parametre parametre, double latitudO, double longitudO, int opcio,
                               Hashtable<String, Usuari> hashtable, String username, Interes interes){
        int mig, s, t;
        Post pivot, tmp;

        mig = (parametre.getI() + parametre.getJ())/2;
        pivot = parametre.getAPos(mig);
        s = parametre.getI();
        t = parametre.getJ();

        CriteriOrdenacio combinacioPrioritats = null;
        if (opcio == 3) {
            combinacioPrioritats = new CriteriOrdenacio();
        }

        while(s<=t){

            if(opcio == 1){
                while(parametre.getAPos(s).getPublished() < pivot.getPublished()){
                    s++;
                }

                while(parametre.getAPos(t).getPublished() > pivot.getPublished()){
                    t--;
                }
            }else{
                if(opcio == 2){
                    while((Math.abs(parametre.getAPos(s).calculaDistancia(latitudO, longitudO, parametre.getAPos(s).getLocation()[0], parametre.getAPos(s).getLocation()[1]))
                            < Math.abs(pivot.calculaDistancia(latitudO, longitudO, pivot.getLocation()[0], pivot.getLocation()[1]))) && s < parametre.getA().size()){
                        s++;
                    }


                    while((Math.abs(parametre.getAPos(t).calculaDistancia(latitudO, longitudO, parametre.getAPos(t).getLocation()[0], parametre.getAPos(t).getLocation()[1]))
                            > Math.abs(pivot.calculaDistancia(latitudO, longitudO, pivot.getLocation()[0], pivot.getLocation()[1]))) && t > 0){
                        t--;
                    }
                }else{
                    if(opcio == 3){
                        while((combinacioPrioritats.criteriOrdenacio(parametre.getAPos(s), hashtable.get(username), interes)) <
                                (combinacioPrioritats.criteriOrdenacio(pivot, hashtable.get(username), interes))){
                            s++;
                        }


                        while((combinacioPrioritats.criteriOrdenacio(parametre.getAPos(t), hashtable.get(username), interes)) >
                                (combinacioPrioritats.criteriOrdenacio(pivot, hashtable.get(username), interes))){
                            t--;
                        }
                    }
                }
            }
            
            if(s<t){
                tmp = parametre.getAPos(s);
                parametre.setAPos(s,parametre.getAPos(t));
                parametre.setAPos(t,tmp);
                s = s+1;
                t = t-1;
            }

            if(s == t){
                s++;
                t--;
            }
        }

        parametre.setI(s);
        parametre.setJ(t);
        return parametre;
    }
}


