package bsys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    private ModelAndView handleForbiddenEntry(SecurityException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("httpCode", 403);
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("ErrorPage");
        return modelAndView;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ModelAndView handleUsernameNotFound(UsernameNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("httpCode", 404);
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("ErrorPage");
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ModelAndView handleNullPointerException(NullPointerException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("httpCode", 500);
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("ErrorPage");
        return modelAndView;
    }

    @ExceptionHandler(IllegalStateException.class)
    private ModelAndView handleNullPointerException(IllegalStateException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorEx", ex.getMessage());
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }
}
