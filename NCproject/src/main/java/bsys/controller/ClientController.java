package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client")
    public ModelAndView allClients() {
        List<Client> client = clientService.allClients();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientPage");
        modelAndView.addObject("clientList", client);
        return modelAndView;
    }

    @GetMapping(value = "/client-edit/{id}")
    public ModelAndView editClientPage(@PathVariable int id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("old/ClientEdit");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @PostMapping(value = "/client-edit")
    public ModelAndView editClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/client");
        clientService.editClient(client);
        return modelAndView;
    }

    @GetMapping(value = "/signup")
    public ModelAndView addClientPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView addClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/client");
        clientService.addClient(client);
        return modelAndView;
    }

    @GetMapping(value = "/delete-client/{id}")
    public ModelAndView deleteClient(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/client");
        Client client = clientService.getById(id);
        clientService.deleteClient(client);
        return modelAndView;
    }
}