package Estructures_Auxiliars;

import GsonObjects.Post;
import GsonObjects.Usuari;

import java.sql.Timestamp;

public class CriteriOrdenacio {

    public double criteriOrdenacio(Post post, Usuari usuari, Interessos interessos){
        double vincle = 0;

        try {
            //Interaccio entre Usuaris amb els posts
            for (int i = 0; i < post.getCommented_by().length; i++) {
                if (usuari.getUsername().equals(post.getCommented_by()[i]))
                    vincle += 30;//TODO: provar valors;
            }   //for

            for(int i = 0; i < post.getLiked_by().length; i++){
                if(usuari.getUsername().equals(post.getLiked_by()[i]))
                    vincle += 10;//TODO: provar valors
            }   //for
        }catch(NullPointerException e){
            System.out.println("No té comentaris.");
        }
        //Temporalitat del post
        Timestamp tmp = new Timestamp(System.currentTimeMillis());

        long today = tmp.getTime();
        long diferencia = today - post.getPublished();
        long dies = diferencia / (1000 * 3600 * 24);

        if(dies < 4)
            vincle += 60;//TODO: provar valors
        else{
            if(dies < 8){
                vincle += 10;//TODO: provar valors
            }   //if
        }   //else

        //Interessos del usuari respecte el post
        for(int i = 0; i < interessos.getCATEGORIES().length; i++){

            if(interessos.getCATEGORIES()[i].equals(post.getCategory()))
                vincle += interessos.getNum()[i] * 1.75;//TODO: provar valors;
        }   //for

        //Tenim en compte els likes del Post
        vincle += post.calculaLikesPost(post) * 0.25;//TODO: provar valors;

        return vincle;
    }
}
