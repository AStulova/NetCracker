package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import bsys.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

    /*@RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }
*/
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signin(HttpSession session, Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tariff");
        return modelAndView;
    }

     /*@PostMapping(value = "/signin")
     public ModelAndView identifyClient(@ModelAttribute("client") Client client) {
         ModelAndView modelAndView = new ModelAndView();
         Client client1 = clientService.findClientByEmail(client.getEmail());
         if (client1 != null) {
             modelAndView.setViewName("redirect:/client");
             return modelAndView;
         }
         modelAndView.addObject("message", "You are not registered");
         modelAndView.setViewName("redirect:/signin");
         return modelAndView;
     }*/

    /*@GetMapping(value = "/client")
    public ModelAndView findClient() {
        List<Client> client1 = clientService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientInfo");
        modelAndView.addObject("clientList", client1);
        return modelAndView;
    }*/

    @GetMapping(value = "/client")
    public ModelAndView findClient(@AuthenticationPrincipal Client client) {
        Client client1 = clientService.getById(client.getIdClient());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientPage");
        modelAndView.addObject("clientList", client1);
        return modelAndView;
    }

    @PostMapping(value = "/client")
    public ModelAndView editClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        clientService.editClient(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhone(), client.getIdClient());
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