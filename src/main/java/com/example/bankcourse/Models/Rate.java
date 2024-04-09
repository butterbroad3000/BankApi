package com.example.bankcourse.Models;

import java.time.LocalDateTime;

public record Rate(
  int Cur_ID,
  LocalDateTime Date,
  double Cur_OfficialRate) {
}