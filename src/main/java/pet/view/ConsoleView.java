package pet.view;

import java.util.List;
import java.util.Scanner;
import pet.model.Customer;
import pet.model.MedicalRecord;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    // 전화번호를 입력받는 화면
    public String getPhoneNumber() {
        System.out.print("전화번호를 입력하세요: ");
        return scanner.nextLine();
    }

    // 신규 고객 정보 입력 화면
    public Customer getCustomerInfo() {
        System.out.println("<신규 고객 정보를 입력하세요>");
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("소유주 이름: ");
        String ownerName = scanner.nextLine();
        System.out.print("동물 이름: ");
        String petName = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("종: ");
        String species = scanner.nextLine();
        System.out.print("출생년도(yyyy): ");
        Integer birthYear = scanner.nextInt(); scanner.nextLine();
        return new Customer(phoneNumber, ownerName, petName, address, species, birthYear);
    }

    // 진료 기록을 입력받는 화면
    public MedicalRecord getMedicalRecordInfo() {
        System.out.print("진료일을 입력하세요: ");
        String date = scanner.nextLine();
        System.out.print("진료내용을 입력하세요: ");
        String content = scanner.nextLine();
        return new MedicalRecord(null, date, content);
    }

    // 진료 기록을 조회하여 출력
    public void printMedicalRecordInfo(Customer customer) {
        List<MedicalRecord> medicalRecords = customer.getMedicalRecords();
        System.out.println("[" + customer.getPetName() + "]의 진료 기록");

        for (MedicalRecord medicalRecord : medicalRecords) {
            System.out.println("- 진료일: " + medicalRecord.getDate());
            System.out.println("  진료내용: " + medicalRecord.getContent());
            System.out.println("  소유주 이름: " + customer.getOwnerName());
            System.out.println("  동물 이름: " + customer.getPetName());
            System.out.println("  주소: " + customer.getAddress());
            System.out.println("  종류: " + customer.getSpecies());
            System.out.println("  출생년도: " + customer.getBirthYear());
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
