/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_bai11_w8;

/**
 *
 * @author dinhh
 */
public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;


    public Fresher(Candidate c, String graduationDate, String graduationRank, String education) {
        super(c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthDate(),
              c.getAddress(), c.getPhone(), c.getEmail(), 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + graduationDate + " | " + graduationRank + " | " + education;
    }
}