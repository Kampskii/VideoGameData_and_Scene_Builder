package org.sla;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    private Stage myStage;

    // Most Expensive Dev GUI Elements
    public TextField title;
    public TextField developer;
    public TextField publisher;
    public TextField year;
    public TextField devCost;
    public TextField platform;
    public Button updateButton;
    public Button updateButton1;

    // Accordion Layout Panes
    public Accordion myAccordion;
    public TitledPane mostExpensiveDevPane;
    public TitledPane bestSellingPane;
    public TitledPane allVideoGamesPane;

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


        boolean thereWasData = restoreData();
        if (thereWasData) {
            updateAllUIs();
            myAccordion.setExpandedPane(allVideoGamesPane);
        }
    }

    // Setters n' Getters
    public Stage getMyStage() { return myStage; }

    public void setMyStage(Stage myStage) { this.myStage = myStage; }


    // Data onAction methods
    public void importMostExpensiveDev() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile != null && selectedFile.exists()) {
            MostExpensiveDev.read(selectedFile.getPath());

            updateMostExpensiveDevUI();
            updateMostExpensiveDevUI();
            myAccordion.setExpandedPane(mostExpensiveDevPane);
        }
    }

    public void importBestSelling() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile != null && selectedFile.exists()) {
            BestSelling.read(selectedFile.getPath());

            updateBestSellingUI();
            updateBestSellingUI();
            myAccordion.setExpandedPane(bestSellingPane);
        }
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

    void updateAllUIs() {
        updateMostExpensiveDevUI();
        updateBestSellingUI();
        updateAllUIs();
    }



}
