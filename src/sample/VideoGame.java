package sample;

import java.util.ArrayList;

public class VideoGame {
    // fields
  private static ArrayList<VideoGame> videogames;
  private String title;
  private String developer;
  private String publisher;
  private String platform;

  // Constructors
    public VideoGame(String title, String developer, String publisher, String platform) {
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;

        if (videogames == null) {
           videogames = new ArrayList<VideoGame>();
        }
        videogames.add(this);
    }

    // Setters and Getters
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDeveloper() { return developer; }

    public void setDeveloper(String developer) { this.developer = developer; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getPlatform() { return platform; }

    public void setPlatform(String platform) { this.platform = platform; }

    // Methods
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






