package com.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class AdminMgrController extends AnchorPane {
    @FXML
    private Button logoutButton;
    @FXML
    private TableView menuTable;
    @FXML
    private TableColumn menuColumn;

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
