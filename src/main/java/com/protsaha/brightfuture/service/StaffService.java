package com.protsaha.brightfuture.service;

import com.protsaha.brightfuture.model.Staff;
import com.protsaha.brightfuture.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff getStaffById(String staffId) {
        return staffRepository.findById(staffId).orElse(null);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff updateStaff(String staffId, Staff updatedStaff) {
        return staffRepository.findById(staffId)
                .map(existing -> {
                    existing.setPersonalDetails(updatedStaff.getPersonalDetails());
                    existing.setAadharInfo(updatedStaff.getAadharInfo());
                    existing.setAddress(updatedStaff.getAddress());
                    existing.setEmployment(updatedStaff.getEmployment());
                    return staffRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteStaff(String staffId) {
        staffRepository.deleteById(staffId);
    }
}
