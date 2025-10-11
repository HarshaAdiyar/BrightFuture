package com.protsaha.brightfuture.service;

import com.protsaha.brightfuture.model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(String id);
    Staff addStaff(Staff staff);
    void deleteStaff(String id);


    Optional<Staff> updateStaff(String id, Staff staff);
}
