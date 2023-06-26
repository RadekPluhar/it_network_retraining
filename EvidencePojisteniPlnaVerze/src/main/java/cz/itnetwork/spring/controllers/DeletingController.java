package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.dto.mappers.InsuredMapper;
import cz.itnetwork.spring.models.services.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a class for the removing of the insured
 */
@Controller
@RequestMapping("/delete/{insuredId}")
public class DeletingController {

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
     * the removing of the insured
     *
     * @param insuredId id of the record in the database
     * @return web page
     */
    @GetMapping
    public String deleteInsured(@PathVariable long insuredId) {
        insuredService.remove(insuredId);

        return "pages/home/delete";
    }

}
