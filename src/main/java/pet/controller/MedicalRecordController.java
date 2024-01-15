package pet.controller;

import java.util.ArrayList;
import java.util.List;
import pet.model.MedicalRecord;

public class MedicalRecordController {
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    // 진료 기록을 등록하는 메소드
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // 진료 기록을 삭제하는 메소드
    public void removeMedicalRecord(String phoneNumber) {
        for (int i=0; i< medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getPhoneNumber().equals(phoneNumber)) {
                medicalRecords.remove(i);
                break;
            }
        }
    }

    // 전화번호에 해당하는 모든 진료기록을 검색하여 새로운 List<MedicalRecord>를 만들어주는 메소드
    public List<MedicalRecord> findMedicalRecords(String phoneNumber) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPhoneNumber().equals(phoneNumber)) {
                result.add(medicalRecord);
            }
        }
        return result;
    }
}
