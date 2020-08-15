package hr.zavrsni.peoplemeter.models;

import java.io.Serializable;
import java.util.List;

public class Channel implements Serializable {
    private int id;
    private String name;
    private String description;
    private List<Schedule> schedules;
    private String imageUrl;

    public Channel(int id, String name, String description, List<Schedule> schedules, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.schedules = schedules;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
