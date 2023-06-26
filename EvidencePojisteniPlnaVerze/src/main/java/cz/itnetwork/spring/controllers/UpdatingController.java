package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.dto.mappers.InsuredMapper;
import cz.itnetwork.spring.models.exceptions.InsuredNotFoundException;
import cz.itnetwork.spring.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * a class for adjusting the insured
 */
@Controller
@RequestMapping("/edit/{insuredId}")
public class UpdatingController {

    /**
     * interface for working with the database
     */
    @Autowired
    private InsuredService insuredService;

    /**
     * an interface for transferring data from the frontend to the database and back
     */
    @Autowired
    private InsuredMapper insuredMapper;

    /**
     * a page for editing the insured
     *
     * @param insuredId id of the record in the database
     * @param insured   data from the user for adjusting
     * @return web page
     */
    @GetMapping
    public String renderEditForm(@PathVariable Long insuredId, InsuredDTO insured) {

        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);

        return "pages/home/edit";
    }

    /**
     * sending modified data about the insured
     *
     * @param insuredId          id of the record in the database
     * @param insured            edited data from the user
     * @param result             resolves errors
     * @param redirectAttributes returns the result of the adjusting method
     * @return web page
     */
    @PostMapping
    public String editInsured(
            @PathVariable long insuredId,
            @Valid InsuredDTO insured,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(insuredId, insured);

        insured.setInsuredId(insuredId);
        insuredService.edit(insured);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec upraven");

        return "redirect:/list";
    }

    /**
     * notification that the insured was not found (e.g. in the case of an invalid link)
     *
     * @param redirectAttributes returns the result about error
     * @return web page
     */
    @ExceptionHandler({InsuredNotFoundException.class})
    public String handleINsuredNotFoundException(
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", "Pojištěnec nenalezen");
        return "redirect:/list";
    }

}
