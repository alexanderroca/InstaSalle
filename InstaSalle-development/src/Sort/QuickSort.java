package Sort;

import GsonObjects.Post;

import java.util.ArrayList;

/**
 *Classe que defineix el mètode d'ordenació Quicksort
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class QuickSort {

    public ArrayList<Post> QuicksortI(Parametre parametre){
        int s, t;

        if(parametre.getI() >= parametre.getJ())
            return parametre.getA();

        if(parametre.getI() < parametre.getJ()){
            int i = parametre.getI();
            int j = parametre.getJ();
            parametre = particio(parametre);
            s = parametre.getI();
            t = parametre.getJ();
            parametre.setI(i);
            parametre.setJ(t);
            parametre.setA(QuicksortI(parametre));
            parametre.setI(s);
            parametre.setJ(j);
            parametre.setA(QuicksortI(parametre));
        }
        return parametre.getA();
    }

    public Parametre particio (Parametre parametre){
        int mig, s, t;
        long pivot;
        Post tmp;

        mig = (parametre.getI() + parametre.getJ())/2;
        pivot = parametre.getAPos(mig);
        s = parametre.getI();
        t = parametre.getJ();

        while(s<=t){
            while(parametre.getAPos(s) < pivot){
                s++;
            }

            while(parametre.getAPos(t) > pivot){
                t--;
            }

            if(s<t){
                tmp = parametre.getAPosPOST(s);
                parametre.setAPos(s, parametre.getAPosPOST(t));
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


