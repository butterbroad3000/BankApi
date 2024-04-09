package com.example.bankcourse;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
  @GetMapping("/currencyData")
  public String getCurrencyData(Model model, @RequestParam String currency, @RequestParam String startDate, @RequestParam String endDate) {
//    List<CurrencyData> currencyData = currencyService.getCurrencyData(currency, startDate, endDate);
//    model.addAttribute("currencyData", currencyData);
    return "currencyData";
  }
}
