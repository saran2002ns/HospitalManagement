package model;

import java.util.ArrayList;
import java.util.List;

public class DateOfPresent {
    private boolean isAvailable;
    private String date;
    List<TimeOfAvailability> times = new ArrayList<>(List.of(new TimeOfAvailability("9","11",true),
                                             new TimeOfAvailability("1","3",true),
                                             new TimeOfAvailability("6","8",true)));
    public DateOfPresent( String date,boolean isAvailable) {
        this.isAvailable = isAvailable;
        this.date = date;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public List<TimeOfAvailability> getTimes() {
        return times;
    }
    public void setTimes(List<TimeOfAvailability> times) {
        this.times = times;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "DateOfPresent [isAvailable=" + isAvailable + ", date=" + date + ", times=" + times + "]";
    }
}
