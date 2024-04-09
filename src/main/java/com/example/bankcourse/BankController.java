package com.example.bankcourse;

import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

  private final CurrencyService currencyService;

  @GetMapping("/rate/dynamics")
  public List<Rate> getRateDynamics(@RequestBody RateDynamicsRequest request) {
    return currencyService.getRateDynamics(request);
  }
}

