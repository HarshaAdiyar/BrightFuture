package com.protsaha.brightfuture.model;

import lombok.Data;

// The @Data annotation from Lombok automatically generates getters, setters,
// toString(), equals(), and hashCode() methods for all fields.
@Data
public class Employment {
    private String dateOfJoining;
    private String designation;
    private String department;
}
