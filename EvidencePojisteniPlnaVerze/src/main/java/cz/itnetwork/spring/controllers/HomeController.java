package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.dto.mappers.InsuredMapper;
import cz.itnetwork.spring.models.services.InsuredService;
import cz.itnetwork.spring.models.services.InsuredServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * a class for pages: index and list of all insureds
 */
@Controller
public class HomeController {

    /**
     * an interface for transferring data from the frontend to the database and back
     */
    @Autowired
    private InsuredMapper insuredMapper;

    /**
     * interface for working with the database
     */
    @Autowired
    private InsuredService insuredService;

    /**
     * implementation of interface functions for working with the database
     */
    @Autowired
    private InsuredServiceImpl insuredServiceImpl;

    /**
     * index page
     *
     * @return web page
     */
    @GetMapping("/")
    public String renderIndex() {

        return "pages/home/index";
    }

    /**
     * a list of all insured persons
     *
     * @param model returns the query result
     * @return web page
     */
    @GetMapping("/list")
    public String renderList(Model model) {
        List<InsuredDTO> insureds = insuredService.getAll();
        if (insureds.size() > 0) {
            model.addAttribute("insureds", insureds);
        } else {
            String message = "Tady nikdo není!";
            model.addAttribute("message", message);
        }

        return "pages/home/list";
    }

}
