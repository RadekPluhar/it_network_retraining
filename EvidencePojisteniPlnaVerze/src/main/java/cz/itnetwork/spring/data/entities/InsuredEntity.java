package cz.itnetwork.spring.data.entities;

import jakarta.persistence.*;

/**
 * a table of insureds in the database
 */
@Entity
public class InsuredEntity {

    /**
     * column id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuredId;

    /**
     * column firstname
     */
    @Column(nullable = false)
    private String firstname;

    /**
     * column surname
     */
    @Column(nullable = false)
    private String surname;

    /**
     * column telephone number
     */
    @Column(nullable = false)
    private String telephoneNumber;

    /**
     * column age
     */
    @Column
    private int age;

    /**
     * getter for id
     *
     * @return id
     */
    public long getInsuredId() {
        return insuredId;
    }

    /**
     * setter for id
     *
     * @param insuredId id
     */
    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    /**
     * getter for firstname
     *
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * setter for firstname
     *
     * @param firstname firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * getter for surname
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for surname
     *
     * @param surname surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * getter for telephone number
     *
     * @return telephone number
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * setter for telephone number
     *
     * @param telephoneNumber telephone number
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * getter for age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * setter for age
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
