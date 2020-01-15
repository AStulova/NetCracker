package bsys.controller;

import bsys.model.Tariff;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class TariffController {
    private TariffService tariffService;

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping(value = "/{idOrder}/add/tariff")
    public ModelAndView allTariffs(@PathVariable int idOrder) {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("idOrder", idOrder);
        return modelAndView;
    }

    @GetMapping(value = "/tariff")
    public ModelAndView allTariffsNewOrder() {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        return modelAndView;
    }

    /*@GetMapping(value = "/tariff-add")
    public ModelAndView addTariffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("old/TariffEdit");
        return modelAndView;
    }

    @GetMapping(value = "/tariff-edit/{id}")
    public ModelAndView editTariffPage(@PathVariable int id) {
        Tariff tariff = tariffService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("old/TariffEdit");
        modelAndView.addObject("tariff", tariff);
        return modelAndView;
    }

    @PostMapping(value = "/tariff-add")
    public ModelAndView addTariff(@ModelAttribute("tariff") Tariff tariff) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tariff");
        tariffService.addTariff(tariff);
        return modelAndView;
    }

    @GetMapping(value = "/tariff-delete/{id}")
    public ModelAndView deleteConnection(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tariff");
        Tariff tariff = tariffService.getById(id);
        tariffService.deleteTariff(tariff);
        return modelAndView;
    }*/
}
