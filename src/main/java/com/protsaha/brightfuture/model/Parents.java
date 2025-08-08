package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Parents {
    private Father father;
    private Mother mother;
    private Guardian guardian;

    @Data
    public static class Father {
        private String name;
        private String aadharNo;
        private String occupation;
        private Integer annualIncome;
    }

    @Data
    public static class Mother {
        private String name;
        private String aadharNo;
        private String occupation;
    }

    @Data
    public static class Guardian {
        private String name;
        private String contactNo;
    }
}
