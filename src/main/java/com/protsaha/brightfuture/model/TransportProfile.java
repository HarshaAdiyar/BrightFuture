package com.protsaha.brightfuture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "transport_profiles")
public class TransportProfile {

    @Id
    private String transportId;

    private VehicleDetails vehicleDetails;
    private DriverDetails driverDetails;
    private AttendantDetails attendantDetails;
    private List<MaintenanceRecord> maintenanceRecords;

    // Getters & Setters
    public String getTransportId() { return transportId; }
    public void setTransportId(String transportId) { this.transportId = transportId; }

    public VehicleDetails getVehicleDetails() { return vehicleDetails; }
    public void setVehicleDetails(VehicleDetails vehicleDetails) { this.vehicleDetails = vehicleDetails; }

    public DriverDetails getDriverDetails() { return driverDetails; }
    public void setDriverDetails(DriverDetails driverDetails) { this.driverDetails = driverDetails; }

    public AttendantDetails getAttendantDetails() { return attendantDetails; }
    public void setAttendantDetails(AttendantDetails attendantDetails) { this.attendantDetails = attendantDetails; }

    public List<MaintenanceRecord> getMaintenanceRecords() { return maintenanceRecords; }
    public void setMaintenanceRecords(List<MaintenanceRecord> maintenanceRecords) { this.maintenanceRecords = maintenanceRecords; }
}
