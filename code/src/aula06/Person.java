package aula06;

import aula05.DateYMD;

public class Person {

    private String name;
    private int cc;
    private DateYMD birthDate;

    public Person(String name, int cc, DateYMD birthDate) {
        personValidator(name, cc, birthDate);
        this.name = name;
        this.cc = cc;
        this.birthDate = birthDate;
    }

    public boolean isValidCC(int cc) {
        return 10000000 <= cc && cc <= 99999999;
    }

    public boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    public boolean isValidBirthDate(DateYMD birthDate) {
        return birthDate != null;
    }

    private void personValidator(String name, int cc, DateYMD birthDate) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (!isValidCC(cc)) {
            throw new IllegalArgumentException("CC should have 8 digits");
        }
        if (!isValidBirthDate(birthDate)) {
            throw new IllegalArgumentException("Invalid birth date");
        }
    }

    public int getCc() {
        return this.cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public DateYMD getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(DateYMD birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + "; cc: " + getCc() + "; Birth Date: " + getBirthDate();
    }
}
