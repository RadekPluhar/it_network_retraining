package cz.itnetwork.spring.models.services;

import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * a class with a method that searches for a specific insured
 */
@Service
public class SearchService {

    /**
     * interface for working with the database
     */
    @Autowired
    private InsuredService insuredService;

    /**
     * a function that searches for insured persons based on first and last name
     *
     * @param model first and last name from the frontend
     * @return list of found insured persons whose first and last names match the first and last names entered by the user on the frontend
     */
    public List<InsuredDTO> toSearch(SearchDTO model) {

        List<InsuredDTO> insureds = insuredService.getAll();
        List<InsuredDTO> insuredsSearch = new ArrayList<>();

        for (InsuredDTO insured : insureds) {

            if (
                    insured.getFirstname().toLowerCase()
                            .equals(model.getSearchFirstname().toLowerCase())
                            && insured.getSurname().toLowerCase()
                            .equals(model.getSearchSurname().toLowerCase())
            ) {
                insuredsSearch.add(insured);
            }
        }

        return insuredsSearch;
    }

}
