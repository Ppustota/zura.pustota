package zura.pustota.sqlbootexcercise.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zura.pustota.sqlbootexcercise.entity.Customer;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class MyService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findLike(String like){
        return customerDao.findCustomerByFirstName(like);
    }
}
