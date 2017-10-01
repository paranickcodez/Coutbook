package p.n.countbook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 */

//http://crunchify.com/how-to-serialize-deserialize-list-of-objects-in-java-java-serialization-example/
public class Counter implements Serializable{
    private String name;
    private int initial_value;
    private int current_value;
    private String comment;
    private Date date;

    /**
     *
     * @param name
     * @param initial_value
     */

    public Counter (String name, int initial_value){
        this.name = name;
        this.initial_value = initial_value;
        /**this.*/current_value = initial_value;
        this.comment = "";
        date = new Date();
    }

    /**
     *
     * @param name
     * @param initial_value
     * @param comment
     */

    public Counter (String name, int initial_value, String comment){
        this.name = name;
        this.initial_value = initial_value;
        this.current_value = initial_value;
        this.comment = comment;
        date = new Date();
    }

    /**
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */

    public int getInitial_value() {
        return initial_value;
    }

    /**
     *
     * @param initial_value
     */

    public void setInitial_value(int initial_value) {
        this.initial_value = initial_value;
        this.update();
    }

    /**
     *
     */

    public void upCount () {
        this.current_value += 1;
        this.update();
    }

    /**
     *
     */

    public void downCount () {
        if (this.current_value > 0) {
            this.current_value -= 1;
            this.update();
        } else {this.current_value = 0;}
    }

    /**
     *
     * @param current_value
     */

    public void setCurrent_value(int current_value) {
        this.current_value = current_value;
        this.update();
    }

    /**
     *
     */

    public void resetCurrent_value() {
        if (this.current_value != this.initial_value) {
            this.current_value = this.initial_value;
            this.update();
        }
    }

    /**
     *
     * @return
     */

    public int getCurrent_value() {
        return current_value;
    }

    /**
     *
     * @param comment
     */

    public void setComment(String comment) {
        this.comment = comment;
        this.update();
    }

    /**
     *
     * @return
     */

    public String getComment() {
        return comment;
    }

    /**
     *
     * @return
     */

    public String getDate() {
        //https://stackoverflow.com/questions/18480633/java-util-date-format-conversion-yyyy-mm-dd-to-mm-dd-yyyy
        return new SimpleDateFormat("yyyy-MM-dd").format(this.date);
    }

    /**
     *
     */

    private void update() { this.date = new Date();}

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return " Name: " + name + "\n Count: " + current_value /*+ ", Comment:" + comment + ", Date:" + date + "]"*/;
    }
}
