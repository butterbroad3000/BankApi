package com.example.bankcourse;

import com.example.bankcourse.Feign.NbrbClient;
import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
  private final NbrbClient nbrbClient;

  public List<Rate> getRateDynamics(RateDynamicsRequest request) {

    List<Currency> currencies = nbrbClient.getCurrencies();

    Currency currency = currencies.stream()
      .filter(c -> c.Cur_Abbreviation().equals(request.currencyAbbreviation()))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("No such currency abbreviation: " + request.currencyAbbreviation()));

    List<Currency> relevantCurrencies = currencies.stream()
      .filter(c -> c.Cur_ParentID() == currency.Cur_ID())
      .toList();

    List<Rate> rates = new ArrayList<>();

    for (Currency relevantCurrency : relevantCurrencies) {
      rates.addAll(nbrbClient.getRateDynamics(relevantCurrency.Cur_ID(), request.startDate(), request.endDate()));
    }

    return rates;
  }
  public List<Currency> getCurrencies(){
    return nbrbClient.getCurrencies();
  }
}
