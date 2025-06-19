package model;

public class Admin {
    static Integer count=0;
    Integer id;
    String name;
    String number;
    String password;
    String avalability;
    public Admin( String name, String number, String password, String avalability) {
        this.id = ++count;
        this.name = name;
        this.number = number;
        this.password = password;
        this.avalability = avalability;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAvalability() {
        return avalability;
    }
    public void setAvalability(String avalability) {
        this.avalability = avalability;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", number=" + number + ", password=" + password + ", avalability="
                + avalability + "]";
    }
    public static Admin fromString(String line) {
        String[] parts = line.split("\\|");
        return new Admin(parts[1], parts[2], parts[3], parts[4]);
       
    }

}
