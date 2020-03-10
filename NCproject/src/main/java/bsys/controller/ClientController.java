package bsys.controller;

import bsys.model.Client;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage");
        return modelAndView;
    }

    @GetMapping(value="/signin")
    public ModelAndView signInPage() {
        return new ModelAndView("SignIn");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/user/add")
    public ModelAndView signUpPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/user/{idClient}/edit")
    public ModelAndView editUserPage(@PathVariable int idClient) {
        ModelAndView modelAndView = new ModelAndView();
        Client client = clientService.getById(idClient);
        modelAndView.addObject("curClient", client);
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/signup")
    public ModelAndView addClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(client, bindingResult, modelAndView);
            modelAndView.setViewName("SignUp");
        }
        else {
            if (client.getIdClient() == 0 && client.getPassword().length() > 16) {
                Map<String, String> errors = new HashMap<>();
                errors.put("password", "Password must be between 8 and 16 characters!");
                modelAndView.addObject("errorMessage", errors);
                modelAndView.addObject("curClient", client);
                modelAndView.setViewName("SignUp");

            }
            else {
                clientService.addClient(client);
                modelAndView.setViewName("redirect:/users");
            }
        }
        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/users")
    public ModelAndView usersPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Client> clientList = clientService.findAllUsers();
        modelAndView.addObject("clientList", clientList);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        modelAndView.setViewName("AllClientsPage");
        return modelAndView;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/clients")
    public ModelAndView allClientsPage() {
        List<Client> clientList = clientService.findAllClients();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AllClientsPage");
        modelAndView.addObject("clientList", clientList);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @GetMapping(value = "/client")
    public ModelAndView clientPage() {
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
            if (!client.getEmail().equals(clientService.getAuthClient().getEmail())) {
                SecurityContextHolder.clearContext();
                modelAndView.setViewName("redirect:/signin");
            }
            else {
                modelAndView.setViewName("redirect:/client");
            }
            clientService.editClient(client);
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
        modelAndView.addObject("curClient", client);
    }
}