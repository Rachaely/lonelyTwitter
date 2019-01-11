package ca.ualberta.cs.lonelytwitter.moods;


public class Happy extends CurrentMood {
    public void setMood(String Mood){
        Mood = "happy";
    }
    public String getMood(){
        return Mood;
    }
}
