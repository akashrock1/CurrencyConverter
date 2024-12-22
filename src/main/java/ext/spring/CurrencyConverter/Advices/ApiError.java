package ext.spring.CurrencyConverter.Advices;


import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ApiError {

    private LocalDateTime currentDate;

    private String error;


    public ApiError(String error) {
        this.currentDate = LocalDateTime.now();
        this.error=error;
    }
}
