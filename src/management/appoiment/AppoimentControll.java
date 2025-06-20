package management.appoiment;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Appoiment;
import model.Doctor;
import repository.Db;

public class AppoimentControll {
        Db dataBase = Db.getInstance();
         private final Scanner scanner = new Scanner(System.in);
    public AppoimentControll(AppoimentView appoimentView) {}

    public void sheduledForPatient() {
        String name =getName();
        Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
        for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
            if (dataBase.getPatient(appoimentEntry.getValue().getPatientId()).getName().equals(name)) {
                 System.out.println(appoimentEntry.getValue());
            }
           
        }
    }

    public void sheduledForDocters() {
        Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
        for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
            System.out.println(appoimentEntry.getValue());
        }
    }

    public void sheduledForDocter() {
        
       Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
       Map<Integer,Doctor> docters = dataBase.getDocters();
       int id=0;
       while (true) {
                  System.out.println("Enter id : ");
                  id = scanner.nextInt();
                  if (!docters.containsKey(id)) {
                    System.out.println(" INVALID ID ! ");
                  }else break;
       }
        for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
           if (id==appoimentEntry.getValue().getDocterId()) 
            System.out.println(appoimentEntry.getValue());
        }
       
    }

    public void freeDocters() {
        Map<Integer,Doctor> docters=dataBase.getDocters();
        for(Map.Entry<Integer,Doctor> docter : docters.entrySet()){
            System.out.println(docter+" -> ");
            Map<String,List<String>> slots =docter.getValue().getAvalabilSlot();
            if(slots.isEmpty())
            System.out.print(" no dates !");
            for(Map.Entry<String,List<String>> slot : slots.entrySet() ){
                System.out.println("date : "+slot.getKey()+" time : ");
                for (String time : slot.getValue()) {
                    System.out.print(time+"  ");
                }
            }
        }
    }

    private String getName() {
       System.out.println("Enter Your name ");
       String name= scanner.nextLine();
       return name.trim();
    }
    
}
