package cz.itnetwork.spring.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * a class that collects data from user input from the frontend
 */
public class InsuredDTO {

    /**
     * insured person id (not part of the entry from frontend)
     */
    private long insuredId;

    /**
     * input firstname
     */
    @NotBlank(message = "Vyplňte toto pole")
    @NotNull(message = "Vyplňte toto pole")
    private String firstname;

    /**
     * input surname
     */
    @NotBlank(message = "Vyplňte toto pole")
    @NotNull(message = "Vyplňte toto pole")
    private String surname;

    /**
     * input telephone number
     */
    @NotBlank(message = "Vyplňte toto pole")
    @NotNull(message = "Vyplňte toto pole")
    private String telephoneNumber;

    /**
     * input age
     */
    private int age;

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

    /**
     * getter for id
     *
     * @return age id
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
}
