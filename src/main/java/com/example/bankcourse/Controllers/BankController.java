package com.example.bankcourse.Controllers;

import com.example.bankcourse.CurrencyService;
import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

  private final CurrencyService currencyService;

  @PostMapping("rate/dynamics")
  public List<Rate> getRateDynamics(@RequestBody RateDynamicsRequest request) {
    return currencyService.getRateDynamics(request);
  }
}

