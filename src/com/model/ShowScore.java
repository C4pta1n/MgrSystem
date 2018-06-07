package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowScore {


    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty score;

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getScore() {
        return score.get();
    }

    public StringProperty scoreProperty() {
        return score;
    }

    public void setScore(String score) {
        this.score.set(score);
    }
    public ShowScore(String id, String name, String score) {
        this.id = new SimpleStringProperty(id);
        this.score = new SimpleStringProperty(score);
        this.name = new SimpleStringProperty(name);
    }
    public ShowScore(){this(null,null,null);}
}
