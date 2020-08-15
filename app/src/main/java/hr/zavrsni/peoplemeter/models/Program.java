package hr.zavrsni.peoplemeter.models;

import java.io.Serializable;
import java.util.Date;

public class Program implements Serializable {
    private int id;
    private Date dateProduced;
    private String title;
    private String description;

    public Program(int id, Date dateProduced, String title, String description) {
        this.id = id;
        this.dateProduced = dateProduced;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
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
}
