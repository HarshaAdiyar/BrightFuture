package com.protsaha.brightfuture.model;

import java.util.Date;

public class MaintenanceRecord {
    private Date date;
    private String description;

    // Getters & Setters
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
