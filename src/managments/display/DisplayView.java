package managments.display;

import java.util.Map;
import java.util.Scanner;

import managments.base.Base;
import model.Appoiment;
import model.DateOfPresent;
import model.Docter;
import model.TimeOfAvailability;
import repository.Db;



public class DisplayView extends Base{
    private final Scanner scanner = new Scanner(System.in);
    Db dataBase = Db.getInstance();
    public void displaySheduling() {
        System.out.println("---- ADMIN -----");
       System.out.println();
       System.out.println("1.VIEW SHEWING FOR PATIENT");
       System.out.println("2.VIEW SHEWING FOR DOCTERS");
       System.out.println("3.VIEW SHEWING FOR A SPECFIC DOCTER");
       System.out.println("4.VIEW FREE FOR DOCTERS");
        System.out.println("5.Return");
        System.out.println("6.Exit");
        System.out.println("Enter your choice : ");

         try {
            int var1 = scanner.nextInt();
            switch (var1) {
               case 1:shedulingForPatient();break;
               case 2:shedulingForDocters();break;
               case 3:shedulingForDocter();break;
               case 4:freeDocters();break;
               case 5:return;
               case 6:
                  this.scanner.close();
                  this.exit();
            }
         } catch (Exception var2) {
            this.scanner.nextLine();
            System.out.println("Invalid input try again !");
         }
    }

    private void freeDocters() {
        Map<Integer,Docter> docters=dataBase.getDocters();
        for(Map.Entry<Integer,Docter> docter : docters.entrySet()){
            System.out.println(docter);
             for(DateOfPresent date : docter.getValue().getDates()){
                if (date.isAvailable()) {
                    System.out.println(date.getDate());
                    for(TimeOfAvailability time : date.getTimes()){
                       if (time.isIsAvailable()) {
                        System.out.println(time);
                       }
                    }
                    
                }
             }
        }

    }

    private void shedulingForDocter() {
        System.out.println("Enter id : ");
        int id = scanner.nextInt();
       Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
       for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
           if (id==appoimentEntry.getValue().getDocterId()) 
            System.out.println(appoimentEntry.getValue());
        }
    }

    private void shedulingForDocters() {
         Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
       for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
            System.out.println(appoimentEntry.getValue());
        }
    }

    private void shedulingForPatient() {
        System.out.println("Enter id : ");
        int id = scanner.nextInt();
       Map<Integer,Appoiment> appoiments = dataBase.getAppoinments();
       for (Map.Entry<Integer,Appoiment> appoimentEntry : appoiments.entrySet()) {
           if (id==appoimentEntry.getValue().getPatientId()) 
            System.out.println(appoimentEntry.getValue());
        }
    }

    public void init() {
      displaySheduling();
    }
    
}
