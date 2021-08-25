package zura.pustota.sqlbootexcercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import zura.pustota.sqlbootexcercise.dao.CustomerDao;
import zura.pustota.sqlbootexcercise.dao.ProductDao;
import zura.pustota.sqlbootexcercise.entity.Customer;
import zura.pustota.sqlbootexcercise.entity.Product;
import zura.pustota.sqlbootexcercise.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerDao.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id)  {
    if(!customerDao.findById(id).isPresent())
        throw new CustomerNotFoundException("Customer With given ID not found");
        return customerDao.findById(id).get();
    }
    @GetMapping("/customers/products/{id}")
    public List<Product> getProducts(@PathVariable int id){
        List<Product> byCustomer_id = productDao.findByCustomer_Id(id);
        return byCustomer_id;
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerDao.save(customer);
        return customer;
    }
    @PostMapping("/customers/{id}/product")
    public Product addProduct(@RequestBody Product product, @PathVariable int id){
        Customer temp = customerDao.findById(id).get();
        product.setCustomer(temp);
        productDao.save(product);
        return product;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerDao.delete(customerDao.getById(id));
        return "Customer Deleted";
    }
    @DeleteMapping("/customers/product/{id}")
    public String deleteProduct(@PathVariable int id){
        productDao.delete(productDao.getById(id));
        return "Product Deleted";
    }
    @GetMapping("/customers/like")
    public List<Customer> nameLike(@PathVariable String like){
            return customerDao.findCustomerByFirstName("%"+like+"%");
    }
}
