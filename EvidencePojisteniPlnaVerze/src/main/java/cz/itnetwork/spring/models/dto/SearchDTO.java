package cz.itnetwork.spring.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * a class that collects firstname and surname from user input from the frontend for searching of an insured
 */
public class SearchDTO {

    /**
     * input firstname
     */
    @NotBlank(message = "Vyplňte toto pole")
    @NotNull(message = "Vyplňte toto pole")
    private String searchFirstname;

    /**
     * input surname
     */
    @NotBlank(message = "Vyplňte toto pole")
    @NotNull(message = "Vyplňte toto pole")
    private String searchSurname;

    /**
     * getter for firstname
     *
     * @return firstname
     */
    public String getSearchFirstname() {
        return searchFirstname;
    }

    /**
     * setter for firstname
     *
     * @param searchFirstname firstname
     */
    public void setSearchFirstname(String searchFirstname) {
        this.searchFirstname = searchFirstname;
    }

    /**
     * getter for surname
     *
     * @return surname
     */
    public String getSearchSurname() {
        return searchSurname;
    }

    /**
     * setter for surname
     *
     * @param searchSurname surname
     */
    public void setSearchSurname(String searchSurname) {
        this.searchSurname = searchSurname;
    }
}
