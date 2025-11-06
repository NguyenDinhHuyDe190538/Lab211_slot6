/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_bai11_w8;

/**
 *
 * @author dinhh
 */
public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(Candidate c, int expInYear, String proSkill) {
        super(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthDate(),
              c.getAddress(), c.getPhone(), c.getEmail(), 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + expInYear + " years | " + proSkill;
    }
}
