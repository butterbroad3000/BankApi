package com.example.bankcourse.Models.Request;

import lombok.NonNull;

public record RateDynamicsRequest(

  String currencyAbbreviation,
  String startDate,
  String endDate
) {
}
