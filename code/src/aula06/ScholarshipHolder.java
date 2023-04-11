package aula06;

import aula05.DateYMD;

public class ScholarshipHolder extends Student {
    private int scholarshipValue;
    private Teacher supervisor;

    public ScholarshipHolder(String name, int cc, DateYMD birthDate, DateYMD enrollmentDate, Teacher supervisor,
            int scholarshipValue) {
        super(name, cc, birthDate, enrollmentDate);
        scholarshipHolderValidator(scholarshipValue, supervisor);
        this.scholarshipValue = scholarshipValue;
        this.supervisor = supervisor;
    }

    public ScholarshipHolder(String name, int cc, DateYMD birthDate, Teacher supervisor, int scholarshipValue) {
        super(name, cc, birthDate);
        scholarshipHolderValidator(scholarshipValue, supervisor);
        this.scholarshipValue = scholarshipValue;
        this.supervisor = supervisor;
    }

    private void scholarshipHolderValidator(int scholarshipValue, Teacher supervisor) {
        if (!isValidScholarshipValue(scholarshipValue)) {
            throw new IllegalArgumentException("Invalid scholarship value");
        }
        if (!isValidSupervisor(supervisor)) {
            throw new IllegalArgumentException("Invalid supervisor");
        }
    }

    public boolean isValidScholarshipValue(int scholarshipValue) {
        return scholarshipValue > 0;
    }

    public boolean isValidSupervisor(Teacher supervisor) {
        return supervisor != null;
    }

    public int getScholarshipValue() {
        return this.scholarshipValue;
    }

    public void setScholarshipValue(int scholarshipValue) {
        this.scholarshipValue = scholarshipValue;
    }

    public Teacher getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

}
