package com.example.bankcourse.Models;

import java.util.Date;

public record Currency(
  int Cur_ID,
  int Cur_ParentID,
  String Cur_Code,
  String Cur_Abbreviation,
  String Cur_Name,
  String Cur_Name_Bel,
  String Cur_Name_Eng,
  String Cur_QuotName,
  String Cur_QuotName_Bel,
  String Cur_QuotName_Eng,
  String Cur_NameMulti,
  String Cur_Name_BelMulti,
  String Cur_Name_EngMulti,
  int Cur_Scale,
  int Cur_Periodicity,
  Date Cur_DateStart,
  Date Cur_DateEnd
) {}