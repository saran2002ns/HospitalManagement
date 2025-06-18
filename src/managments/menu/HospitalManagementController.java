package managments.menu;

public class HospitalManagementController {
    private   HospitalManagementView view;
    private HospitalManagementService service;
    public HospitalManagementController(HospitalManagementView hospitalManagementView) {
       view= hospitalManagementView;
       service=new HospitalManagementService(this);

    }
    public void chechPasswordWithId(int id, String password) {
        service.chechPasswordWithId(id,password);
    }
    public void chechPasswordWithNumber(String number, String password) {
       service.chechPasswordWithNumber(number,password);
    }
    public void adminChechPasswordWithNumber(String number, String password) {
           service.receptionListChechPasswordWithNumber(number,password);
    }

    public void adminChechPasswordWithId(int id, String password) {
      service.receptionListChechPasswordWithId(id,password);
    }
}
   
