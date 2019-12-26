package app.controller;

import app.model.Mail;
import app.model.User;
import app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import app.service.UserService;

import javax.validation.ValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserController {
    @Autowired
    EmailService emailService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showMain() {
        return "main-page";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("add", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUserSubmit(@ModelAttribute User user) throws ValidationException {
        try {
            userService.addUser(user);
        } catch (ValidationException | IOException e) {
            e.printStackTrace();
            return "error-page";
        }
        return "success-page";
    }

    @GetMapping("/add-from-file")
    public String addFromFileForm() {
        return "add-from-file";
    }

    @PostMapping("/add-from-file")
    public String addFromFileSubmit(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src\\main\\resources\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            userService.addUser(path.toString());
            redirectAttributes.addFlashAttribute("message", "Success!");
        } catch (ValidationException | IOException e) {
            e.printStackTrace();
        }
        return "success-page";
    }

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("search", new User());
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute User user, Model model) {
        try{
            User user1 = userService.findUser(user);
            if(user1 != null) {
                model.addAttribute("user1", user1);
                return "search-user";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "error-page";
    }

    @GetMapping("/send")
    public String sendMailForm(Model model) {
        model.addAttribute("send", new Mail());
        return "send";
    }

    @PostMapping("/send")
    public String sendMailSubmit(@ModelAttribute Mail mail) {
        try {
            emailService.sendMail(mail.getTo(), mail.getSubject(), mail.getText());
        } catch (MailSendException e) {
            return "error-page";
        }
        return "success-page";
    }
}
