module cl.nicolas.clasefinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.nicolas.clasefinal to javafx.fxml;
    exports cl.nicolas.clasefinal;
}