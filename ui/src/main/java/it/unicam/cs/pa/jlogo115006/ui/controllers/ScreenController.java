/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.ui.controllers;

import it.unicam.cs.pa.jlogo115006.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class ScreenController {
    @FXML
    private Canvas canvas;
    private Controller controller;

    public void onRunSingleClick(ActionEvent actionEvent) {
        if(!controller.runSingleInstruction()) {
            new Alert(Alert.AlertType.ERROR, "No instructions left to run").showAndWait();
        }
        actionEvent.consume();
    }

    public void onRunAllClick(ActionEvent actionEvent) {
        try {
            controller.run();
        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.ERROR, "No instructions to execute").showAndWait();
        }
        actionEvent.consume();
    }

    public void setStage(Stage stage) {
        controller = (Controller) stage.getUserData();
        canvas.setHeight(controller.getPlane().getHeight());
        canvas.setWidth(controller.getPlane().getWidth());
        controller.getPlane().addShapeAddedHandler(this::onShapeAdded);
        controller.getPlane().addBackgroundColourChangedHandler(this::onBackgroundColourChanged);
        controller.getPlane().addClearedHandler(this::onCleared);
    }

    private void onCleared(Colour colour) {
        colorGraphicsContext(colour);
    }

    private void onShapeAdded(Shape shape) {
        switch (shape) {
            case Line line -> drawLine(line);
            case Polygon polygon -> drawPolygon(polygon);
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        }
    }

    private void drawLine(Line line) {
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        graphicsContext2D.setStroke(Color.rgb(line.colour().red(), line.colour().green(), line.colour().blue()));
        graphicsContext2D.setLineWidth(line.size());
        graphicsContext2D.strokeLine(line.start().x(), line.start().y(), line.end().x(), line.end().y());
    }

    private void drawPolygon(Polygon polygon) {
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        graphicsContext2D.setFill(Color.rgb(polygon.colour().red(), polygon.colour().green(), polygon.colour().blue()));
        graphicsContext2D.fillPolygon(polygon.lines().stream().mapToDouble(l -> l.start().x()).toArray(),
                polygon.lines().stream().mapToDouble(l -> l.start().y()).toArray(), polygon.getLinesNumber());
        drawAllLines();
    }

    public void onSaveClick(ActionEvent actionEvent) {
        controller.export();
        new Alert(Alert.AlertType.INFORMATION, "File saved").showAndWait();
        actionEvent.consume();
    }

    private void onBackgroundColourChanged(Colour colour) {
        colorGraphicsContext(colour);
        drawShapesOnCanvas();
        drawAllLines();
    }

    private void colorGraphicsContext(Colour colour) {
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        graphicsContext2D.setFill(Color.rgb(colour.red(), colour.green(), colour.blue()));
        graphicsContext2D.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawAllLines() {
        controller.getPlane().getShapes()
                .forEach(s -> {
                    if(s instanceof Line line) drawLine(line);
                    else if(s instanceof Polygon polygon) polygon.lines().forEach(this::drawLine);
                });
    }

    private void drawShapesOnCanvas() {
        controller.getPlane().getShapes().forEach(this::onShapeAdded);
    }
}
