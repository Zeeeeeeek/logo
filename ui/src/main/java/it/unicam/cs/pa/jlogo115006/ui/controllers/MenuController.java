/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.ui.controllers;

import it.unicam.cs.pa.jlogo115006.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;

public class MenuController {
    @FXML
    private TextField planeWidth;

    @FXML
    private TextField planeHeight;

    @FXML
    private TextField inputPath;

    @FXML
    private TextField outputPath;

    public void onSubmitControllerParameters(ActionEvent actionEvent) {
        try {
            Controller controller = new Controller(new SimplePlane(Integer.parseInt(planeWidth.getText()),
                    Integer.parseInt(planeHeight.getText())), inputPath.getText(), outputPath.getText());
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            stage.setUserData(controller);
            setNewScene(stage);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setNewScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/JLogoScreen.fxml")));
        Parent root = loader.load();
        ScreenController controller = loader.getController();
        controller.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
