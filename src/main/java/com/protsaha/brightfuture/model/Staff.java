package com.protsaha.brightfuture.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Staff")
@Data
public class Staff {
    @Id
    private String staffId;
    private PersonalDetails personalDetails;
    private AadharInfo aadharInfo;
    private Address address;
    private Staff_Employment employment;

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", personalDetails=" + personalDetails +
                ", aadharInfo=" + aadharInfo +
                ", address=" + address +
                ", employment=" + employment +
                '}';
    }
}
