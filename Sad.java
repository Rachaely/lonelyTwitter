package ca.ualberta.cs.lonelytwitter.moods;

public class Sad extends CurrentMood {
    public void setMood(String Mood){
        Mood = "sad";
    }
    public String getMood(){
        return Mood;
    }
}