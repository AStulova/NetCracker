package app.controller;

import app.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.PurchaseService;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> findAll(){
        return purchaseService.findAllPurchases();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Purchase> findById(@PathVariable int id) {
        Purchase purchase = purchaseService.findPurchase(id);
        if (purchase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(purchase);
        }
    }

    @PostMapping("/add")
    public void addPurchase(@RequestBody Purchase purchase) {
        purchaseService.addPurchase(purchase);
    }

    @PatchMapping("/set/{id}/{number}")
    public void setPurchaseNumber(@PathVariable int id, @RequestBody Purchase purchase) {
        purchaseService.setPurchaseNumber(purchase.getNumber(), id);
    }

    @PutMapping("/update/{id}")
    public void updatePurchaseInfo(@PathVariable int id, @RequestBody Purchase purchase) {
        purchaseService.updatePurchaseInfo(purchase.getDate(), purchase.getIdStore(), purchase.getIdBuyer(), purchase.getIdBook(), purchase.getNumber(), purchase.getTotal(), id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePurchase(@PathVariable int id) {
        purchaseService.deletePurchase(id);
    }

    @GetMapping("/date")
    public List<Integer> findPurchaseDate() {
        return purchaseService.findDate();
    }

    @GetMapping("/buyer-store")
    public List<Object[]> getBuyerAndStore() {
        return purchaseService.getBuyerAndStore();
    }

    @GetMapping("/info")
    public List<Object[]> getPurchaseInfo() {
        return purchaseService.getPurchaseInfo();
    }

    @GetMapping("/info-total")
    public List<Object[]> getInfoByTotal() {
        return purchaseService.getInfoByTotal();
    }

    @GetMapping("/purchases-march")
    public List<Object[]> getPurchaseInMarch() {
        return purchaseService.getPurchaseInMarch();
    }
}
