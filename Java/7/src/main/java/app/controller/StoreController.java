package app.controller;

import app.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.StoreService;

import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> findAll(){
        return storeService.findAllStores();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Store> findById(@PathVariable int id) {
        Store store = storeService.findStore(id);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(store);
        }
    }

    @PostMapping("/add")
    public void addStore(@RequestBody Store store) {
        storeService.addStore(store);
    }

    @PatchMapping("/set/{id}")
    public void setStorePlacement(@PathVariable int id, @RequestBody Store store) {
        Store store1 = storeService.findStore(id);
        storeService.setStorePlacement(store.getPlacement(), id);
    }

    @PutMapping("/update/{id}")
    public void updateStoreInfo(@PathVariable int id, @RequestBody Store store) {
        storeService.updateStoreInfo(store.getName(), store.getPlacement(), store.getCommission(), id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
    }

    @GetMapping("/s-region")
    public List<String> findByPlacement() {
        return storeService.findByPlacement();
    }

    @GetMapping("/store-not-in-autozavod")
    public List<String> getStores() {
        return storeService.getStores();
    }
}
