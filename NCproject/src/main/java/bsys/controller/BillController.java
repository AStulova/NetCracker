package bsys.controller;

import bsys.model.Bill;
import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.service.bill.BillService;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/bill")
public class BillController {
    private BillService billService;
    private ProductService productService;
    private OrderService orderService;
    private ClientService clientService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ModelAndView allBills() {
        return getClientBills(clientService.getAuthClient());
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/{idClient}")
    public ModelAndView allClientBills(@PathVariable int idClient) {
        return getClientBills(clientService.getById(idClient));
    }

    /*@PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping
    public ModelAndView allClientBills(@Valid @ModelAttribute Bill bill, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(bindingResult, modelAndView);
            modelAndView.addObject("curBill", bill);
            return getClientBills(clientService.getById(bill.getClient().getIdClient()));
        }
        else {
            billService.editBill(bill);
            modelAndView.setViewName("redirect:/bill/" + bill.getClient().getIdClient());
            return modelAndView;
        }
    }*/

    private ModelAndView getClientBills(Client client) {
        List<Bill> billList = billService.allBills(client.getIdClient());
        List<Product> productList = productService.allProducts(client);
        List<Order> orderList = orderService.allOrders(client);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillPage");
        modelAndView.addObject("billList", billList);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("client", client);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }
}
