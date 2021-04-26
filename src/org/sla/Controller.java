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
        BestSelling.initalize();
        MostExpensiveDev.initalize();
    }

    void updateMostExpensiveDevUI(){
        mostExpensiveDevListView.getItems().clear();
        //ArrayList<MostExpensiveDev> allMostExpensiveDev = MostExpensiveDev.getAllMostExpensiveDev();
    }

}
