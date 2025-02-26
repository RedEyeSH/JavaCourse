module org.example.task {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.virtualpet.View to javafx.graphics;

    exports org.example.virtualpet.View;
    exports org.example.virtualpet.Controller;
    exports org.example.virtualpet.Model;
}