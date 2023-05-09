package aula06;

import aula05.DateYMD;

public class Main {

    public static void main(String[] args) {
        Student al = new Student("Andreia Melo", 98553678, new DateYMD(1990, 7, 18),
            new DateYMD(2018, 9, 1));
        Teacher p1 = new Teacher("Jorge Almeida", 34673225, new DateYMD(1967, 3, 13), "Associate",
            "Informática");
        ScholarshipHolder bls = new ScholarshipHolder("Igor Santos", 89763543,
            new DateYMD(1985, 5, 11), p1, 900);
        bls.setScholarshipValue(1050);
        System.out.println("Student: " + al.getName());
        System.out.println(al);

        System.out.println(
            "Scholarship Holder: " + bls.getName() + ", nmec: " + bls.getNmec() + ", Scholarship: "
                + bls.getScholarshipValue() + ", Supervisor: " + bls.getSupervisor());
        System.out.println(bls);
    }
}
