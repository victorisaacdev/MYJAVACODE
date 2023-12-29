package com.typer.depure;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class questionSceneController {
    @FXML
    private RadioButton begCheck, interCheck, proCheck;
    @FXML
    private ToggleGroup rate;
    @FXML
    private Label chooseLabel;
    @FXML
    private Button nextButon;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private RadioButton selectedRadioButton;

    public void selectButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homeScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

}