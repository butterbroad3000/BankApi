package com.example.bankcourse;

import com.example.bankcourse.Feign.NbrbClient;
import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

  @Service
  @RequiredArgsConstructor
  public class CurrencyService {
    private final NbrbClient nbrbClient;

    public List<Rate> getRateDynamics(String currencyCode, String startDate, String endDate) {
      // Получаем все валюты на начало интересующего периода
      List<Currency> currencies = nbrbClient.getCurrencies();

      // Находим объект, описывающий интересующую нас валюту
      Currency currency = currencies.stream()
        .filter(c -> c.Cur_Abbreviation().equals(currencyCode))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid currency code: " + currencyCode));

      // Получаем данные о динамике курса валюты для каждого из найденных объектов с учетом периода их действия
      return nbrbClient.getRateDynamics(currency.Cur_ID(), startDate, endDate);
    }
  }


