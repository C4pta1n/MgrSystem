package com.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class StuMgrController extends AnchorPane {
    private TableView menuTable;
    private TableColumn menuColumn;

    private Main application;
    private void initialize() {

    }
    public void setApp(Main application) {
        this.application = application;
    }
}
