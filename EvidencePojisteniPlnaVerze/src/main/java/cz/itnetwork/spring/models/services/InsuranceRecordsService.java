package cz.itnetwork.spring.models.services;

import cz.itnetwork.spring.models.dto.InsuranceRecordsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * the methods for the application
 */
@Service
public class InsuranceRecordsService {

    /**
     * the instance of the insured
     */
    Insured insured;

    /**
     * the instance of the data from front-end to back-end
     */
    InsuranceRecordsDTO insuranceRecordsDTO;

    /**
     * the instance of List collection for insureds
     */
    public List<Insured> insureds = new ArrayList<>();

    /**
     * adding an insured to the List
     *
     * @param insuranceRecordsDTO data from front-end
     * @return the notice of this action
     */
    public String creatingOfInsured(InsuranceRecordsDTO insuranceRecordsDTO) {
        insureds.add(new Insured(insuranceRecordsDTO));

        return "Uloženo";
    }

    /**
     * showing insureds from the List
     *
     * @return the insureds or an information about empty List
     */
    public String showInsureds() {
        String listOfInsureds = "";
        for (Insured p : this.insureds) {
            listOfInsureds += "POJIŠTĚNÝ(Á): " + p + "; ";
        }
        if (this.insureds.isEmpty()) {
            return "V Evidenci není žádný pojištěný...";
        }
        return String.format("%s", listOfInsureds);
    }

    /**
     * showing count of the insureds
     *
     * @return the number in String
     */
    public String countOfInsureds() {

        return String.format("Počet pojištěných: %s", this.insureds.size());
    }

    /**
     * look for of an insured
     *
     * @param firstName firstname of an insured
     * @param surName   surname of an insured
     * @return toString of the class Insured (an insured was found) or an information about unsuccessful searching
     */
    public String searchInsured(String firstName, String surName) {
        for (Insured p : this.insureds) {
            if (firstName.equals(p.getFirstName())) {
                if (surName.equals(p.getSurName())) {
                    insured = p;
                    return insured.toString();
                }
            }
        }
        return "Tohoto pojištěného v evidenci nemáme.";
    }

    /**
     * deleting of an insured
     *
     * @return an information about deleting
     */
    public String deletionOfInsured() {
        insureds.remove(insured);

        return "Pojištěnec byl smazán.";
    }
}
