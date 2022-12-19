module com.lanftp.sharecare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lanftp.sharecare to javafx.fxml;
    exports com.lanftp.sharecare;
}