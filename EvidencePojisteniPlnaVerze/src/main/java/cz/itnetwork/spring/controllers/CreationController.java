package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * a class for the establishment of the insured
 */
@Controller
@RequestMapping("/creation-of-a-insured")
public class CreationController {

    /**
     * interface for working with the database
     */
    @Autowired
    private InsuredService insuredService;

    /**
     * function that renders the page to the user
     *
     * @param insuredDTO data from the user (but not necessary at this time)
     * @return web page
     */
    @GetMapping
    public String renderCreationOfInsured(@ModelAttribute InsuredDTO insuredDTO) {

        return "pages/home/creation-of-a-insured";
    }

    /**
     * function that forwards the data to the InsuredService, creates the insured and also checks if all fields are filled
     *
     * @param insured            data from the user
     * @param result             resolves errors
     * @param redirectAttributes returns the result of the create method
     * @return web page
     */
    @PostMapping
    public String createInsured(
            @Valid @ModelAttribute InsuredDTO insured,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreationOfInsured(insured);

        insuredService.create(insured);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec uložen");

        return "redirect:/creation-of-a-insured";
    }
}
