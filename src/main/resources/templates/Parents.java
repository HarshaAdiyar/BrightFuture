package com.protsaha.brightfuture.brightfuture;

public class Parents {

    private Father father;
    private Mother mother;
    private Guardian guardian;

    // Nested Classes
    public static class Father {
        private String name;
        private String aadharNo;
        private String occupation;
        private int annualIncome;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAadharNo() { return aadharNo; }
        public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }

        public String getOccupation() { return occupation; }
        public void setOccupation(String occupation) { this.occupation = occupation; }

        public int getAnnualIncome() { return annualIncome; }
        public void setAnnualIncome(int annualIncome) { this.annualIncome = annualIncome; }
    }

    public static class Mother {
        private String name;
        private String aadharNo;
        private String occupation;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAadharNo() { return aadharNo; }
        public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }

        public String getOccupation() { return occupation; }
        public void setOccupation(String occupation) { this.occupation = occupation; }
    }

    public static class Guardian {
        private String name;
        private String contactNo;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getContactNo() { return contactNo; }
        public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    }

    // Getters and Setters
    public Father getFather() { return father; }
    public void setFather(Father father) { this.father = father; }

    public Mother getMother() { return mother; }
    public void setMother(Mother mother) { this.mother = mother; }

    public Guardian getGuardian() { return guardian; }
    public void setGuardian(Guardian guardian) { this.guardian = guardian; }
}
