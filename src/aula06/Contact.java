package aula06;

public class Contact {
    private Person person;
    private String email = "no email";
    private int phone = -1;
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[a-z0-9]+\\.[a-z]{2,3}$";

    public Contact(Person person, String email, int phone) {
        contactValidator(email, phone);
        this.person = person;
        this.email = email;
        this.phone = phone;
    }

    public Contact(Person person, String email) {
        contactValidator(email);
        this.person = person;
        this.email = email;
    }

    public Contact(Person person, int phone) {
        contactValidator(phone);
        this.person = person;
        this.phone = phone;
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public boolean isValidPhone(int phone) {
        return 900000000 <= phone && phone <= 999999999;
    }

    private void contactValidator(String email, int phone) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone");
        }
    }

    private void contactValidator(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    private void contactValidator(int phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone");
        }
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    private void validateEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    private void validatePhone(int phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone");
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.person.getName() + "; Number: " + this.phone + "; Email: " + this.email;
    }

}
