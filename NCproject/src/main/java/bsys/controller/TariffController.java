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

    @GetMapping(value = "/tariff")
    public ModelAndView allTariffs() {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        return modelAndView;
    }

    @GetMapping(value = "/add-tariff")
    public ModelAndView addTariffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffEdit");
        return modelAndView;
    }

    @GetMapping(value = "/edit-tariff/{id}")
    public ModelAndView editTariffPage(@PathVariable int id) {
        Tariff tariff = tariffService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffEdit");
        modelAndView.addObject("tariff", tariff);
        return modelAndView;
    }

    @PostMapping(value = "/add-tariff")
    public ModelAndView addTariff(@ModelAttribute("tariff") Tariff tariff) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tariff");
        tariffService.addTariff(tariff);
        return modelAndView;
    }

    @GetMapping(value = "/delete-tariff/{id}")
    public ModelAndView deleteConnection(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tariff");
        Tariff tariff = tariffService.getById(id);
        tariffService.deleteTariff(tariff);
        return modelAndView;
    }
}
