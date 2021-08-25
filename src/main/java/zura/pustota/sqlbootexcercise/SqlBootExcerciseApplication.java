package zura.pustota.sqlbootexcercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zura.pustota.sqlbootexcercise.dao.CustomerDao;
import zura.pustota.sqlbootexcercise.dao.MyService;
import zura.pustota.sqlbootexcercise.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SqlBootExcerciseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SqlBootExcerciseApplication.class, args);
        MyService bean = context.getBean(MyService.class);
        List<Customer> like = bean.findLike("%Zura%");
        System.out.println(like);
    }

}
