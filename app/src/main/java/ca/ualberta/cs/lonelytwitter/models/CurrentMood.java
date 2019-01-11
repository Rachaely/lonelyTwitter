package ca.ualberta.cs.lonelytwitter.models;

import java.util.Date;

public abstract class CurrentMood {
    private Date Date;
    protected String Mood;

    public Date getDate() {
        return Date;
    }
    public void setDate(Date Date) {
        this.Date = Date;
    }
}
