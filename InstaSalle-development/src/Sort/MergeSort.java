package Sort;

import GsonObjects.Post;

import java.util.ArrayList;

/**
 *Classe que defineix el mètode d'ordenació MergeSort
 *
 * @author: Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class MergeSort {

     public ArrayList<Post> ordenaMergeI(ArrayList<Post> a, int i, int j){
         int mig;

         if(i>=j)
            return a;

         if(i<j){
             mig = (i+j)/2;
             a = ordenaMergeI(a, i, mig);
             a = ordenaMergeI(a, mig+1,j);
             a = merge(a, i, mig, j);
         }
         return a;
     }

     public ArrayList<Post> merge(ArrayList<Post> a, int i, int mig, int j){
        ArrayList<Post> b = new ArrayList<Post>(a.size());
        int k1 = i, k2 = mig + 1, cursor = 0, kr;

        while (k1 <= mig && k2 <= j){

            if(a.get(k1).getPublished() <= a.get(k2).getPublished()){
                b.set(cursor, a.get(k1));
                k1++;
                cursor++;
            }

            if(a.get(k1).getPublished() > a.get(k2).getPublished()){
                b.set(cursor, a.get(k2));
                k2++;
                cursor++;
            }
        }

        while(k1 <= mig){
            b.set(cursor, a.get(k1));
            k1++;
            cursor++;
        }

         while(k2 <= j){
             b.set(cursor, a.get(k2));
             k2++;
             cursor++;
         }

         cursor = 0;
         kr = i;

         while(kr <= j){
             a.set(kr, b.get(cursor));
             kr++;
             cursor++;
         }
        return a;
     }
}
