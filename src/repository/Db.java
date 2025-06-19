package repository;
import java.util.*;
import model.*;

public class Db {
    private static Db dataBase;
    private Map<Integer, Admin> admins = new HashMap<>();
    private Map<Integer, ReceptionList> receptionLists = new HashMap<>();
    private Map<Integer, Patient> patients = new HashMap<>();
    private Map<Integer, Doctor> doctors = new HashMap<>();
    private Map<Integer, Appoiment> appoiments = new HashMap<>();

    private Db() {
        loadAdmins();
        loadReceptionLists();
        loadPatients();
        loadDoctors();
        loadAppointments();
    }

    public static Db getInstance() {
        if (dataBase == null) {
            dataBase = new Db();
        }
        return dataBase;
    }

    


    private void loadAdmins() {
        List<String> lines = FileUtil.readFromFile("admins.txt");
        for (String line : lines) {
            Admin admin = Admin.fromString(line);
            admins.put(admin.getId(), admin);
        }
    }

    private void loadReceptionLists() {
        List<String> lines = FileUtil.readFromFile("receptions.txt");
        for (String line : lines) {
            ReceptionList reception = ReceptionList.fromString(line);
            receptionLists.put(reception.getId(), reception);
        }
    }

    private void loadPatients() {
        List<String> lines = FileUtil.readFromFile("patients.txt");
        for (String line : lines) {
            Patient patient = Patient.fromString(line);
            patients.put(patient.getId(), patient);
        }
    }

    private void loadDoctors() {
        List<String> lines = FileUtil.readFromFile("doctors.txt");
        for (String line : lines) {
            Doctor doctor = Doctor.fromString(line);
            doctors.put(doctor.getId(), doctor);
        }
    }

    private void loadAppointments() {
        List<String> lines = FileUtil.readFromFile("appointments.txt");
        for (String line : lines) {
            Appoiment app = Appoiment.fromString(line);
            appoiments.put(app.getId(), app);
        }
    }


    public Map<Integer, Admin> getAdmin() {
        return admins;
    }

    public Map<Integer, ReceptionList> getReceptionLists() {
        return receptionLists;
    }

    public Map<Integer, Patient> getPatients() {
        return patients;
    }

    public Map<Integer, Doctor> getDocters() {
        return doctors;
    }

    public Map<Integer, Appoiment> getAppoinments() {
        return appoiments;
    }

    public void addAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
        FileUtil.saveToFile("admins.txt", admins.values());
    }

    public void addpatient(Patient patient) {
        patients.put(patient.getId(), patient);
        FileUtil.saveToFile("patients.txt", patients.values());
    }

    public void addRecptionList(ReceptionList receptionList) {
        receptionLists.put(receptionList.getId(), receptionList);
        FileUtil.saveToFile("receptions.txt", receptionLists.values());
    }

    public void removeRecptionList(int id) {
        if (receptionLists.containsKey(id)) {
            receptionLists.remove(id);
            FileUtil.saveToFile("receptions.txt", receptionLists.values());
        }
    }

    public void addDocter(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
        FileUtil.saveToFile("doctors.txt", doctors.values());
    }

    public void addAppoinment(Appoiment appoiment) {
        appoiments.put(appoiment.getId(), appoiment);
        FileUtil.saveToFile("appointments.txt", appoiments.values());
    }

    public Patient getPatient(int patientId) {
        return patients.get(patientId);
    }

    public Doctor getDocter(int doctorId) {
        return doctors.get(doctorId);
    }
   
}
