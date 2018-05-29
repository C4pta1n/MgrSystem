package com.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class TeaMgrController {
    @FXML
    private Button logoutButton;

    private Main application;
    private void initialize() {
    }
    public void setApp(Main application) {
        this.application = application;
    }
    public void logout(){
        application.userLogout();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("教务管理系统");
        alert.setHeaderText(null);
        alert.setContentText("已退出登陆" );

        alert.showAndWait();
    }
}
