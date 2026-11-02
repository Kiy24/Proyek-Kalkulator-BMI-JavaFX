module com.mycompany.kalkullatorbmi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.kalkullatorbmi to javafx.fxml;
    exports com.mycompany.kalkullatorbmi;
}
