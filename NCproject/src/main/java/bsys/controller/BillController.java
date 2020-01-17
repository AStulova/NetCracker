package bsys.controller;

import bsys.model.Bill;
import bsys.model.Product;
import bsys.service.bill.BillService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/bill")
public class BillController {
    private BillService billService;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setClientService(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ModelAndView allBills() {
        List<Bill> billList = billService.allBills();
        List<Product> productList = productService.allProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillPage");
        modelAndView.addObject("billList", billList);
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }


    /*@PostMapping(value = "/bill-edit")
    public ModelAndView editBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.editBill(bill);
        return modelAndView;
    }

    @GetMapping(value = "/bill-add")
    public ModelAndView addBillPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("old/BillEdit");
        return modelAndView;
    }

    @PostMapping(value = "/bill-add")
    public ModelAndView addBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.addBill(bill);
        return modelAndView;
    }

    @GetMapping(value = "/bill-delete/{id}")
    public ModelAndView deleteBill(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        Bill bill = billService.getById(id);
        billService.deleteBill(bill);
        return modelAndView;
    }*/
}
