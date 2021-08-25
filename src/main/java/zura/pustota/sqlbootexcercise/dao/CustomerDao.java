package zura.pustota.sqlbootexcercise.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import zura.pustota.sqlbootexcercise.entity.Customer;
import zura.pustota.sqlbootexcercise.entity.Product;

import java.util.List;
import java.util.stream.Stream;


public interface CustomerDao extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByFirstName(String like);


}
