package Estructures_Auxiliars;

import GsonObjects.Post;
import GsonObjects.Usuari;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que defineix el combinació de criteris ha usar per la funcionalitat 3
 *
 * @author Alexander Roca
 * @version 4/12/2018 - 0.1
 */
public class CriteriOrdenacio {

    /**
     * Funció que tracte la interacció d'un Usuari amb la resta d'elements que es connecta amb la resta
     * @param post : Objecte Post
     * @param usuari : Objecte Usuari
     * @param interes : Objecte Interes
     * @return vincle entre l'usuari i el Post
     */
    public double criteriOrdenacio(Post post, Usuari usuari, Interes interes){
        double vincle = 0;

        try {
            //Interaccio entre Usuaris amb els posts
            for (int i = 0; i < post.getCommented_by().length; i++) {
                if (usuari.getUsername().equals(post.getCommented_by()[i]))
                    vincle += 200;//TODO: provar valors;
            }   //for

            for(int i = 0; i < post.getLiked_by().length; i++){
                if(usuari.getUsername().equals(post.getLiked_by()[i]))
                    vincle += 100;//TODO: provar valors
            }   //for
        }catch(NullPointerException e){
            System.out.println("No té comentaris.");
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp tmp_aux = new Timestamp(System.currentTimeMillis());
        Date today_aux = null;
        try {
            today_aux = dateFormat.parse(tmp_aux.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp tmpPost = new Timestamp(post.getPublished());
        Date postDay = null;
        try {
            postDay = dateFormat.parse(tmpPost.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int diferencia_aux = (int) ((today_aux.getTime() - postDay.getTime()) / 86400000);
        //

        if(diferencia_aux < 4)
            vincle += 500;//TODO: provar valors
        else{
            if(diferencia_aux < 8){
                vincle += 100;//TODO: provar valors
            }   //if
        }   //else

        //Interes del usuari respecte el post
        for(int i = 0; i < interes.getCATEGORIES().length; i++){

            if(interes.getCATEGORIES()[i].equals(post.getCategory()))
                vincle += interes.getNum()[i] * 0.75;//TODO: provar valors;
        }   //for

        //Tenim en compte els likes del Post
        vincle += post.calculaLikesPost(post) * 0.25;//TODO: provar valors;

        post.setVincle(vincle);

        return vincle;
    }
}
