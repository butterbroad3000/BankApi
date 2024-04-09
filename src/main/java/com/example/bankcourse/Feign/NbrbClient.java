package com.example.bankcourse.Feign;


import com.example.bankcourse.Models.Currency;
import com.example.bankcourse.Models.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nbrbClient", url = "${api.url}")
public interface NbrbClient {
  @GetMapping("/exrates/currencies")
  List<Currency> getCurrencies();

  @GetMapping("/exrates/rates/{cur_id}")
  Rate getRate(@PathVariable("cur_id") int curId);

  @GetMapping("/exrates/rates/dynamics/{cur_id}")
  List<Rate> getRateDynamics(@PathVariable("cur_id") int curId, @RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate);
}
