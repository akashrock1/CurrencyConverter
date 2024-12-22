package ext.spring.CurrencyConverter.Services;


import ext.spring.CurrencyConverter.DTO.ConverterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;

@Service
public class ConverterService {

    @Autowired
    private RestClient restClient;

    Logger log= LoggerFactory.getLogger(ConverterService.class);

    public ConverterDTO getConversion(String fromCurrency, String toCurrency, Long units) {
        log.info("Executing the getConversion() Method ");
        HashMap<String, HashMap<String, Double>> data;
        try {
            data = restClient.get()
                    .uri("/latest?apikey=fca_live_nQ2HdJdfnga2rq7r0nZFvNYqQpJmY0r8L9uEo93L&currencies=" + toCurrency + "&base_currency=" + fromCurrency)
                    .retrieve().body(new ParameterizedTypeReference<>() {
                    });

            double lr=data.get("data").get(toCurrency)*units;

            log.info("Successfully fetched the Conversion Data .");

            return ConverterDTO.builder().result(lr).build();
        }
        catch (Exception ex){
            throw new RuntimeException("Api failed to fetch Data .");
        }
//
//        if(data.get("data")!=null){
//            double lr=data.get("data").get(toCurrency)*units;
//            return ConverterDTO.builder().result(lr).build();
//        }
//        return null;

    }
}
