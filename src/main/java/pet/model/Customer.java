package pet.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String phoneNumber; // 전화번호
    private String ownerName; // 보호자 이름
    private String petName; // 애완동물 이름
    private String address; // 주소
    private String species; // 종
    private Integer birthYear; // 생년
    private List<MedicalRecord> medicalRecords; // 진료 기록 객체를 저장하는 리스트

    public Customer(String phoneNumber, String ownerName, String petName, String address, String species, Integer birthYear) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.petName = petName;
        this.address = address;
        this.species = species;
        this.birthYear = birthYear;
        this.medicalRecords = new ArrayList<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void addMedicalRecords(MedicalRecord medicalRecord) { // 진료 기록 객체 추가
        this.medicalRecords.add(medicalRecord);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", petName='" + petName + '\'' +
                ", address='" + address + '\'' +
                ", species='" + species + '\'' +
                ", birthYear=" + birthYear +
                ", medicalRecords=" + medicalRecords +
                '}';
    }
}
