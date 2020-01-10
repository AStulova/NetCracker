package app.controller;

import app.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.BuyerService;

import java.util.List;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping
    public List<Buyer> findAll(){
        return buyerService.findAllBuyers();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Buyer> findById(@PathVariable int id) {
        Buyer buyer = buyerService.findBuyer(id);
        if (buyer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(buyer);
        }
    }

    @PostMapping("/add")
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
    }

    @PatchMapping("/set/{id}")
    public void setBuyerResidence(@PathVariable int id, @RequestBody Buyer buyer) {
        buyerService.setBuyerResidence(buyer.getResidence(), id);
    }

    @PutMapping("/update/{id}")
    public void updateBuyerInfo(@PathVariable int id, @RequestBody Buyer buyer) {
        buyerService.updateBuyerInfo(buyer.getSurname(), buyer.getResidence(), buyer.getDiscount(), id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBuyer(@PathVariable int id) {
        buyerService.deleteBuyer(id);
    }

    @GetMapping("/residence")
    List<String> findBuyerResidence() {
       return buyerService.findResidence();
    }

    @GetMapping("/n-region")
    List<Buyer> findSurnameAndDiscount() {
        return buyerService.findSurnameAndDiscount();
    }
}
