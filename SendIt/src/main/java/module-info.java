module com.mailservice.sendit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mailservice.sendit to javafx.fxml;
    exports com.mailservice.sendit;
}