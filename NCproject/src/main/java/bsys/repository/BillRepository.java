package bsys.repository;

import bsys.model.Bill;
import bsys.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByClientOrderByDateBillDesc(Client client);

    @Query(value = "call updateBill(?1)", nativeQuery = true)
    void updateBill(int idClient);

    /*@Query(value = "select _id_bill as id_bill, _id_client as id_client, _date_bill as date_bill, _discount as discount, _subtotal as subtotal, _total as total " +
            "from generatebill(?1)", nativeQuery = true)
    List<Bill> generateBills(int idClient);*/
}
