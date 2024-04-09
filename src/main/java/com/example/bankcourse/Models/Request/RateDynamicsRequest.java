package com.example.bankcourse.Models.Request;
public record RateDynamicsRequest(

  String currencyAbbreviation,
  String startDate,
  String endDate
) {
}
