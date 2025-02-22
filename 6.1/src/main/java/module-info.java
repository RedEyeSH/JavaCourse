module org.example.task {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.javafxcourse.View to javafx.graphics;

    exports org.example.javafxcourse.View;
    exports org.example.javafxcourse.Controller;
    exports org.example.javafxcourse.Model;
}
