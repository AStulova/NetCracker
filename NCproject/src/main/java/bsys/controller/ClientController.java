package bsys.controller;

import bsys.service.client.ClientValidator;
import bsys.model.Client;
import bsys.service.security.SecurityService;
import bsys.service.client.ClientService;
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
    private SecurityService securityService;

    @Autowired
    private ClientValidator clientValidator;

    @GetMapping(value = "/")
    public ModelAndView SigninPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }

     @PostMapping(value = "/{email}")
     public ModelAndView identifyClient(@PathVariable String email) {
         ModelAndView modelAndView = new ModelAndView();
         Client client = clientService.findClientByEmail(email);
         modelAndView.setViewName("redirect:/client/" + client.getIdClient()); // ???
         return modelAndView;
     }

    @GetMapping(value = "/client/{id}")
    public ModelAndView findClient(@PathVariable int id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientPage");
        modelAndView.addObject("clientList", client);
        return modelAndView;
    }

    @PostMapping(value = "/client/{id}/{firstName}/{lastName}/{email}/{phone}")
    public ModelAndView editClient(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String email, @PathVariable String phone) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/client/"+id);
        clientService.editClient(firstName, lastName, email, phone, id);
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
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("SignUp");
            return modelAndView;
        }
        clientService.addClient(client);
        securityService.autoLogin(client.getEmail(), client.getPassword());
        modelAndView.setViewName("redirect:/client/"+ client.getIdClient());
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