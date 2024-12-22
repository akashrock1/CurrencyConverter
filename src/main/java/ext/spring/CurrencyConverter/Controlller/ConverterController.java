package ext.spring.CurrencyConverter.Controlller;


import ext.spring.CurrencyConverter.DTO.ConverterDTO;
import ext.spring.CurrencyConverter.Services.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertCurrency")
public class ConverterController {

    private final ConverterService converterServ;

    public ConverterController(ConverterService converterServ) {
        this.converterServ = converterServ;
    }

    @GetMapping
    public ConverterDTO getConversion(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam Long units){

        return converterServ.getConversion(fromCurrency,toCurrency,units);

    }


}
