package com.example.bankcourse.Controllers;

import com.example.bankcourse.CurrencyService;
import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

  private final CurrencyService currencyService;

  @PostMapping("rate/dynamics")
  public List<Rate> getRateDynamics(@RequestBody RateDynamicsRequest request) throws ParseException {
    return currencyService.getRateDynamics(request);
  }
  @GetMapping("/currencies")
  public List<Currency> getCurrencies(){
    return currencyService.getCurrencies();
  }
  @GetMapping("/currenciesby/{abb}")
  public List<Currency> getCurrenciesById(@PathVariable String abb){
    return currencyService.getCurrenciesByAbbreviation(abb);
  }
}

