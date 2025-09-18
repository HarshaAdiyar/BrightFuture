package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.service.impl.TransportProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport")
public class TransportProfileController {

    private final TransportProfileService service;

    public TransportProfileController(TransportProfileService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TransportProfile> createProfile(@RequestBody TransportProfile profile) {
        return ResponseEntity.ok(service.createProfile(profile));
    }

    // READ ALL
    @GetMapping
    public List<TransportProfile> getAllProfiles() {
        return service.getAllProfiles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<TransportProfile> getProfileById(@PathVariable String id) {
        return service.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TransportProfile> updateProfile(
            @PathVariable String id,
            @RequestBody TransportProfile updatedProfile) {
        return ResponseEntity.ok(service.updateProfile(id, updatedProfile));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable String id) {
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
