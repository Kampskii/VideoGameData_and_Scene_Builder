package org.sla;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    // Most Expensive Dev GUI Elements
    public TextField title;
    public TextField developer;
    public TextField publisher;
    public TextField year;
    public TextField devCost;
    public TextField platform;
    public Button updateButton;
    public Button updateButton1;


    // List view (Dev)
    public ListView<MostExpensiveDev> mostExpensiveDevListView;

    // Best Selling GUI Elements
    public TextField titleField;
    public TextField devField;
    public TextField pubField;
    public TextField platformField;
    public TextField rankField;
    public TextField salesField;
    public TextField releaseYearField;
    public TextField releaseDateField;

    // List view (Best)
    public ListView<BestSelling> bestSellingListView;

    public void initialize() {
        videoGame.setMyController(this);
        BestSelling.initialize();
        MostExpensiveDev.initialize();
    }

    public void saveData() {
        videoGame.save();
        MostExpensiveDev.save();
        BestSelling.save();
    }

    public boolean restoreData(){
        boolean gameRestored = videoGame.restore();
        boolean mostExpensiveDevRestored = MostExpensiveDev.restore();
        boolean bestSellingRestored = BestSelling.restore();
        if (gameRestored || mostExpensiveDevRestored || bestSellingRestored) {
            videoGame.describeAll();
            return true;
        }
        return false;
    }

    void updateMostExpensiveDevUI(){
        mostExpensiveDevListView.getItems().clear();
        ArrayList<MostExpensiveDev> allMostExpensiveDev = MostExpensiveDev.getMostExpensiveDevGames();
        allMostExpensiveDev.forEach( game -> {
            mostExpensiveDevListView.getItems().add(game);
        });
    }

    void updateBestSellingUI(){
        bestSellingListView.getItems().clear();
        ArrayList<BestSelling> allBestSelling = BestSelling.getBestSellingGames();
        allBestSelling.forEach( game -> {
            bestSellingListView.getItems().add(game);

        });
    }

}
