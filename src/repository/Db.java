package repository;


import java.util.HashMap;

import java.util.Map;

import model.Admin;
import model.Appoiment;

import model.Docter;
import model.Patient;
import model.ReceptionList;

public class Db {
    private static Db dataBase;
    private Db(){};
    public static Db getInstance(){
        if(dataBase==null){
            dataBase= new Db();
            return dataBase;
        }
        return dataBase;
    }
    Map<Integer,Admin> admins= new HashMap<>(Map.of(1,new Admin("Saran","7094250807","password","afternoon"),
                                               2, new Admin("gokul","8094250748","gokul123","morning")));
    Map<Integer,ReceptionList> receptionLists= new HashMap<>(Map.of(1,new ReceptionList("Saran","7094250807","password"),
                                                    2,new ReceptionList("gokul","8094250748","gokul123")));
    Map<Integer,Patient> patients = new HashMap<>();   
    Map<Integer,Docter> docters = new HashMap<>();    
    Map<Integer,Appoiment>  appoiments = new HashMap<>();       

    public  Map<Integer,Admin> getAdmin(){
        return new HashMap<>(admins);
    }   
   public  Map<Integer,Patient>  getPatient(){
        return new HashMap<>(patients);
    }    
    public void addpatient(Patient patient){
        patients.put(patient.getId(),patient);
    }
    public Map<Integer,ReceptionList> getReceptionList() {
      return new HashMap<>(receptionLists);
    }
    public void addRecptionList(ReceptionList receptionList) {
       receptionLists.put(receptionList.getId(), receptionList);
    }
    public void removeRecptionList(int id) {
       if(receptionLists.containsKey(id)){
         receptionLists.remove(id);
       }
    }
    public void addDocter(Docter docter) {
       docters.put(docter.getId(), docter);
    }
    public Map<Integer, Patient> getPatients() {
       return patients;
    }
    public Map<Integer, Docter> getDocters() {
       return docters;
    }
    public void addAppoinment(Appoiment appoiment) {
        appoiments.put(appoiment.getId(), appoiment);
    }
    public Patient getPatient(int patienId) {
       return patients.get(patienId);
    }
    public Docter getDocter(int docterId) {
        return docters.get(docterId);
    }
   
    public Map<Integer, Appoiment> getAppoinments() {
       return appoiments;
    }                                
}
