package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.dto.SearchDTO;
import cz.itnetwork.spring.models.services.SearchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * a class for to search a specific insured
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    /**
     * a class with a method that searches for a specific insured
     */
    @Autowired
    private SearchService searchService;

    /**
     * page for finding the insured
     *
     * @param searchDTO data from the user (firstname and surname)
     * @return web page
     */
    @GetMapping
    public String renderSearch(@ModelAttribute SearchDTO searchDTO) {

        return "pages/home/search";
    }

    /**
     * a function that sends data to the SearchService, where there is a function to find the insured
     *
     * @param searchDTO data from the user (firstname and surname)
     * @param model     returns the query result
     * @return web page
     */
    @PostMapping
    public String searchingInsured(
            @ModelAttribute SearchDTO searchDTO,
            Model model
    ) {

        List<InsuredDTO> insuredFinded = searchService.toSearch(searchDTO);
        if (insuredFinded.size() > 0) {
            model.addAttribute("insuredFinded", insuredFinded);
        } else {
            String message = "Tohle tu není";
            model.addAttribute("message", message);
        }

        return "pages/home/search";
    }
}
