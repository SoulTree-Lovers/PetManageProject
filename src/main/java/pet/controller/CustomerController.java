package pet.controller;

import java.util.ArrayList;
import java.util.List;
import pet.model.Customer;

public class CustomerController {
    private List<Customer> customers;
    private MedicalRecordController medicalRecordController; // 진료 기록을 관리하는 컨트롤러

    public CustomerController(MedicalRecordController medicalRecordController) {
        this.customers = new ArrayList<>();
        this.medicalRecordController = medicalRecordController;
    }

    // 고객 정보를 등록하는 메소드
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    // 고객 정보를 삭제하는 메소드 (+ 반드시 해당 고객의 진료 기록도 삭제해야 함.)
    public void removeCustomer(String phoneNumber) {
        for (int i=0; i< customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().equals(phoneNumber)) {
                medicalRecordController.removeMedicalRecord(phoneNumber); // 해당 고객의 진료 기록도 삭제.
                customers.remove(i);
                break;
            }
        }
    }

    // 고객이 등록되어 있는지 확인하는 메소드
    public Customer findCustomer(String phoneNumber) {
        for (Customer customer : this.customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }

    // 기존의 전화번호로 등록된 고객이 있는지를 확인하는 메소드 (중복 확인)
    public boolean isPhoneNumberExist(String phoneNumber) {
        for (Customer customer : this.customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
