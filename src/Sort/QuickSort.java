package Sort;

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
        int mig = (parametre.getI() + parametre.getJ())/2, pivot = parametre.getAPos(mig), tmp, s = parametre.getI(), t = parametre.getJ();

        while(s<=t){
            while(parametre.getAPos(s) < pivot){
                s++;
            }

            while(parametre.getAPos(t) > pivot){
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
        return parametre;
    }
}


