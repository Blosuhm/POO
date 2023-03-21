package aula06;

import aula05.DateYMD;

public class Teacher extends Person {
    private String category;
    private String department;

    public Teacher(String name, int cc, DateYMD birthDate, String category, String department) {
        super(name, cc, birthDate);
        teacherValidator(category, department);
        this.category = category;
        this.department = department;
    }

    private void teacherValidator(String category, String department) {
        if (!isValidCategory(category)) {
            throw new IllegalArgumentException("Invalid category");
        }

        if (!isValidDepartment(department)) {
            throw new IllegalArgumentException("Invalid department");
        }
    }

    public boolean isValidCategory(String category) {
        return category.equals("Assistant") || category.equals("Associate") || category.equals("Full");
    }

    public boolean isValidDepartment(String department) {
        return department != null && !department.isEmpty();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
