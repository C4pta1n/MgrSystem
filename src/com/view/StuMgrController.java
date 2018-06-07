package com.view;

import com.bean.Account;
import com.bean.Course;
import com.dao.AccountDao;
import com.dao.StudentDao;
import com.dao.impl.AccountDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.model.ShowCourse;
import com.model.ShowEva;
import com.model.ShowScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StuMgrController extends AnchorPane {
    private Main application;
    /*
    * evaluate
    * */
    private int tcid;

    private Account account = new Account();
    private AccountDao acd = new AccountDaoImpl();
    private StudentDao sd = new StudentDaoImpl();


    @FXML
    private Button logoutButton;
    @FXML
    private Label username;
    @FXML
    private TableView<ShowEva> courseEvaTable;
    @FXML
    private TableColumn<ShowEva, String> cnameColumn;
    @FXML
    private TableColumn<ShowEva, String> coursenoColmn;
    @FXML
    private TableColumn<ShowEva, String> tnameColumn;
    @FXML
    private Button changPasswordButton;
    @FXML
    private TableView<ShowCourse> tcourseTableView;
    @FXML
    private TableColumn<ShowCourse, String> cnoColumn;
    @FXML
    private TableColumn<ShowCourse, String> tcnameColumn;
    @FXML
    private TableColumn<ShowCourse, String> creditColumn;
    @FXML
    private TableColumn<ShowCourse, String> semesterColumn;
    @FXML
    private TableColumn<ShowCourse, String> schoolYearColumn;
    @FXML
    private TableView<ShowScore> scoresTableView;
    @FXML
    private TableColumn<ShowScore, String> scoreColumn;
    @FXML
    private TableColumn<ShowScore, String> courseNameColumn;
    @FXML
    private TableColumn<ShowScore, String> courseIdtColumn;
    @FXML
    private Label courseNameLable;
    @FXML
    private Label teaNameLable;
    @FXML
    private Button evaluateButton;
    @FXML
    private Label stuIdLable;
    @FXML
    private Label stuNameLable;
    @FXML
    private Label stuSexLable;
    @FXML
    private Label stuBirthdayLable;
    @FXML
    private Label stuDepartmentLable;
    @FXML
    private Label stuSpecialityLable;
    @FXML
    private Label stuclazzLable;

    @FXML
    private void initialize() {
        /*
         * 教学评价
         * */
        cnameColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        coursenoColmn.setCellValueFactory(cellData -> cellData.getValue().couseidProperty());
        tnameColumn.setCellValueFactory(cellData -> cellData.getValue().tameforcourseProperty());

        Evaluate(null);
        courseEvaTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> Evaluate(newValue))
        );
        /*
         * 查询课表
         * */
        cnoColumn.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        tcnameColumn.setCellValueFactory(cellData -> cellData.getValue().coursenameProperty());
        creditColumn.setCellValueFactory(cellData -> cellData.getValue().creditProperty());
        semesterColumn.setCellValueFactory(cellData -> cellData.getValue().semesterProperty());
        schoolYearColumn.setCellValueFactory(cellData -> cellData.getValue().schoolYearProperty());
        /*
         * 查询成绩
         * */
        courseIdtColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());


    }

    public void setApp(Main application) {
        this.application = application;
        account = application.getAccount();
        username.setText(account.getStudent().getSname());
        courseEvaTable.setItems(application.getEvaCourses());
        tcourseTableView.setItems(application.getCourse());
        scoresTableView.setItems(application.getScores());
        /*
         * 学生信息
         * */
        stuIdLable.setText(String.valueOf(account.getStudent().getSno()));
        stuNameLable.setText(account.getStudent().getSname());
        stuSexLable.setText(account.getStudent().getSex());
        stuBirthdayLable.setText(String.valueOf(account.getStudent().getSbirthday()));
        stuDepartmentLable.setText(account.getStudent().getDepartment().getDeptname());
        stuSpecialityLable.setText(account.getStudent().getSpeciality().getSpname());
        stuclazzLable.setText(account.getStudent().getClassno());
    }

    /*
     * 注销
     * */
    public void logout() {
        if (application == null) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("教务管理系统");
        alert.setHeaderText(null);
        alert.setContentText("已退出登陆");
        alert.showAndWait();
        application.userLogout();
    }

    /*
     * 修改密码
     * */
    @FXML
    public void setChangPasswordButton(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("教务系统");
        dialog.setHeaderText("修改密码");
        dialog.setGraphic(new ImageView(this.getClass().getResource("card-file.png").toString()));
        ButtonType enterButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(enterButtonType, ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));
        PasswordField password = new PasswordField();
        password.setPromptText("原密码");
        PasswordField password0 = new PasswordField();
        password0.setPromptText("修改密码");
        PasswordField password1 = new PasswordField();
        password1.setPromptText("确认密码");

        gridPane.add(new Label("原密码"), 0, 0);
        gridPane.add(password, 1, 0);
        gridPane.add(new Label("修改密码"), 0, 1);
        gridPane.add(password0, 1, 1);
        gridPane.add(new Label("确认密码"), 0, 2);
        gridPane.add(password1, 1, 2);

        Node enterButton = dialog.getDialogPane().lookupButton(enterButtonType);
        enterButton.setDisable(true);
        password0.textProperty().addListener((observable, oldValue, newValue) -> {
            enterButton.setDisable(newValue.trim().isEmpty());
        });
        dialog.getDialogPane().setContent(gridPane);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == enterButtonType) {
                return password0.getText();
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(cnoScore -> {
            if (acd.changePassword(account, password.getText(), password0.getText(), password1.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("修改密码");
                alert.setHeaderText(null);
                alert.setContentText("修改成功！");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("修改密码");
                alert.setHeaderText(null);
                alert.setContentText("修改失败！原密码错误或修改的两次密码不一致");
                alert.showAndWait();
            }
        });
    }

    /*
     * 评教
     * */
    private void Evaluate(ShowEva showEva) {
        if (showEva != null) {
            courseNameLable.setText(showEva.getCourseName());
            teaNameLable.setText(showEva.getTameforcourse());
            tcid = showEva.getTcid();
        } else {
            courseNameLable.setText("");
            teaNameLable.setText("");
        }
    }

    @FXML
    private void setEvaluateButton(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("优秀");
        choices.add("良好");
        choices.add("一般");
        choices.add("及格");
        choices.add("不及格");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("及格", choices);
        dialog.setTitle("课程评价");
        dialog.setHeaderText("课程评价");
        dialog.setGraphic(new ImageView(this.getClass().getResource("card-file.png").toString()));
        dialog.setContentText("请为课程评分：");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            int selectedIndex = courseEvaTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                boolean flag = sd.evaluate(tcid,account.getStudent().getSno(),result.get());
                if (flag){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("课程评价");
                    alert.setHeaderText(null);
                    alert.setContentText("评价成功");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("课程评价");
                    alert.setHeaderText(null);
                    alert.setContentText("评价失败");
                    alert.showAndWait();
                }

            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("课程评价");
                alert.setHeaderText(null);
                alert.setContentText("你还没选择要评价的课程");
                alert.showAndWait();
            }
        }
    }
}
