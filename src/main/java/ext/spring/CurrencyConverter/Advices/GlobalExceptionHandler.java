package ext.spring.CurrencyConverter.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(RuntimeException ex){
        ApiError er=new ApiError(ex.getMessage());
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND );
    }


}
