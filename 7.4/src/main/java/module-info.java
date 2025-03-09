module CurrencyTransaction {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens Entity to org.hibernate.orm.core, jakarta.persistence;
    exports Application to javafx.graphics;
}
