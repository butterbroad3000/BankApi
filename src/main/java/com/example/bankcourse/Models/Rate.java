package com.example.bankcourse.Models;

import java.math.BigDecimal;
import java.util.Date;

public record Rate(
  int Cur_ID,
  Date date,
  String Cur_Abbreviation,
  int Cur_Scale,
  String Cur_Name,
  BigDecimal Cur_OfficialRate
) {}