package com.view;

import com.bean.Account;
import com.bean.Evaluate;
import com.bean.Scores;
import com.bean.Tcourse;
import com.dao.*;
import com.dao.impl.*;
import com.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;

    private AccountDao acd = new AccountDaoImpl();
    private StudentDao sd = new StudentDaoImpl();
    private TcourseDao tcd = new TcourseDaoImpl();
    private TeacherDao tead = new TeacherDaoImpl();
    private AdminDao add = new AdminDaoImpl();
    Account account;

    private ObservableList<ShowEva> evacourses = FXCollections.observableArrayList();
    private ObservableList<ShowCourse> course = FXCollections.observableArrayList();
    private ObservableList<ShowScore> scores = FXCollections.observableArrayList();

    private ObservableList<ShowQueryScore> scores0 = FXCollections.observableArrayList();
    private ObservableList<EnteringScore> enteringScores = FXCollections.observableArrayList();
    private ObservableList<ShowTeaCourses> teaCourses = FXCollections.observableArrayList();
    private ObservableList<QueryEva> queryEvas = FXCollections.observableArrayList();

    private ObservableList<ShowStuMessage> stuMessages = FXCollections.observableArrayList();
    private ObservableList<ShowTeaMessage> teaMessages = FXCollections.observableArrayList();
    private ObservableList<ShowQueryScore> allScore = FXCollections.observableArrayList();
    private ObservableList<ShowTeaMessage> teaMessages0 = FXCollections.observableArrayList();
    private ObservableList<QueryEva> showEvas = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            stage = primaryStage;
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            stage.setTitle("教务系统");
            gotoLogin();
            primaryStage.show();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void gotoLogin(){
        try {
            LoginController login = (LoginController) replaceSceneContent("LoginView.fxml");
            login.setApp(this);
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void gotoStuMGR(){
        try {
            StuMgrController stuMgrController = (StuMgrController) replaceSceneContent("StuMgrView.fxml");
            stuMgrController.setApp(this);
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void gotoTeacMGR(){
        try {
            TeaMgrController teaMgrController = (TeaMgrController) replaceSceneContent("TeacMgrView.fxml");
            teaMgrController.setApp(this);
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void gotoAdiminMGR(){
        try {
            AdminMgrController adminMgrController = (AdminMgrController) replaceSceneContent("AdminMgrView.fxml");
            adminMgrController.setApp(this);
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /*
    *教学评价
    * */

    public ObservableList<ShowEva> getEvaCourses(){

        List<Tcourse> list = sd.queryCourse(account);
        for (Tcourse t : list){
            ShowEva showEva = new ShowEva();
            showEva.setCouseid(t.getCourse().getCno());
            showEva.setCourseName(t.getCourse().getCname());
            showEva.setTameforcourse(t.getTeacher().getTname());
            showEva.setTcid(t.getTcid());
            evacourses.add(showEva);
        }
        return evacourses;
    }
    /*
    * 查询课表
    * */
    public ObservableList<ShowCourse> getCourse(){
        List<Tcourse> list = sd.queryCourse(account);
        for (Tcourse t : list){
            ShowCourse showCourse = new ShowCourse();
            showCourse.setCourseId(t.getCourse().getCno());
            showCourse.setCoursename(t.getCourse().getCname());
            showCourse.setCredit(t.getCourse().getCredit());
            showCourse.setSemester(t.getSemester());
            showCourse.setSchoolYear(t.getSchoolyear());
            course.add(showCourse);
        }
        return course;
    }
    /*
    * 查询成绩
    * */
    public ObservableList<ShowScore> getScores(){
        List<Scores> list = sd.findScoreByID(account.getStudent().getSno());
        for (Scores s : list) {
            ShowScore showScores = new ShowScore();
            showScores.setId(tcd.findByTcid(s.getTcid()).getCourse().getCno());
            showScores.setName(tcd.findByTcid(s.getTcid()).getCourse().getCname());
            showScores.setScore(String.valueOf(s.getScore()));
            scores.add(showScores);
        }
        return scores;
    }
    /*
    * 查询成绩
    * */
    public ObservableList<ShowQueryScore> getScores0(){
        List<Scores> list = new ArrayList<>();
        list = tead.queryScores(account);
        for (Scores s : list) {
            ShowQueryScore queryScore = new ShowQueryScore();
            queryScore.setCourseId(tcd.findByTcid(s.getTcid()).getCourse().getCno());
            queryScore.setCourseName(tcd.findByTcid(s.getTcid()).getCourse().getCname());
            queryScore.setStuId(String.valueOf(s.getStudent().getSno()));
            queryScore.setStuName(s.getStudent().getSname());
            queryScore.setCourseCredit(tcd.findByTcid(s.getTcid()).getCourse().getCredit());
            queryScore.setCourseScore(String.valueOf(s.getScore()));
            scores0.add(queryScore);
        }
        return scores0;
    }
    /*
    * 录入成绩
    * */
    public ObservableList<EnteringScore> getEnteringScores(){
        List<Scores> list = tead.queryScores(account);
        for (Scores s : list) {
            if (s.getScore() == 0) {
                EnteringScore enteringScore = new EnteringScore();
                enteringScore.setCourseId(tcd.findByTcid(s.getTcid()).getCourse().getCno());
                enteringScore.setCourseName(tcd.findByTcid(s.getTcid()).getCourse().getCname());
                enteringScore.setStuId(String.valueOf(s.getStudent().getSno()));
                enteringScore.setStuName(s.getStudent().getSname());
                enteringScore.setCourseCredit(tcd.findByTcid(s.getTcid()).getCourse().getCredit());
                enteringScore.setCourseScore(String.valueOf(s.getScore()));
                enteringScores.add(enteringScore);
            }
        }
        return enteringScores;
    }
    /*
    * 老师课表
    * */
    public ObservableList<ShowTeaCourses> getTeaCourses(){
        List<Tcourse> list = tead.queryCourse(account);
        for (Tcourse t : list){
            ShowTeaCourses showTeaCourses = new ShowTeaCourses();
            showTeaCourses.setTcid(String.valueOf(t.getTcid()));
            showTeaCourses.setClazz(t.getClazz().getClassName());
            showTeaCourses.setCourseId(t.getCourse().getCno());
            showTeaCourses.setCourseName(t.getCourse().getCname());
            showTeaCourses.setSemester(t.getSemester());
            showTeaCourses.setSchoolYear(t.getSchoolyear());
            teaCourses.add(showTeaCourses);
        }
        return teaCourses;
    }
    /*
    * 查询评价
    * */
    public ObservableList<QueryEva> getQueryEvas(){
        List<Evaluate> list = tead.queryEvaluate(account);
        for (Evaluate e : list) {
            QueryEva queryEva = new QueryEva();
            queryEva.setCourseId(e.getTcourse().getCourse().getCno());
            queryEva.setCourseName(e.getTcourse().getCourse().getCname());
            queryEva.setSemester(e.getTcourse().getSemester());
            queryEva.setSchoolYear(e.getTcourse().getSchoolyear());
            queryEva.setEvaluate(e.getRank());
            queryEvas.add(queryEva);
        }
        return queryEvas;
    }
    /*
    * 查询学生信息
    * */
    public ObservableList<ShowStuMessage> getStuMessages(){
        List<Account> list = add.queryuser();
        for (Account a : list) {
            if (a.getPid() == 3) {
                ShowStuMessage showStuMessage = new ShowStuMessage();
                showStuMessage.setStuId(String.valueOf(a.getStudent().getSno()));
                showStuMessage.setStuName(a.getStudent().getSname());
                showStuMessage.setSex(a.getStudent().getSex());
                showStuMessage.setBirthday(String.valueOf(a.getStudent().getSbirthday()));
                showStuMessage.setSpeciality(a.getStudent().getSpeciality().getSpname());
                showStuMessage.setDepartment(a.getStudent().getDepartment().getDeptname());
                showStuMessage.setClazz(a.getStudent().getClassno());
                stuMessages.add(showStuMessage);
            }
        }
        return stuMessages;
    }
    /*
    * 查询老师信息
    * */
    public ObservableList<ShowTeaMessage> getTeaMessages(){
        List<Account> list = add.queryuser();
        for (Account a : list) {
            ShowTeaMessage showTeaMessage = new ShowTeaMessage();
            if (a.getPid() == 2) {
                showTeaMessage.setTeaId(String.valueOf(a.getTeacher().getTno()));
                showTeaMessage.setTeaName(a.getTeacher().getTname());
                showTeaMessage.setSex(a.getTeacher().getTsex());
                showTeaMessage.setBirthday(String.valueOf(a.getTeacher().getTbirthday()));
                showTeaMessage.setDepartment(a.getTeacher().getDepartment().getDeptname());
                showTeaMessage.setTechtile(a.getTeacher().getTechtitle());
                teaMessages.add(showTeaMessage);
            }
        }
        return teaMessages;
    }
    /*
    * 查询所有成绩
    * */
    public ObservableList<ShowQueryScore> getAllScore(){
        List<Scores> list = add.queryScores();
        for (Scores s : list) {
            ShowQueryScore showQueryScore = new ShowQueryScore();
            showQueryScore.setStuId(String.valueOf(s.getStudent().getSno()));
            showQueryScore.setStuName(s.getStudent().getSname());
            showQueryScore.setCourseId(tcd.findByTcid(s.getTcid()).getCourse().getCno());
            showQueryScore.setCourseName(tcd.findByTcid(s.getTcid()).getCourse().getCname());
            showQueryScore.setCourseCredit(tcd.findByTcid(s.getTcid()).getCourse().getCredit());
            showQueryScore.setCourseScore(String.valueOf(s.getScore()));
            allScore.add(showQueryScore);
        }
        return allScore;
    }
    /*
    * 查询所有评价
    * */
    public ObservableList<ShowTeaMessage> getTeaMessages0(){
        List<Account> list = add.queryuser();
        for (Account a : list) {
            ShowTeaMessage showTeaMessage = new ShowTeaMessage();
            if (a.getPid() == 2) {
                showTeaMessage.setTeaId(String.valueOf(a.getTeacher().getTno()));
                showTeaMessage.setTeaName(a.getTeacher().getTname());
                showTeaMessage.setSex(a.getTeacher().getTsex());
                showTeaMessage.setBirthday(String.valueOf(a.getTeacher().getTbirthday()));
                showTeaMessage.setDepartment(a.getTeacher().getDepartment().getDeptname());
                showTeaMessage.setTechtile(a.getTeacher().getTechtitle());
                teaMessages0.add(showTeaMessage);
            }
        }
        return teaMessages0;
    }








    public Account getAccount(){
        return account;
    }

    public boolean userLogin(String id, String password){
        account = acd.login(id,password);
        if (account != null) {
            if (account.getPid()==3) gotoStuMGR();
            if (account.getPid()==2) gotoTeacMGR();
            if (account.getPid()==1) gotoAdiminMGR();
            return true;
        }
        else return false;
    }
     void userLogout(){
        account = null;
        course = FXCollections.observableArrayList();
        scores = FXCollections.observableArrayList();
        evacourses = FXCollections.observableArrayList();
        scores0 = FXCollections.observableArrayList();
        enteringScores = FXCollections.observableArrayList();
        teaCourses = FXCollections.observableArrayList();
        queryEvas = FXCollections.observableArrayList();
        stuMessages = FXCollections.observableArrayList();
        teaMessages = FXCollections.observableArrayList();
        allScore = FXCollections.observableArrayList();
        teaMessages0 = FXCollections.observableArrayList();
        gotoLogin();
    }

    private Node replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }

        // Store the stage width and height in case the user has resized the window
        double stageWidth = stage.getWidth();
        if (!Double.isNaN(stageWidth)) {
            stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
        }

        double stageHeight = stage.getHeight();
        if (!Double.isNaN(stageHeight)) {
            stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
        }

        Scene scene = new Scene(page);
        if (!Double.isNaN(stageWidth)) {
            page.setPrefWidth(stageWidth);
        }
        if (!Double.isNaN(stageHeight)) {
            page.setPrefHeight(stageHeight);
        }

        stage.setScene(scene);
        stage.sizeToScene();
        return (Node) loader.getController();
    }
    public Main(){

    }
    public static void main(String[] args) {
        launch(args);
    }
}
