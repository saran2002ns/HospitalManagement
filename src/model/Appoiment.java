package model;

public class Appoiment {
   
    static Integer count; 
    Integer id;
    String date;
    String time;
    Integer patientId;
    Integer docterId;
     public Appoiment(String date, String time, Integer patientId, Integer docterId) {
        id=++count;
        this.date = date;
        this.time = time;
        this.patientId = patientId;
        this.docterId = docterId;
    }
    public static Integer getCount() {
        return count;
    }
    public static void setCount(Integer count) {
        Appoiment.count = count;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Integer getPatientId() {
        return patientId;
    }
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
    public Integer getDocterId() {
        return docterId;
    }
    public void setDocterId(Integer docterId) {
        this.docterId = docterId;
    }
    @Override
    public String toString() {
        return "Appoiment [id=" + id + ", date=" + date + ", time=" + time + ", patientId=" + patientId + ", docterId="
                + docterId + "]";
    }
   
}
