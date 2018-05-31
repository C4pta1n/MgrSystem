package com.view;

import com.bean.Account;
import com.dao.AccountDao;
import com.dao.impl.AccountDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.util.Optional;

public class AdminMgrController extends AnchorPane {
    private Main application;
    private Account account = new Account();
    private AccountDao acd = new AccountDaoImpl();

    @FXML
    private Button logoutButton;
    @FXML
    private TableView menuTable;
    @FXML
    private TableColumn menuColumn;
    @FXML
    private Label username;
    @FXML
    private Button changPasswordButton;

    @FXML
    private void initialize() {
    }
    public void setApp(Main application) {
        this.application = application;
        account = application.getAccount();
        //username.setText(account.getAdmin().getAname());
    }
    @FXML
    public void logout(){
        if (application == null) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("教务管理系统");
        alert.setHeaderText(null);
        alert.setContentText("已退出登陆" );
        alert.showAndWait();
        application.userLogout();
    }
    @FXML
    public void setChangPasswordButton(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("教务系统");
        dialog.setHeaderText("修改密码");
        dialog.setGraphic(new ImageView(this.getClass().getResource("card-file.png").toString()));
        ButtonType enterButtonType = new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(enterButtonType,ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20,150,10,10));
        TextField password = new TextField();
        password.setPromptText("原密码");
        TextField password0 = new TextField();
        password0.setPromptText("修改密码");
        TextField password1 = new TextField();
        password1.setPromptText("确认密码");

        gridPane.add(new Label("原密码"),0,0);
        gridPane.add(password,1,0);
        gridPane.add(new Label("修改密码"),0,1);
        gridPane.add(password0,1,1);
        gridPane.add(new Label("确认密码"),0,2);
        gridPane.add(password1,1,2);

        Node enterButton = dialog.getDialogPane().lookupButton(enterButtonType);
        enterButton.setDisable(true);
        password0.textProperty().addListener((observable,oldValue,newValue ) -> {
            enterButton.setDisable(newValue.trim().isEmpty());});
        dialog.getDialogPane().setContent(gridPane);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == enterButtonType){
                return password0.getText();
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(cnoScore -> {
            if (acd.changePassword(account,password.getText(),password0.getText(),password1.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("修改密码");
                alert.setHeaderText(null);
                alert.setContentText("修改成功！");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("修改密码");
                alert.setHeaderText(null);
                alert.setContentText("修改失败！原密码错误或修改的两次密码不一致");
                alert.showAndWait();
            }
        });
    }
}
