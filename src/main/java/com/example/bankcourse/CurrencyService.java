package com.example.bankcourse;

import com.example.bankcourse.Feign.NbrbClient;
import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import com.example.bankcourse.Models.Request.RateDynamicsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
  private final NbrbClient nbrbClient;

  public List<Currency> getCurrencies() {
    return nbrbClient.getCurrencies();
  }

  public List<Currency> getCurrenciesByAbbreviation(String abb) {
    List<Currency> currencies = getCurrencies();

    return
      currencies.stream()
        .filter(currency -> currency.Cur_Abbreviation().equals(abb))
        .toList();
  }
  public List<Rate> getRateDynamics(RateDynamicsRequest request) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = format.parse(request.startDate());
    Date endDate = format.parse(request.endDate());

    List<Currency> currenciesByAbb = getCurrenciesByAbbreviation(request.currencyAbbreviation());
    List<Rate> rates = new ArrayList<>();

    for (Currency currency : currenciesByAbb) {
      if (!currency.Cur_DateStart().after(endDate) && !currency.Cur_DateEnd().before(startDate)) {
        Date rateStartDate = currency.Cur_DateStart().after(startDate) ? currency.Cur_DateStart() : startDate;
        Date rateEndDate = currency.Cur_DateEnd().before(endDate) ? currency.Cur_DateEnd() : endDate;

        rates.addAll(nbrbClient.getRateDynamics(currency.Cur_ID(), format.format(rateStartDate), format.format(rateEndDate)));
      }
    }

    return rates;
  }
}