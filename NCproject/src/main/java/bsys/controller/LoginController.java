package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/")
    public ModelAndView SigninPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }

   /* @PostMapping(value = "/{email}/{password}")
    public ModelAndView identifyClient(@PathVariable String email, @PathVariable String password) {
        ModelAndView modelAndView = new ModelAndView();
        Client client = clientService.findClientByEmail(email, password);
        int id = client.getIdClient();
        modelAndView.setViewName("redirect:/client/{id}"); // ???
        return modelAndView;
    }*/


}
