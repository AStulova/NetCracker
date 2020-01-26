package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    private void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/")
    public ModelAndView HomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage");
        return modelAndView;
    }

    @GetMapping(value="/signin")
    public ModelAndView loginForm() {
        return new ModelAndView("SignIn");
    }

    @GetMapping(value = "/client")
    public ModelAndView findClient() {
        Client client = clientService.getAuthClient();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientPage");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @PostMapping(value = "/client")
    public ModelAndView editClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(client, bindingResult, modelAndView);
            modelAndView.addObject("client", clientService.getAuthClient());
            modelAndView.setViewName("ClientPage");
        }
        else {
            clientService.editClient(client);
            modelAndView.setViewName("redirect:/client");
        }
        return modelAndView;
    }

    @GetMapping(value = "/signup")
    public ModelAndView addClientPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView addClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(client, bindingResult, modelAndView);
            modelAndView.setViewName("SignUp");
        }
        else {
            clientService.addClient(client);
            modelAndView.setViewName("redirect:/signin");
        }
        return modelAndView;
    }

    private void getErrorMap(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult, ModelAndView modelAndView) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage
        );
        Map<String, String> errors = bindingResult.getFieldErrors().stream().collect(collector);
        modelAndView.addObject("errorMessage", errors);
        modelAndView.addObject("newClient", client);
    }

   /* @GetMapping(value = "/client-delete/{id}")
    public ModelAndView deleteClient(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/client/"+id);
        Client client = clientService.getById(id);
        clientService.deleteClient(client);
        return modelAndView;
    }*/
}