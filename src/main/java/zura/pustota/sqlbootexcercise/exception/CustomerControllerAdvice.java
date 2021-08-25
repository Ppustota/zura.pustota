package zura.pustota.sqlbootexcercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
public class CustomerControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<CustomerNotFoundResponse> customerNotFound(CustomerNotFoundException exception){
        CustomerNotFoundResponse response = new CustomerNotFoundResponse();
        response.setMethod(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
