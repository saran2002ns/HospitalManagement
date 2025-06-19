package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {
    static Integer count=0;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    Integer id ;
    String name ;
    byte age;
    String number;
    Map<String,List<String>> avalabilSlot;
   
  
    public Map<String, List<String>> getAvalabilSlot() {
        return avalabilSlot;
    }
    public void setAvalabilSlot(Map<String, List<String>> avalabilSlot) {
        this.avalabilSlot = avalabilSlot;
    }
    public Doctor(String name, byte age, String number) {
        this.id=++count;
        this.name = name;
        this.age = age;
        this.number = number;
        setDate();
        
    }
    private void setDate() {
        avalabilSlot= new HashMap<>();
        for (int i = 1; i <=3; i++) {
            String date = "0"+i+"-02-2024";
            avalabilSlot.put(date, new ArrayList<>(List.of("11","13","16","19")));
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Docter [id=" + id + ", name=" + name + ", age=" + age + ", number=" + number + ", avalabilSlot="
                + avalabilSlot + "]";
    }
     public static Doctor fromString(String line) {
        String[] parts = line.split("\\|");
       return new Doctor(parts[1], Byte.parseByte(parts[2]), parts[3]);
       
    }

}
