package com.protsaha.brightfuture.service.impl;

import com.protsaha.brightfuture.model.Staff;
import com.protsaha.brightfuture.repository.StaffRepository;
import com.protsaha.brightfuture.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(String id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff addStaff(Staff staff) {
        System.out.println("StaffServiceImpl :: " + staff);
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(String id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Optional<Staff> updateStaff(String id, Staff staff) {
        return staffRepository.findById(id).map(existingStaff -> {
            // ✅ Ensure ID is set properly
            staff.setStaffId(id);
            return staffRepository.save(staff);
        });
    }
}
