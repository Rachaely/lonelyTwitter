/**
 * @ClassName LonelyTwitterActivity
 *
 * @Version 1.2
 *
 * @Date 1/22/2019
 *
 * @Copyright(c) Ruoqi Yang, CMPUT301, University of Alberta

 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Define a tweet
 *
 * @Author ry
 * @Version 1.0
 * @see LonelyTwitterActivity
 * @since 1.0
 */

public class Tweet {
    String message;
    Date date;

    /**
     * Construct the Tweets objects
     *
     * @param messgae,String type
     */

    Tweet(String messgae){
        this.date = new Date();
        this.message = messgae;
    }

    /**
     * Gets the date of the tweet
     *
     * @return date, Date type
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date to provided date object
     *
     * @param date, Date type
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns messages of the tweet.
     *
     * @return message,String type
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns a string content of this tweet
     *
     * @return message,String type
     */
    @Override
    public String toString(){
        return message;
    }


}
