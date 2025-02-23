module org.example.task {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.currencyconverter.View to javafx.graphics;

    exports org.example.currencyconverter.View;
    exports org.example.currencyconverter.Controller;
    exports org.example.currencyconverter.Model;
}
