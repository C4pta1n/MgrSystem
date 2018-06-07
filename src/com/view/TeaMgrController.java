package com.view;

import com.bean.Account;
import com.dao.AccountDao;
import com.dao.TeacherDao;
import com.dao.impl.AccountDaoImpl;
import com.dao.impl.TeacherDaoImpl;
import com.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class TeaMgrController extends AnchorPane {
    private Main application;
    private AccountDao acd = new AccountDaoImpl();
    private Account account = new Account();
    private TeacherDao tead = new TeacherDaoImpl();

    private int stuId;
    private int courseId;

    @FXML
    private Button logoutButton;
    @FXML
    private Label username;
    @FXML
    private Button changPasswordButton;
    @FXML
    private TableView<ShowQueryScore> showScoreTable;
    @FXML
    private TableColumn<ShowQueryScore,String> courseIdColumn;
    @FXML
    private TableColumn<ShowQueryScore,String> courseNameColumn;
    @FXML
    private TableColumn<ShowQueryScore,String> stuIdforscColumn;
    @FXML
    private Label courseIdLabel;
    @FXML
    private Label courseNameLabel;
    @FXML
    private Label stuIdLable;
    @FXML
    private Label stuNameLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private TableView<EnteringScore> enteringScoreTableView;
    @FXML
    private TableColumn<EnteringScore,String> courseIdColumn0;
    @FXML
    private TableColumn<EnteringScore,String> courseNameColumn0;
    @FXML
    private TableColumn<EnteringScore,String> stuIdforscColumn0;
    @FXML
    private Label courseIdLabel0;
    @FXML
    private Label courseNameLabel0;
    @FXML
    private Label stuIdLable0;
    @FXML
    private Label stuNameLabel0;
    @FXML
    private Label creditLabel0;
    @FXML
    private Button enterScoreButton;
    @FXML
    private TableView<ShowTeaCourses> teaCoursesTableView;
    @FXML
    private TableColumn<ShowTeaCourses,String> tcidColumn;
    @FXML
    private TableColumn<ShowTeaCourses,String> clazzColumn;
    @FXML
    private TableColumn<ShowTeaCourses,String> courseIdColumn1;
    @FXML
    private TableColumn<ShowTeaCourses,String> courseNameColumn1;
    @FXML
    private TableColumn<ShowTeaCourses,String> semesterColumn;
    @FXML
    private TableColumn<ShowTeaCourses,String> schoolYearColumn;
    @FXML
    private TableView<QueryEva> evaTableView;
    @FXML
    private TableColumn<QueryEva,String> courseIdColumn2;
    @FXML
    private TableColumn<QueryEva,String> courseNameColumn2;
    @FXML
    private TableColumn<QueryEva,String> semesterColumn0;
    @FXML
    private TableColumn<QueryEva,String> schoolYearColumn0;
    @FXML
    private TableColumn<QueryEva,String> evaluateColumn;
    @FXML
    private Label tidLabel;
    @FXML
    private Label tNameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label birthDayLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private Label tecLabel;

    @FXML
    private void initialize() {
        /*
        * 查询成绩
        * */
        courseIdColumn.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        stuIdforscColumn.setCellValueFactory(cellData -> cellData.getValue().stuIdProperty());

        QueryScore(null);
        showScoreTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> QueryScore(newValue))
        );
        /*
        * 录入成绩
        * */
        courseIdColumn0.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn0.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        stuIdforscColumn0.setCellValueFactory(cellData -> cellData.getValue().stuIdProperty());
        enteringScore(null);
        enteringScoreTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> enteringScore(newValue))
        );

        /*
        * 老师课表
        * */
        tcidColumn.setCellValueFactory(cellData -> cellData.getValue().tcidProperty());
        clazzColumn.setCellValueFactory(cellData -> cellData.getValue().clazzProperty());
        courseIdColumn1.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn1.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        semesterColumn.setCellValueFactory(cellData -> cellData.getValue().semesterProperty());
        schoolYearColumn.setCellValueFactory(cellData -> cellData.getValue().schoolYearProperty());
        /*
        * 查询评价
        * */
        courseIdColumn2.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn2.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        semesterColumn0.setCellValueFactory(cellData -> cellData.getValue().semesterProperty());
        schoolYearColumn0.setCellValueFactory(cellData -> cellData.getValue().schoolYearProperty());
        evaluateColumn.setCellValueFactory(cellData -> cellData.getValue().evaluateProperty());
    }
    public void setApp(Main application) {
        this.application = application;
        account = application.getAccount();
        username.setText(account.getTeacher().getTname());
        showScoreTable.setItems(application.getScores0());
        enteringScoreTableView.setItems(application.getEnteringScores());
        teaCoursesTableView.setItems(application.getTeaCourses());
        evaTableView.setItems(application.getQueryEvas());
        /*
        * 个人信息
        * */
        tidLabel.setText(String.valueOf(account.getTeacher().getTno()));
        tNameLabel.setText(account.getTeacher().getTname());
        sexLabel.setText(account.getTeacher().getTsex());
        birthDayLabel.setText(String.valueOf(account.getTeacher().getTbirthday()));
        departmentLabel.setText(account.getTeacher().getDepartment().getDeptname());
        tecLabel.setText(account.getTeacher().getTechtitle());
    }
    /*
    *注销
    **/
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
    /*
    * 修改密码
    * */
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
    * 查询成绩
    * */
    private void QueryScore(ShowQueryScore showQueryScore) {
        if (showQueryScore != null) {
            courseIdLabel.setText(showQueryScore.getCourseId());
            courseNameLabel.setText(showQueryScore.getCourseName());
            stuIdLable.setText(showQueryScore.getStuId());
            stuNameLabel.setText(showQueryScore.getStuName());
            creditLabel.setText(showQueryScore.getCourseCredit());
            scoreLabel.setText(showQueryScore.getCourseScore());

        } else {
            courseIdLabel.setText("");
            courseNameLabel.setText("");
            stuIdLable.setText("");
            stuNameLabel.setText("");
            creditLabel.setText("");
            scoreLabel.setText("");
        }
    }
    private void enteringScore(EnteringScore enteringScore) {
        if (enteringScore != null) {
            courseIdLabel0.setText(enteringScore.getCourseId());
            courseNameLabel0.setText(enteringScore.getCourseName());
            stuIdLable0.setText(enteringScore.getStuId());
            stuNameLabel0.setText(enteringScore.getStuName());
            creditLabel0.setText(enteringScore.getCourseCredit());
            stuId = Integer.parseInt(enteringScore.getStuId());
            courseId = Integer.parseInt(enteringScore.getCourseId());
        } else {
            courseIdLabel.setText("");
            courseNameLabel.setText("");
            stuIdLable.setText("");
            stuNameLabel.setText("");
            creditLabel.setText("");
        }
    }
    @FXML
    public void setEnterScoreButton(){
        int selectedIndex = enteringScoreTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 ) {
            TextInputDialog dialog = new TextInputDialog("成绩");
            dialog.setTitle("录入成绩");
            dialog.setHeaderText("录入成绩");
            dialog.setContentText("请输入成绩:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                boolean flag = tead.updateScores(stuId,courseId, Integer.parseInt(result.get()));
                if (flag) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("录入成绩");
                    alert.setHeaderText(null);
                    alert.setContentText("录入成功");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("录入成绩");
                    alert.setHeaderText(null);
                    alert.setContentText("录入失败");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("录入成绩");
            alert.setHeaderText("你还没选择录入目标");
            alert.setContentText("请选择一个你学生进行录入成绩");

            alert.showAndWait();
        }
    }

}
