package GsonObjects;

public class Post {
    private int id;
    private long published;
    private double[] location;
    private String category;
    private String[] liked_by;
    private String[] commented_by;

    public int getId() {
        return id;
    }

    public long getPublished() {
        return published;
    }

    public double[] getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String[] getLiked_by() {
        return liked_by;
    }

    public String[] getCommented_by() {
        return commented_by;
    }
}
