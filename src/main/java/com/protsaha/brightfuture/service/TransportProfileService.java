package com.protsaha.brightfuture.service.impl;

import com.protsaha.brightfuture.model.TransportProfile;
import com.protsaha.brightfuture.model.VehicleDetails;
import com.protsaha.brightfuture.model.DriverDetails;
import com.protsaha.brightfuture.repository.TransportProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportProfileService {

    @Autowired
    private TransportProfileRepository repository;

    // CREATE
    public TransportProfile createProfile(TransportProfile profile) {
        return repository.save(profile);
    }

    // READ ALL
    public List<TransportProfile> getAllProfiles() {
        return repository.findAll();
    }

    // READ ONE
    public Optional<TransportProfile> getProfileById(String id) {
        return repository.findById(id);
    }

    // UPDATE
    public TransportProfile updateProfile(String id, TransportProfile updatedProfile) {
        return repository.findById(id).map(profile -> {
            // Get the nested objects from the updatedProfile
            VehicleDetails updatedVehicleDetails = updatedProfile.getVehicleDetails();
            DriverDetails updatedDriverDetails = updatedProfile.getDriverDetails();

            // Update the nested objects in the original profile
            VehicleDetails existingVehicleDetails = profile.getVehicleDetails();
            DriverDetails existingDriverDetails = profile.getDriverDetails();

            if (updatedVehicleDetails != null) {
                existingVehicleDetails.setVehicleNumber(updatedVehicleDetails.getVehicleNumber());
                existingVehicleDetails.setRoute(updatedVehicleDetails.getRoute());
            }

            if (updatedDriverDetails != null) {
                existingDriverDetails.setName(updatedDriverDetails.getName());
            }

            // Save the updated profile
            return repository.save(profile);
        }).orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    // DELETE
    public void deleteProfile(String id) {
        repository.deleteById(id);
    }
}