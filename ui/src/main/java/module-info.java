module it.unicam.cs.pa.jlogo115006.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires it.unicam.cs.pa.jlogo115006;


    opens it.unicam.cs.pa.jlogo115006.ui to javafx.fxml;
    exports it.unicam.cs.pa.jlogo115006.ui;
    exports it.unicam.cs.pa.jlogo115006.ui.controllers;
    opens it.unicam.cs.pa.jlogo115006.ui.controllers to javafx.fxml;
}