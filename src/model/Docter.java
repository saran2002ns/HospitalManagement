package model;

import java.util.ArrayList;
import java.util.List;

public class Docter {
    static Integer count;
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
    List<DateOfPresent> dates =new  ArrayList<>(List.of(new DateOfPresent("01-02-2025",true),
                                                        new DateOfPresent("02-02-2025",true),
                                                        new DateOfPresent("03-02-2025",true)));
  
    public Docter(String name, byte age, String number) {
        this.id=++count;
        this.name = name;
        this.age = age;
        this.number = number;
    }
    public List<DateOfPresent> getDates() {
        return dates;
    }
    public void setDates(List<DateOfPresent> dates) {
        this.dates = dates;
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
        return "Docter [id=" + id + ", name=" + name + ", age=" + age + ", number=" + number + ", dates=" + dates + "]";
    }
}
