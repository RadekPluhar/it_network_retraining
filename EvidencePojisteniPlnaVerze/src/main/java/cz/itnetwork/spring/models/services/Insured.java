package cz.itnetwork.spring.models.services;

import cz.itnetwork.spring.models.dto.InsuranceRecordsDTO;

/**
 * transcript for the insured
 */
public class Insured {

    /**
     * firstname of an insured
     */
    private String firstName;

    /**
     * surname of an insured
     */
    private String surName;

    /**
     * telephone number of an insured
     */
    private String telephoneNumber;

    /**
     * age of an insured
     */
    private int age;

    /**
     * Constructor
     *
     * @param insuranceRecordsDTO data from front-end to back-end
     */
    public Insured(InsuranceRecordsDTO insuranceRecordsDTO) {
        this.setFirstName(insuranceRecordsDTO.getFirstName());
        this.setSurName(insuranceRecordsDTO.getSurName());
        this.setTelephoneNumber(insuranceRecordsDTO.getTelephoneNumber());
        this.setAge(insuranceRecordsDTO.getAge());
    }

    /**
     * statement of the insured
     *
     * @return one line with information about an insured
     */
    @Override
    public String toString() {
        return String.format("%s %s, tel: %s, věk: %s", getFirstName(), getSurName(), getTelephoneNumber(), getAge());
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
