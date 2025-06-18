
package managments.admin;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Appoiment;
import model.DateOfPresent;
import model.Docter;
import model.Patient;
import model.ReceptionList;
import model.TimeOfAvailability;
import repository.Db;

public class AdminService {
    private AdminView view;
    Db dataBase = Db.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    public AdminService(AdminView adminView) {
        view=adminView;
    }
    public void addToReceptionList(String name, String number, String password) {
        dataBase.addRecptionList(new ReceptionList(name, number, password));
    }
    public void removeReceptionList(int id){
        dataBase.removeRecptionList(id);
    }
    public void addDocter(String name, byte age, String number) {
       dataBase.addDocter(new Docter(name, age, number));
    }
    public void setAppoinments() {
       
        printAnappoinmentPatient();
        System.out.println("Enter patient id : ");
        int patienId=scanner.nextInt();
        scanner.nextLine();
        printAvailableDocterForPatient(patienId);  
        System.out.println("Enter Docter id : ");
        int docterId=scanner.nextInt();
        scanner.nextLine();
        setAppoinment(docterId,patienId);
              
    }
    
    private void setAppoinment(int docterId, int patienId) {
        Patient patient = dataBase.getPatient(patienId);
        Docter docter = dataBase.getDocter(docterId);
        outer:
         for(DateOfPresent date : docter.getDates()){
                if(date.getDate().equals(patient.getDate())){
                    for(TimeOfAvailability time : date.getTimes()){
                        int chekin = Integer.parseInt(time.getChekIn());
                        int checkout= Integer.parseInt(time.getChekOut());
                        int patientTime =Integer.parseInt(patient.getTime());
                        if (chekin<= patientTime && patientTime<checkout) {
                            time.setIsAvailable(false);
                           setAppoinment(patient.getTime(),patient.getDate(),docterId, patienId);
                           break outer;
                        }
                    }
                }
             }
        
       
    }
    private void printAvailableDocterForPatient(int patienId) {
        Patient patient=dataBase.getPatient(patienId);
        Map<Integer,Docter> docters=dataBase.getDocters();
        for(Map.Entry<Integer,Docter> docter : docters.entrySet()){
             for(DateOfPresent date : docter.getValue().getDates()){
                if(date.getDate().equals(patient.getDate())){
                    for(TimeOfAvailability time : date.getTimes()){
                        int chekin = Integer.parseInt(time.getChekIn());
                        int checkout= Integer.parseInt(time.getChekOut());
                        int patientTime =Integer.parseInt(patient.getTime());
                        if (chekin<= patientTime && patientTime<checkout) {
                            System.out.println(docter.getKey()+" "+docter.getValue());
                        }
                    }
                }
             }
        }

    }
    private void printAnappoinmentPatient() {
         Map<Integer,Patient> patients = dataBase.getPatients();
        for ( Map.Entry<Integer,Patient> patientEntry : patients.entrySet()) {
            if(!patientEntry.getValue().isAllocated());
            System.out.println(patientEntry.getKey()+" : "+patientEntry.getValue());
        }
    }

    private void setAppoinment(String time, String date, Integer patientId, Integer docterId) {
       dataBase.addAppoinment(new Appoiment(time, date, patientId, docterId) );
    }
        
}
