package service;

import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    public Store findStore(int idStore) {
        return storeRepository.findByIdStore(idStore);
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void setStorePlacement(String placement, int idStore) {
        storeRepository.setStorePlacement(placement, idStore);
    }

    public void updateStoreInfo(String name, String placement, double commission, int idStore) {
        storeRepository.updateStoreInfo(name, placement, commission, idStore);
    }

    public void deleteStore(int idStore) {
        storeRepository.deleteById(idStore);
    }
}
