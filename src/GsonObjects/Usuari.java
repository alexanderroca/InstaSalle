package GsonObjects;

import java.util.ArrayList;

/**
 *Classe que defineix els camps d'un usuari del JSON
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Usuari {
    private String username;
    private int followers;
    private int follows;
    private ArrayList<Connection> connections;
    private ArrayList<Post> posts;
    private int[] likedPosts;
    private int[] commentedPosts;

    public String getUsername() {
        return username;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollows() {
        return follows;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public int[] getLikedPosts() {
        return likedPosts;
    }

    public int[] getCommentedPosts() {
        return commentedPosts;
    }
}
