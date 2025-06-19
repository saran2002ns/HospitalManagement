package model;

public class Patient {
    static Integer count=0;
    Integer id;
    String name;
    String number;
    String date;
    String time;
    byte age;
    boolean isAllocated;
   
    public Patient(String name, String number, String date, String time, byte age) {
        id=++count;
        this.name = name;
        this.number = number;
        this.date = date;
        this.time = time;
        this.age = age;
    }
    public static Integer getCount() {
        return count;
    }
    public static void setCount(Integer count) {
        Patient.count = count;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public byte getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public boolean isAllocated() {
        return isAllocated;
    }
    public void setAllocated(boolean isAllocated) {
        this.isAllocated = isAllocated;
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
    @Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + ", number=" + number + ", date=" + date + ", time=" + time
                + ", age=" + age + ", isAllocated=" + isAllocated + "]";
    }
     public static Patient fromString(String line) {
        String[] parts = line.split("\\|");
        return new Patient(parts[1], parts[2], parts[3], parts[4], Byte.parseByte(parts[5]));
        
    }
}
