package GsonObjects;

/**
 *Classe que defineix les connexions i les interaccions entre usuaris
 *
 * @author Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Connection {
    private String username;
    private long since;
    private int visits;
    private int likes;
    private int comments;

    public String getUsername() {
        return username;
    }

    public long getSince() {
        return since;
    }

    public int getVisits() {
        return visits;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }
}
