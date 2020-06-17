package bsys.controller;

import bsys.model.Tariff;
import bsys.service.Validator.FieldsValidator;
import bsys.service.client.ClientService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class TariffController {
    private TariffService tariffService;
    private ClientService clientService;
    private FieldsValidator fieldsValidator;

    @Autowired
    private void setFieldsValidator(FieldsValidator fieldsValidator) {
        this.fieldsValidator = fieldsValidator;
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idOrder}/add/tariff")
    public ModelAndView tariffsForOrderPage(@PathVariable int idOrder) {
        fieldsValidator.verifyClient(idOrder);
        List<Tariff> tariff =  tariffService.getTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("idOrder", idOrder);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @GetMapping(value = "/tariff")
    public ModelAndView tariffsPage() {
        List<Tariff> tariff =  tariffService.getTariffs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TariffPage");
        modelAndView.addObject("tariffList", tariff);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/tariff/{idClient}")
    public ModelAndView tariffsNewOrderPage(@PathVariable int idClient) {
        List<Tariff> tariff =  tariffService.getTariffs();
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
            fieldsValidator.getErrorMap(bindingResult);
            modelAndView.addObject("newTariff", tariff);
            modelAndView.setViewName("TariffEdit");
        }
        else {
            Map<String, String> errorMessage = fieldsValidator.tariffValidate(tariff);
            if (!errorMessage.isEmpty()) {
                modelAndView.addObject("errorMessage", errorMessage);
                modelAndView.addObject("newTariff", tariff);
                modelAndView.setViewName("TariffEdit");
            }
            else {
                tariffService.addTariff(tariff);
                modelAndView.setViewName("redirect:/tariff");
            }
        }
        return modelAndView;
    }
}