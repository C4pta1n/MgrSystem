package com.view;

import com.bean.Account;
import com.bean.Evaluate;
import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dao.impl.AccountDaoImpl;
import com.dao.impl.AdminDaoImpl;
import com.model.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AdminMgrController extends AnchorPane {
    private Main application;
    private Account account = new Account();
    private AccountDao acd = new AccountDaoImpl();
    private AdminDao add = new AdminDaoImpl();
    private ObservableList<QueryEva> showEvas = FXCollections.observableArrayList();

    @FXML
    private Button logoutButton;
    @FXML
    private Label username;
    @FXML
    private Button changPasswordButton;
    @FXML
    private TableView<ShowStuMessage> stuMessageTableView;
    @FXML
    private TableColumn<ShowStuMessage,String> stuIdColumn;
    @FXML
    private TableColumn<ShowStuMessage,String> stuNameColumn;
    @FXML
    private Label stuIdLabel;
    @FXML
    private Label stuNameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label specialityLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private Label clazzLabel;
    @FXML
    private Label techtitleLabel;
    @FXML
    private TableView<ShowTeaMessage> teaMessageTableView;
    @FXML
    private TableColumn<ShowTeaMessage,String> teaIdColumn;
    @FXML
    private TableColumn<ShowTeaMessage,String> teaNameColumn;
    @FXML
    private TableView<ShowQueryScore> queryScoreTableView;
    @FXML
    private TableColumn<ShowQueryScore,String> courseIdColumn;
    @FXML
    private TableColumn<ShowQueryScore,String> courseNameColumn;
    @FXML
    private TableColumn<ShowQueryScore,String> stuIdColumn0;
    @FXML
    private Label courseIdLabel;
    @FXML
    private Label courseNameLabel;
    @FXML
    private Label stuIdLabel0;
    @FXML
    private Label stuNameLabel0;
    @FXML
    private Label courseCreditLabel;
    @FXML
    private Label courseScoreLabel;
    @FXML
    private TableView<ShowTeaMessage> teaMessageTableView0;
    @FXML
    private TableColumn<ShowTeaMessage,String> teaIdColumn0;
    @FXML
    private TableColumn<ShowTeaMessage,String> teaNameColumn0;
    @FXML
    private TableView<QueryEva> showEvaTableView;
    @FXML
    private TableColumn<QueryEva,String> courseIdColumn1;
    @FXML
    private TableColumn<QueryEva,String> courseNameColumn1;
    @FXML
    private TableColumn<QueryEva,String> evaluateColumn;
    @FXML
    private TextField userIdField;
    @FXML
    private TextField userPidField;
    @FXML
    private Button enterUserButton;
    @FXML
    private TextField userIdField0;
    @FXML
    private Button delUserButton;
    @FXML
    private TextField userIdChangeField;
    @FXML
    private TextField userNameChangeField;
    @FXML
    private ChoiceBox<String> sexChange;
    @FXML
    private Button updateButton;
    @FXML
    private TextField userIdChangeField0;
    @FXML
    private TextField userNameChangeField0;
    @FXML
    private ChoiceBox<String> sexChange0;
    @FXML
    private ChoiceBox<String> departmentChange;
    @FXML
    private ChoiceBox<String> techtitleChange;
    @FXML
    private DatePicker birthdayChange;
    @FXML
    private Button updateButton0;
    @FXML
    private TextField userIdChangeField1;
    @FXML
    private TextField userNameChangeField1;
    @FXML
    private ChoiceBox<String> sexchange1;
    @FXML
    private DatePicker birthdayChange0;
    @FXML
    private ChoiceBox<String> specialityChange;
    @FXML
    private ChoiceBox<String> departmentChange0;
    @FXML
    private TextField classChangeField;
    @FXML
    private Button UpdateButton1;
    @FXML
    private TextField delTcidField;
    @FXML
    private Button delCourseButton;


    @FXML
    private void initialize() {
        /*
        * 学生信息
        * */
        stuIdColumn.setCellValueFactory(cellData -> cellData.getValue().stuIdProperty());
        stuNameColumn.setCellValueFactory(cellData -> cellData.getValue().stuNameProperty());
        showStuMessage(null);
        stuMessageTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showStuMessage(newValue))
        );
        /*
        * 老师信息
        * */
        teaIdColumn.setCellValueFactory(cellData -> cellData.getValue().teaIdProperty());
        teaNameColumn.setCellValueFactory(cellData -> cellData.getValue().teaNameProperty());
        showTeaMessage(null);
        teaMessageTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showTeaMessage(newValue))
        );
        /*
        * 查询成绩
        * */
        courseIdColumn.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        stuIdColumn0.setCellValueFactory(celData -> celData.getValue().stuIdProperty());
        showScore(null);
        queryScoreTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showScore(newValue))
        );
        /*
        * 查询评价
        * */
        teaIdColumn0.setCellValueFactory(cellData -> cellData.getValue().teaIdProperty());
        teaNameColumn0.setCellValueFactory(cellData -> cellData.getValue().teaNameProperty());
        showEva(null);
        teaMessageTableView0.getSelectionModel().selectedItemProperty().addListener(
                ((observable,oldValue,newValue) -> showEva(newValue))
        );

        courseIdColumn1.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn1.setCellValueFactory(cellDate -> cellDate.getValue().courseNameProperty());
        evaluateColumn.setCellValueFactory(cellData -> cellData.getValue().evaluateProperty());

    }
    public void setApp(Main application) {
        this.application = application;
        account = application.getAccount();
        username.setText(account.getAdmin().getAname());
        stuMessageTableView.setItems(application.getStuMessages());
        teaMessageTableView.setItems(application.getTeaMessages());
        queryScoreTableView.setItems(application.getAllScore());
        teaMessageTableView0.setItems(application.getTeaMessages0());
        showEvaTableView.setItems(showEvas);
        sexChange.setItems(FXCollections.observableArrayList("男","女"));
        sexChange0.setItems(FXCollections.observableArrayList("男","女"));
        departmentChange.setItems(FXCollections.observableArrayList("自动化学院","计算机学院","信息工程学院","外国语学院","土木工程学院"));
        techtitleChange.setItems(FXCollections.observableArrayList("助教","讲师","副教授","教授"));
        sexchange1.setItems(FXCollections.observableArrayList("男","女"));
        departmentChange0.setItems(FXCollections.observableArrayList("自动化学院","计算机学院","信息工程学院","外国语学院","土木工程学院"));
        specialityChange.setItems(FXCollections.observableArrayList(
                "软件工程","网络工程","计算机与科学技术","电气工程及其自动化","自动化","物联网工程","通信工程","信息工程","电子信息工程",
                "英语","日语","韩语","土木工程","工程管理","交通工程"));

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
        PasswordField password = new PasswordField();
        password.setPromptText("原密码");
        PasswordField password0 = new PasswordField();
        password0.setPromptText("修改密码");
        PasswordField password1 = new PasswordField();
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
    /*
    * 学生信息
    * */
    public void showStuMessage(ShowStuMessage showStuMessage){
        if(showStuMessage!=null) {
            stuIdLabel.setText(showStuMessage.getStuId());
            stuNameLabel.setText(showStuMessage.getStuName());
            sexLabel.setText(showStuMessage.getSex());
            birthdayLabel.setText(showStuMessage.getBirthday());
            specialityLabel.setText(showStuMessage.getSpeciality());
            departmentLabel.setText(showStuMessage.getDepartment());
            clazzLabel.setText(showStuMessage.getClazz());
            techtitleLabel.setText("");
        }else {
            stuIdLabel.setText("");
            stuNameLabel.setText("");
            sexLabel.setText("");
            birthdayLabel.setText("");
            specialityLabel.setText("");
            departmentLabel.setText("");
            clazzLabel.setText("");
            techtitleLabel.setText("");
        }
    }
    /*
    * 老师信息
    * */
    public void showTeaMessage(ShowTeaMessage showTeaMessage){
        if(showTeaMessage!=null) {
            stuIdLabel.setText(showTeaMessage.getTeaId());
            stuNameLabel.setText(showTeaMessage.getTeaName());
            sexLabel.setText(showTeaMessage.getSex());
            birthdayLabel.setText(showTeaMessage.getBirthday());
            specialityLabel.setText("");
            departmentLabel.setText(showTeaMessage.getDepartment());
            clazzLabel.setText("");
            techtitleLabel.setText(showTeaMessage.getTechtile());
        }else {
            stuIdLabel.setText("");
            stuNameLabel.setText("");
            sexLabel.setText("");
            birthdayLabel.setText("");
            specialityLabel.setText("");
            departmentLabel.setText("");
            clazzLabel.setText("");
            techtitleLabel.setText("");
        }
    }
    public void showScore(ShowQueryScore showQueryScore){
        if (showQueryScore != null) {
            courseIdLabel.setText(showQueryScore.getCourseId());
            courseNameLabel.setText(showQueryScore.getCourseName());
            courseCreditLabel.setText(showQueryScore.getCourseCredit());
            courseScoreLabel.setText(showQueryScore.getCourseScore());
            stuIdLabel0.setText(showQueryScore.getStuId());
            stuNameLabel0.setText(showQueryScore.getStuName());
        }else {
            courseIdLabel.setText("");
            courseNameLabel.setText("");
            courseCreditLabel.setText("" );
            courseScoreLabel.setText("");
            stuIdLabel0.setText("");
            stuNameLabel0.setText("");
        }
    }
    public ObservableList<QueryEva> showEva(ShowTeaMessage teaMessage){
        if (teaMessage != null) {
            showEvas.clear();
            List<Evaluate> list = add.queryEvaluate(Integer.parseInt(teaMessage.getTeaId()));
            for (Evaluate e : list) {
                QueryEva queryEva = new QueryEva();
                queryEva.setCourseId(e.getTcourse().getCourse().getCno());
                queryEva.setCourseName(e.getTcourse().getCourse().getCname());
                queryEva.setEvaluate(e.getRank());

                showEvas.add(queryEva);
            }
        }
        return showEvas;
    }
    public void setEnterUserButton(ActionEvent event) {
        boolean flag = add.addAccount(Integer.parseInt(userPidField.getText()),Integer.parseInt(userIdField.getText()));
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("录入用户");
            alert.setHeaderText(null);
            alert.setContentText("录入成功");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("录入用户");
            alert.setHeaderText(null);
            alert.setContentText("录入失败");
            alert.showAndWait();
        }
    }
    @FXML
    public void setDelUserButton(ActionEvent event){
        boolean flag = add.delAccount(userIdField0.getText());
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("删除用户");
            alert.setHeaderText(null);
            alert.setContentText("删除成功");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("删除用户");
            alert.setHeaderText(null);
            alert.setContentText("删除失败");
            alert.showAndWait();
        }
    }
    @FXML
    public void setUpdateButton(ActionEvent event){
        boolean flag = add.updateAccount(userIdChangeField.getText(),userNameChangeField.getText(),sexChange.getSelectionModel().getSelectedItem());
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改成功");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改失败");
            alert.showAndWait();
        }
    }
    public void setUpdateButton0(ActionEvent event) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = birthdayChange.getValue();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());
        int dno = 0;
        if (departmentChange.getSelectionModel().getSelectedItem().equals("自动化学院")) dno = 1001;
        if (departmentChange.getSelectionModel().getSelectedItem().equals("计算机学院")) dno = 1002;
        if (departmentChange.getSelectionModel().getSelectedItem().equals("信息工程学院")) dno = 1003;
        if (departmentChange.getSelectionModel().getSelectedItem().equals("外国语学院")) dno = 1004;
        if (departmentChange.getSelectionModel().getSelectedItem().equals("土木工程学院")) dno = 1005;
        boolean flag = add.updateAccount(userIdChangeField0.getText(),userNameChangeField0.getText(),sexChange0.getSelectionModel().getSelectedItem(),date,dno,techtitleChange.getSelectionModel().getSelectedItem());
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改成功");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改失败");
            alert.showAndWait();
        }
    }
    public void setUpdateButton1(ActionEvent event) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = birthdayChange0.getValue();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());
        int dno = 0;

        if (departmentChange0.getSelectionModel().getSelectedItem().equals("自动化学院")) dno = 1001;
        if (departmentChange0.getSelectionModel().getSelectedItem().equals("计算机学院")) dno = 1002;
        if (departmentChange0.getSelectionModel().getSelectedItem().equals("信息工程学院")) dno = 1003;
        if (departmentChange0.getSelectionModel().getSelectedItem().equals("外国语学院")) dno = 1004;
        if (departmentChange0.getSelectionModel().getSelectedItem().equals("土木工程学院")) dno = 1005;
        int spno = 0;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("软件工程")) spno = 101;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("网络工程")) spno = 102;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("计算机网络与科学技术")) spno = 103;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("电气工程及其自动化")) spno = 104;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("自动化")) spno = 105;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("物联网工程")) spno = 106;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("通信工程")) spno = 107;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("信息工程")) spno = 108;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("电子信息工程")) spno = 109;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("英语")) spno = 110;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("日语")) spno = 111;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("韩语")) spno = 112;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("土木工程")) spno = 113;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("工程管理")) spno = 114;
        if (specialityChange.getSelectionModel().getSelectedItem().equals("交通工程")) spno = 115;

        boolean flag = add.updateAccount(userIdChangeField1.getText(),userNameChangeField1.getText(),sexchange1.getSelectionModel().getSelectedItem(),date,dno,spno,classChangeField.getText());
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改成功");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("修改用户");
            alert.setHeaderText(null);
            alert.setContentText("修改失败");
            alert.showAndWait();
        }
    }
    @FXML
    public void setDelCourseButton(ActionEvent event){
        boolean flag = add.delTcourse(Integer.parseInt(delTcidField.getText()));
        if (flag) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("删除课表" );
            alert.setHeaderText(null);
            alert.setContentText("删除成功");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("删除课表");
            alert.setHeaderText(null);
            alert.setContentText("删除失败");
            alert.showAndWait();
        }
    }
}
