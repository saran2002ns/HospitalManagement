package model;

public class TimeOfAvailability {
    private String chekIn;
    private String chekOut;
    private boolean IsAvailable;
    
    public TimeOfAvailability(String chekIn, String chekOut, boolean isAvailable) {
        this.chekIn = chekIn;
        this.chekOut = chekOut;
        IsAvailable = isAvailable;
    }
    public boolean isIsAvailable() {
        return IsAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        IsAvailable = isAvailable;
    }
    public String getChekIn() {
        return chekIn;
    }
    public void setChekIn(String chekIn) {
        this.chekIn = chekIn;
    }
    public String getChekOut() {
        return chekOut;
    }
    public void setChekOut(String chekOut) {
        this.chekOut = chekOut;
    }
    @Override
    public String toString() {
        return "TimeOfAvailability [chekIn=" + chekIn + ", chekOut=" + chekOut + ", IsAvailable=" + IsAvailable + "]";
    } 
}
