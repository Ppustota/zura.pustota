package zura.pustota.sqlbootexcercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zura.pustota.sqlbootexcercise.entity.Customer;
import zura.pustota.sqlbootexcercise.entity.Product;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findByCustomer(Customer customer);
    List<Product> findByCustomer_Id(int id);



}
