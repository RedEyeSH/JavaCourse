module org.example.notebook {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.notebook to javafx.graphics, javafx.fxml;
    opens org.example.notebook.Controller to javafx.graphics, javafx.fxml;
    opens org.example.notebook.View to javafx.graphics, javafx.fxml;
}
