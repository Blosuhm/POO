package aula06;

import aula05.DateYMD;

public class Student extends Person {

    private static int nextNmec = 100;
    private DateYMD enrollmentDate;
    private int nmec;

    public Student(String name, int cc, DateYMD birthDate, DateYMD enrollmentDate) {
        super(name, cc, birthDate);
        studentValidator(enrollmentDate);
        this.enrollmentDate = enrollmentDate;
        this.nmec = nextNmec++;
    }

    public Student(String name, int cc, DateYMD birthDate) {
        super(name, cc, birthDate);
        this.enrollmentDate = new DateYMD();
        this.nmec = nextNmec++;
    }

    private void studentValidator(DateYMD enrollmentDate) {
        if (!isValidEnrollmentDate(enrollmentDate)) {
            throw new IllegalArgumentException("Invalid enrollment date");
        }
    }

    public boolean isValidEnrollmentDate(DateYMD enrollmentDate) {
        return enrollmentDate != null;
    }

    public int getNmec() {
        return this.nmec;
    }

    public void setNmec(int nmec) {
        this.nmec = nmec;
    }

    public DateYMD getEnrollmentDate() {
        return this.enrollmentDate;
    }

    public void setEnrollmentDate(DateYMD enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
