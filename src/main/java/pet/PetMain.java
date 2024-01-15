package pet;

import java.util.List;
import java.util.Scanner;
import pet.controller.CustomerController;
import pet.controller.MedicalRecordController;
import pet.model.Customer;
import pet.model.MedicalRecord;
import pet.view.ConsoleView;

public class PetMain {
    public static void main(String[] args) {
        MedicalRecordController medicalRecordController = new MedicalRecordController();
        CustomerController customerController = new CustomerController(medicalRecordController);
        ConsoleView consoleView = new ConsoleView();

        while (true) {
            System.out.println("=== 애완동물 진료 관리 시스템 ===");
            System.out.println("1. 신규 고객 정보 입력");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.print("원하는 기능을  선택하세요: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer customer = consoleView.getCustomerInfo();
                    String phoneNumber = customer.getPhoneNumber();
                    if (customerController.isPhoneNumberExist(phoneNumber)) {
                        consoleView.printMessage("이미 등록된 전화번호입니다.");
                        continue;
                    }
                    customerController.addCustomer(customer);
                    consoleView.printMessage("고객 정보가 추가되었습니다.");
                    break;
                case 2:
                    phoneNumber = consoleView.getPhoneNumber();
                    if (customerController.findCustomer(phoneNumber) == null) {
                        consoleView.printMessage("해당 전화번호를 가진 고객 정보가 없습니다.");
                        break;
                    }
                    Customer foundCustomer = customerController.findCustomer(phoneNumber);
                    MedicalRecord newRecord = consoleView.getMedicalRecordInfo();
                    newRecord.setPhoneNumber(phoneNumber);
                    medicalRecordController.addMedicalRecord(newRecord);
                    foundCustomer.addMedicalRecords(newRecord);
                    consoleView.printMessage("진료 기록이 저장되었습니다.");
                    break;
                case 3:
                    phoneNumber = consoleView.getPhoneNumber();
                    List<MedicalRecord> records = medicalRecordController.findMedicalRecords(phoneNumber);
                    if (records.isEmpty()) {
                        consoleView.printMessage("해당 전화번호를 가진 진료 기록이 없습니다.");
                        break;
                    }
                    customer = customerController.findCustomer(phoneNumber);
                    consoleView.printMedicalRecordInfo(customer);
                    break;
                case 4:
                    phoneNumber = consoleView.getPhoneNumber();
                    if (customerController.findCustomer(phoneNumber) == null) {
                        consoleView.printMessage("해당 전화번호를 가진 고객 정보가 없습니다.");
                        break;
                    }
                    medicalRecordController.removeMedicalRecord(phoneNumber);
                    consoleView.printMessage("진료 기록 정보가 삭제되었습니다.");
                    break;
                case 5:
                    consoleView.printMessage("프로그램을 종료합니다.");
                    return;
                default:
                    consoleView.printMessage("잘못된 선택입니다.");
                    break;
            }
        }
    }
}
