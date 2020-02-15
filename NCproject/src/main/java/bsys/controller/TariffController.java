package bsys.controller;

import bsys.model.Tariff;
import bsys.service.client.ClientService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class TariffController {
    private TariffService tariffService;
    private ClientService clientService;

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idOrder}/add/tariff")
    public ModelAndView allTariffs(@PathVariable int idOrder) {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("idOrder", idOrder);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @GetMapping(value = "/tariff")
    public ModelAndView allTariffsNewOrder() {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/tariff/{idClient}")
    public ModelAndView allTariffsNewOrder(@PathVariable int idClient) {
        List<Tariff> tariff =  tariffService.allTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("idClient", idClient);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping(value = "/tariff/add")
    public ModelAndView addTariffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        modelAndView.setViewName("TariffEdit");
        return modelAndView;
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping(value = "/tariff/edit/{idTariff}")
    public ModelAndView editTariffPage(@PathVariable int idTariff) {
        Tariff tariff = tariffService.getById(idTariff);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tariff", tariff);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        modelAndView.setViewName("TariffEdit");
        return modelAndView;
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping(value = "/tariff/add")
    public ModelAndView addTariff(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(tariff, bindingResult, modelAndView);
            modelAndView.setViewName("TariffEdit");
        }
        else {
            tariffService.addTariff(tariff);
            modelAndView.setViewName("redirect:/tariff");
        }
        return modelAndView;
    }

    private void getErrorMap(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult bindingResult, ModelAndView modelAndView) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage
        );
        Map<String, String> errors = bindingResult.getFieldErrors().stream().collect(collector);
        modelAndView.addObject("errorMessage", errors);
        modelAndView.addObject("newTariff", tariff);
    }
}
