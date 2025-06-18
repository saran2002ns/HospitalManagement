package managments.menu;

import java.util.List;
import java.util.Map;

import managments.admin.AdminView;
import managments.receptionlist.ReceptionListView;
import model.Admin;
import model.ReceptionList;
import repository.Db;

public class HospitalManagementService {
     private HospitalManagementController controller;
     private Db dataBase= Db.getInstance();
    public HospitalManagementService(HospitalManagementController hospitalManagementController) {
        controller=hospitalManagementController;
    }
    public void chechPasswordWithNumber(String number, String password) {
        
        
         Map<Integer,Admin> admins = dataBase.getAdmin();

        for (Map.Entry<Integer,Admin> adminEntry : admins.entrySet()) {
             Admin admin = adminEntry.getValue();
            if (admin.getNumber().equals(number) && admin.getPassword().equals(password)) {
                new AdminView().init();
            }
        }
        return;
    }
    public void chechPasswordWithId(int id, String password) {
        Map<Integer,Admin> admins = dataBase.getAdmin();
            if(admins.containsKey(id)){
            Admin admin = admins.get(id);
            if (admin.getId()==id && admin.getPassword().equals(password)) {
                new AdminView().init();
            }
            }else{
                System.out.println("admin not found ");
            }
        
        return;
    }
    public void receptionListChechPasswordWithNumber(String number, String password) {
         Map<Integer,ReceptionList> receptionLists = dataBase.getReceptionList();
           
         for (Map.Entry<Integer,ReceptionList> receptionListEntry : receptionLists.entrySet()) {
             ReceptionList receptionList = receptionListEntry.getValue();
            if (receptionList.getNumber().equals(number) && receptionList.getPassword().equals(password)) {
                new ReceptionListView().init();
            }
        }
        return;
    }
    public void receptionListChechPasswordWithId(int id, String password) {
         Map<Integer,ReceptionList> receptionLists = dataBase.getReceptionList();
         if(receptionLists.containsKey(id)){
            ReceptionList receptionList = receptionLists.get(id);
            if (receptionList.getId()==id && receptionList.getPassword().equals(password)) {
                new ReceptionListView().init();
            }
            }else{
                System.out.println("admin not found ");
            }
        return;
    }
   
    
}
