package com.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class LoginController extends AnchorPane {
    Main application = new Main();
    @FXML
    private Button login;
    @FXML
    private Label welcome;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    void initialize() {
        welcome.setText("");
    }
    @FXML
    public void gotologin(ActionEvent event){
        if (application.userLogin(username.getText(),password.getText())) {
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText("登陆失败");
            alert.setContentText("用户名或者密码错误");
            alert.showAndWait();
        }
    }
}
