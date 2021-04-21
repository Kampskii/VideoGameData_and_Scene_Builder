package org.sla;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BestSelling extends videoGame {
    //fields
    private int sales;
    private int rank;
    private int releaseYear;
    private String releaseDate;

    //constructors
    public BestSelling(String title, String developer, String publisher, String platform, int sales, int rank, int releaseYear, String releaseDate) {
        super(title, developer, publisher, platform);
        this.sales = sales;
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
    }
    //setters/getters

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BestSelling(String title, String developer, String publisher, String platform) {
        super(title, developer, publisher, platform);
    }

    //Methods

    public String toString(){
        String description = "\"" + this.getPublisher();
        description = description + "\" developed " + this.getTitle();
        description = description + "\" released on " + this.getReleaseDate();
        description = description + "\" in " + this.getReleaseYear();
        description = description + "\" for platform(s) " + this.getPlatform();
        description = description + "\" selling this many copies:" + this.getSales();

        return description;
    }
    static void read(String dataFilePath) {
        // try to create Scanner
        Scanner scanner = null;
        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem opening file: " + dataFilePath);
        }
        if (scanner == null) {
            // I can't scan without a scanner, so we're done.
            return;
        }

        // Read from each line in data file until there are no more
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            // Construct a new scanner for each to get its tokens
            Scanner lineScanner = new Scanner(next);
            // Data tokens are separated by tabs
            lineScanner.useDelimiter("\t");

            // There are 8 data tokens that we need for each Bestselling
            int rank = lineScanner.nextInt();
            String title = lineScanner.next();
            System.out.println(title);
            int sales = lineScanner.nextInt();
            String platform = lineScanner.next();
            String releaseDate = lineScanner.next();
            //November 18, 2011
            int commalocation = releaseDate.indexOf(",");
            String year = releaseDate.substring( commalocation + 2);
            int releaseYear = Integer.parseInt(year);
            String developer = lineScanner.next();
            String publisher = lineScanner.next();

            videoGame videoGame = new BestSelling(title, developer,publisher,platform,sales,rank,releaseYear,releaseDate);
        }
    }
}



