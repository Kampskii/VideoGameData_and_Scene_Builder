package org.sla;

import java.io.*;
import java.util.ArrayList;

public class videoGame implements Serializable {
    // fields
    private static Controller myController;
    private static ArrayList<videoGame> videogames;
    private String title;
    private String developer;
    private String publisher;
    private String platform;

    // Constructors
    videoGame(String title, String developer, String publisher, String platform) {
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;

        if (videogames == null) {
           videogames = new ArrayList<videoGame>();
        }
        videogames.add(this);
    }

    static void initialize() {
        getMyController().updateMostExpensiveDevUI();

    }

    // Setters and Getters

    public static Controller getMyController() { return myController; }

    public static void setMyController(Controller myController) { videoGame.myController = myController; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDeveloper() { return developer; }

    public void setDeveloper(String developer) { this.developer = developer; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getPlatform() { return platform; }

    public void setPlatform(String platform) { this.platform = platform; }

    // Methods
    static public void save() {
        if (videogames != null && !videogames.isEmpty()){
            try {
                File savedModelFile = new File("serializedAllVideoGames");
                FileOutputStream savedModelFileStream = new FileOutputStream(savedModelFile);
                ObjectOutputStream out = new ObjectOutputStream(savedModelFileStream);
                out.writeObject(videogames);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static public boolean restore() {
        File savedModelFile = new File("serializedAllVideoGames");
        if (savedModelFile.exists()) {
            try {
                FileInputStream savedModelFileStream = new FileInputStream(savedModelFile);
                ObjectInputStream in = new ObjectInputStream(savedModelFileStream);
                videogames = (ArrayList<videoGame>)in.readObject();
                if (!videogames.isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    public String toString(){
        String description = "\"" + this.getTitle();
        description = description + "\" was developed by " + this.getDeveloper();
        description = description + " and was published by " + this.getPublisher();
        description = description + " for platform(s) " + this.getPlatform();
        return description;
    }

    public static void describeAll() {
        if (videogames != null) {
            videogames.forEach(videogame -> {
                System.out.println(videogame.toString());
            });
        }
    }
}






