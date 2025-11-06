/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_bai11_w8;

/**
 *
 * @author dinhh
 */
public class Intern extends Candidate {
    private String majors;
    private int semester;
    private String universityName;

    public Intern(Candidate c, String majors, int semester, String universityName) {
        super(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthDate(),
              c.getAddress(), c.getPhone(), c.getEmail(), 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + majors + " | Semester " + semester + " | " + universityName;
    }
}
