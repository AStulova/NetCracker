package bsys.controller;

import bsys.model.Order;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView allOrders() {
        List<Order> orderList = orderService.allOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderPage");
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }

    @GetMapping(value = "/send/{id}")
    public ModelAndView sendOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderService.setStatusSend(id);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }

    @GetMapping(value = "/cancel/{id}")
    public ModelAndView cancelOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderService.cancelOrder(id);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }
}
