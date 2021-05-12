package org.sla;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MostExpensiveDev extends videoGame implements Serializable {
    // Fields
    private static ArrayList<MostExpensiveDev> mostExpensiveDevGames;
    private String devCost;
    private int releaseYear;

    // Constructors
    public MostExpensiveDev(String publisher, String developer, String title, String devCost, int releaseYear, String platform) {
        super (title, developer, publisher, platform);
        this.devCost = devCost;
        this.releaseYear = releaseYear;

        if (mostExpensiveDevGames ==null) {
            mostExpensiveDevGames = new ArrayList<MostExpensiveDev>();
        }
        mostExpensiveDevGames.add(this);
    }

    static void initialize(){
        read("MostExpensiveData");
        getMyController().updateMostExpensiveDevUI();
    }

    // Setters and Getters
    public static ArrayList<MostExpensiveDev> getMostExpensiveDevGames() {
        return mostExpensiveDevGames;
    }

    public static void setMostExpensiveDevGames(ArrayList<MostExpensiveDev> mostExpensiveDevGames) {
        MostExpensiveDev.mostExpensiveDevGames = mostExpensiveDevGames;
    }

    public int getReleaseYear() { return releaseYear; }

    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getDevCost() { return devCost; }

    public void setDevCost(String devCost) { this.devCost = devCost; }

    // Methods
    public String toString(){
        String description = "\"" + this.getPublisher();
        description = description + " and " + this.getDeveloper();
        description = description + " developed " + this.getTitle();
        description = description + " costing " + this.getDevCost();
        description = description + " in " + this.getReleaseYear();
        description = description + " for platform(s) " + this.getPlatform();
        return description;
    }
    static void read(String dataFilePath) {
        Scanner scanner = null;

        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem opening file " + dataFilePath);
        }
        if (scanner == null) {
            return;
        }

        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            Scanner lineScanner = new Scanner(next);
            lineScanner.useDelimiter("\t");

            //5 data tokens
            String title = lineScanner.next();
            System.out.println(title);
            int releaseyear = lineScanner.nextInt();
            String developer = lineScanner.next();
            String publisher = lineScanner.next();
            String platform = lineScanner.next();
            String devcost = lineScanner.next();
            int pluslocation = devcost.indexOf("+");
            if (pluslocation != -1) {
                devcost = devcost.substring( 0,pluslocation - 1);
            }


            videoGame videogame = new MostExpensiveDev(publisher, developer, title, devcost, releaseyear, platform);
            System.out.println(videogame);
        }
    }

    static public void save() {
        if (mostExpensiveDevGames != null &&mostExpensiveDevGames.isEmpty()) {
            try {
                File savedModelFile = new File("serializedAllMostExpensiveDev");
                FileOutputStream savedModelFileStream = new FileOutputStream(savedModelFile);
                ObjectOutputStream out = new ObjectOutputStream(savedModelFileStream);
                out.writeObject(mostExpensiveDevGames);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static public boolean restore() {
        File savedModelFile = new File("serialziedAllBestSelling");
        if (savedModelFile.exists()) {
            try {
                FileInputStream savedModelFileStream = new FileInputStream(savedModelFile);
                ObjectInputStream in = new ObjectInputStream(savedModelFileStream);
                mostExpensiveDevGames = (ArrayList<MostExpensiveDev>)in.readObject();
                if(!mostExpensiveDevGames.isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
