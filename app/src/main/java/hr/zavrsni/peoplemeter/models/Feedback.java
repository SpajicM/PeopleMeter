package hr.zavrsni.peoplemeter.models;

import java.io.Serializable;

public class Feedback implements Serializable {

    private int id;
    private String title;
    private String description;
    private User user;
    private Program program;

    public Feedback(String title, String description, User user, Program program) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.program = program;
    }

    public Feedback(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
