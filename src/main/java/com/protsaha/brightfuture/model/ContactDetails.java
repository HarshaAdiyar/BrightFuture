package com.protsaha.brightfuture.model;

import lombok.Data;


@Data
public class ContactDetails {
    private String email;
    private String primaryContactPerson;
    private String primaryPhone;
    private String secondaryContactPerson;
    private String secondaryPhone;
}
