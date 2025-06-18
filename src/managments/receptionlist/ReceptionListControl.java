package managments.receptionlist;

import java.util.Map;

import model.Patient;
import repository.Db;

public class ReceptionListControl {
   
    private  ReceptionListView view;
    public ReceptionListControl(ReceptionListView receptionListView) {
        view=receptionListView;
    }
    Db db = Db.getInstance();
    public void addPatient(String name, byte age, String number, String date, String time) {
        db.addpatient(new Patient(name, number, age,date,time));
    }
    public void searchPatient(String name) {
       Map<Integer,Patient> patients = db.getPatient();
       for(Map.Entry<Integer,Patient> patientEntry : patients.entrySet()){
        Patient patient = patientEntry.getValue();
          if (name.equals(patient.getName())) {
            System.out.println(patient);
          }
       }
    }
    
}
