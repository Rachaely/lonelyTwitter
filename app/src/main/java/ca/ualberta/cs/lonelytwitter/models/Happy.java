package ca.ualberta.cs.lonelytwitter.models;


public class Happy extends CurrentMood {
    public void setMood(String Mood){
        Mood = "happy";
    }
    public String getMood(){
        return Mood;
    }
}
