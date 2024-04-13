package com.example.bankcourse.Controllers;

import com.example.bankcourse.CurrencyService;
import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

  private final CurrencyService currencyService;

  @Operation(description = "This method return dynamics of selected currency,difference between dates must not be more then 365 days.Minimal date of start is 01.01.1991.Max date is current day")
  @PostMapping("rate/dynamics")
  public List<Rate> getRateDynamics(@RequestBody RateDynamicsRequest request) throws ParseException {
    return currencyService.getRateDynamics(request);
  }

  @Operation(description = "This method return list of all available currencies")
  @GetMapping("/currencies")
  public List<Currency> getCurrencies() {
    return currencyService.getCurrencies();
  }

  @Operation(description = "This method return list of all currencies with selected abbreviation")
  @GetMapping("/currenciesby/{abb}")
  public List<Currency> getCurrenciesById(@PathVariable String abb) {
    return currencyService.getCurrenciesByAbbreviation(abb);
  }
}

