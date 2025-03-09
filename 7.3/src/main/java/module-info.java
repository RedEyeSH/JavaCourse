module org.example.currencyconverterjpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens org.example.currencyconverterjpa.Entity to org.hibernate.orm.core, jakarta.persistence;
    exports org.example.currencyconverterjpa.Application to javafx.graphics;
}
