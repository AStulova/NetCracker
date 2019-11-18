package bsys.controller;

import bsys.model.Client;
import bsys.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setFilmService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allClients() {
        List<Client> client = clientService.allClients();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientInfo");
        modelAndView.addObject("clientList", client);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable int id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditClient");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");     // возврат на главную страницу
        clientService.editClient(client);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditClient");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        clientService.addClient(client);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteClient(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Client client = clientService.getById(id);
        clientService.deleteClient(client);
        return modelAndView;
    }
}