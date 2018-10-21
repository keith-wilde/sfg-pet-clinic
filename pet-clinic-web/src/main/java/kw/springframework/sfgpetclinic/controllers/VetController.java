package kw.springframework.sfgpetclinic.controllers;

import kw.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "index", "index.html", "vets.html"})
    public String index(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
