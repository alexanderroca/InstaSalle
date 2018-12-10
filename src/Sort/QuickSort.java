package Sort;

import Sort.Parametre;

/**
 *Classe que defineix el mètode d'ordenació Quicksort
 *
 * @author Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class QuickSort {

    public int[] QuicksortI(Parametre parametre){
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
        int mig, pivot, tmp, s, t;

        mig = (parametre.getI() + parametre.getJ())/2;
        pivot = parametre.getAPos(mig);
        s = parametre.getI();
        t = parametre.getJ();

        while(s<=t){
            while(parametre.getAPos(s) < pivot && parametre.getI() < parametre.getA().length - 1){
                s++;
            }

            while(parametre.getAPos(t) > pivot && parametre.getJ() > 1){
                t--;
            }

            if(s<t){
                tmp = parametre.getAPos(s);
                parametre.setAPos(s,parametre.getAPos(t));
                parametre.setAPos(s,tmp);
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


