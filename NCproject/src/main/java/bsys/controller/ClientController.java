package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import bsys.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    private void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }


    @Autowired
    private ClientValidator clientValidator;

    @GetMapping(value = "/")
    public ModelAndView HomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage");
        return modelAndView;
    }

    @RequestMapping(value="/signin", method=RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("SignIn");
    }

    @GetMapping(value = "/client")
    public ModelAndView findClient() {
        Client client = clientService.getAuthClient();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientPage");
        modelAndView.addObject("clientList", client);
        return modelAndView;
    }

    @PostMapping(value = "/client/edit")
    public ModelAndView editClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        clientService.editClient(client);
        modelAndView.setViewName("redirect:/client");
        return modelAndView;
    }

    @GetMapping(value = "/signup")
    public ModelAndView addClientPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        clientValidator.validate(client, bindingResult);
        /*if (bindingResult.hasErrors()) {
            modelAndView.addObject("message", bindingResult.getFieldErrors()); // сделать вывод
            modelAndView.setViewName("redirect:/signup");
            return modelAndView;
        }*/
        clientService.addClient(client);
        //securityService.autoLogin(client.getEmail(), client.getPassword());
        modelAndView.setViewName("redirect:/signin");
        return modelAndView;
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