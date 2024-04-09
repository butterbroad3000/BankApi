package com.example.bankcourse.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public record Rate(
  int Cur_ID,
  LocalDateTime Date,
  double Cur_OfficialRate) {
}