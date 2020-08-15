package hr.zavrsni.peoplemeter.models;

import java.io.Serializable;
import java.util.Date;

import androidx.annotation.NonNull;

public class Schedule implements Serializable {
    private int id;
    private Date broadcastStartDate;
    private Date broadcastEndDate;
    private Program program;
    private Channel channel;

    public Schedule(int id, Date broadcastStartDate, Date broadcastEndDate, Program program, Channel channel) {
        this.id = id;
        this.broadcastStartDate = broadcastStartDate;
        this.broadcastEndDate = broadcastEndDate;
        this.program = program;
        this.channel = channel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBroadcastStartDate() {
        return broadcastStartDate;
    }

    public void setBroadcastStartDate(Date broadcastStartDate) {
        this.broadcastStartDate = broadcastStartDate;
    }

    public Date getBroadcastEndDate() {
        return broadcastEndDate;
    }

    public void setBroadcastEndDate(Date broadcastEndDate) {
        this.broadcastEndDate = broadcastEndDate;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @NonNull
    @Override
    public String toString() {
        return program.getTitle();
    }
}
