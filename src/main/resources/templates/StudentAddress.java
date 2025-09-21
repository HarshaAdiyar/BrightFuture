package com.protsaha.brightfuture.brightfuture;

public class StudentAddress {
    private Address parentsAddress;
    private Address guardianAddress;

    // Getters and Setters
    public Address getParentsAddress() { return parentsAddress; }
    public void setParentsAddress(Address parentsAddress) { this.parentsAddress = parentsAddress; }

    public Address getGuardianAddress() { return guardianAddress; }
    public void setGuardianAddress(Address guardianAddress) { this.guardianAddress = guardianAddress; }
}
