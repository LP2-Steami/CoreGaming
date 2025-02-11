module com.projetolp2.coregaming {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.projetolp2.coregaming to javafx.fxml;
    exports com.projetolp2.coregaming;
    exports com.projetolp2.coregaming.Controllers;
    opens com.projetolp2.coregaming.Controllers to javafx.fxml;
}