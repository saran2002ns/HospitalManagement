package management.reception;

import java.util.Map;

import model.Patient;
import repository.Db;

public class ReceptionListController {
    private ReceptionListView view;
    Db dataBase = Db.getInstance();
    public ReceptionListController(ReceptionListView receptionListView) {
       view=receptionListView;
    }
    public void searchPatient(String name) {
        Map<Integer,Patient> patients = dataBase.getPatients();
        for ( Map.Entry<Integer,Patient>  patient :patients.entrySet()) {
            if (patient.getValue().getName().equals(name)) {
                System.out.println(patient);
            }
        }
    }
    public void addPatient(String name, byte age, String number, String date, String time) {
       dataBase.addpatient(new Patient(name, number, date, time, age));
    }
    
}
