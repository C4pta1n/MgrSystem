package com.view;

import com.bean.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class StuMgrController extends AnchorPane {
    @FXML
    private Button logoutButton;
    @FXML
    private Label username;

    private Main application;
    private void initialize() {
    }
    public void setApp(Main application) {
        this.application = application;
        Account account = application.getAccount();
        username.setText(account.getUsername());
    }
    public void logout(){
        if (application == null) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("教务管理系统");
        alert.setHeaderText(null);
        alert.setContentText("已退出登陆" );
        alert.showAndWait();
        application.userLogout();
    }
}
