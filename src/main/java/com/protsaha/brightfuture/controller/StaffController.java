package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Staff;
import com.protsaha.brightfuture.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
@Tag(name = "Staff Management", description = "Endpoints for managing staff")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class StaffController {

    @Autowired
    private StaffService staffService;

    // ✅ Get all staff
    @GetMapping
    @Operation(summary = "Get All Staff", description = "Retrieve a list of all staff.")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    // ✅ Get staff by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get Staff by ID", description = "Retrieve a staff member by their ID.")
    public ResponseEntity<Staff> getStaffById(@PathVariable String id) {
        Optional<Staff> staff = staffService.getStaffById(id);
        return staff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Add new staff
    @PostMapping
    @Operation(summary = "Add a New Staff", description = "Add a new staff member to the database.")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff createdStaff = staffService.addStaff(staff);
        return ResponseEntity.ok(createdStaff);
    }

    // ✅ Update staff by ID
    @PutMapping("/{id}")
    @Operation(summary = "Update Staff by ID", description = "Update an existing Staff's information")
    public ResponseEntity<Staff> updateStaff(@PathVariable String id, @RequestBody Staff staff) {
        Optional<Staff> updated = staffService.updateStaff(id, staff);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Delete staff by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Staff by ID", description = "Delete a staff member using their ID.")
    public ResponseEntity<Void> deleteStaff(@PathVariable String id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
