package meme2lz.wumf;


import java.util.Calendar;
import java.util.Date;

public class AlarmModel {
    private long id;
    private String time;
    private int active;

    public AlarmModel(long id, String time, int active){
        this.id=id;
        this.time=time;
        this.active=active;
    }

    public long getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public int isActive() {
        return active;
    }
}
