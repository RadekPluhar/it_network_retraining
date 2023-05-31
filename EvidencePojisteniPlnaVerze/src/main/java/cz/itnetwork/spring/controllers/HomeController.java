package cz.itnetwork.spring.controllers;

import org.springframework.ui.Model;
import cz.itnetwork.spring.models.dto.InsuranceRecordsDTO;
import cz.itnetwork.spring.models.services.InsuranceRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * controller for getting and posting data from front-end to back-end and back
 */
@Controller
public class HomeController {

    /**
     * wiring of functions
     */
    @Autowired
    private InsuranceRecordsService insuranceRecordsService;

    /**
     * getting the website of index
     *
     * @param insuranceRecordsDTO data from front-end
     * @param model               handover the result to view
     * @return return website
     */
    @GetMapping("/index")
    public String renderIndex(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO, Model model) {

        String numberOfInsureds = insuranceRecordsService.countOfInsureds();
        model.addAttribute("answerNumberOfInsureds", numberOfInsureds);

        return "index";
    }

    /**
     * getting the website of creation of insured
     *
     * @param insuranceRecordsDTO data from front-end
     * @return return website
     */
    @GetMapping("/creation-of-a-insured")
    public String renderCreationOfInsured(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO) {

        return "creation-of-a-insured";
    }

    /**
     * posting data from front-end of website of creation of insured
     *
     * @param insuranceRecordsDTO data from front-end
     * @param model               handover the information (Uloženo) to view
     * @return return website
     */
    @PostMapping("/creation-of-a-insured")
    public String giveBackInsured(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO, Model model) {

        String insured = insuranceRecordsService.creatingOfInsured(insuranceRecordsDTO);
        model.addAttribute("answerCreation", insured);

        return "creation-of-a-insured";
    }

    /**
     * getting the website of list
     *
     * @param insuranceRecordsDTO data from front-end
     * @param model               handover the result to view
     * @return return website
     */
    @GetMapping("/list")
    public String renderList(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO, Model model) {

        String listOfInsureds = insuranceRecordsService.showInsureds();
        model.addAttribute("answerShowOfInsureds", listOfInsureds);

        return "list";
    }

    /**
     * getting the website of search of insured
     *
     * @param insuranceRecordsDTO data from front-end
     * @return return website
     */
    @GetMapping("/search")
    public String renderSearchOfInsured(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO) {

        return "search";
    }

    /**
     * posting data from front-end of website of search of insured
     *
     * @param insuranceRecordsDTO data from front-end
     * @param model               handover the result to view
     * @return return website
     */
    @PostMapping("/search")
    public String giveBackSearchInsured(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO, Model model) {

        String insured = insuranceRecordsService.searchInsured(
                insuranceRecordsDTO.getFirstName(),
                insuranceRecordsDTO.getSurName()
        );
        model.addAttribute("answerSearching", insured);

        return "search";
    }

    /**
     * getting the website of the deleting of insured
     *
     * @param insuranceRecordsDTO data from front-end
     * @param model               handover the information (Pojištěnec byl smazán) to view
     * @return return website
     */
    @GetMapping("/delete")
    public String renderDelete(@ModelAttribute InsuranceRecordsDTO insuranceRecordsDTO, Model model) {

        String deletionInsured = insuranceRecordsService.deletionOfInsured();
        model.addAttribute("answerDeletion", deletionInsured);

        return "delete";
    }
}
