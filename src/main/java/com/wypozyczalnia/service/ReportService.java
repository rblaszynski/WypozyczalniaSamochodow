package com.wypozyczalnia.service;

import com.wypozyczalnia.model.RaportSamochodu;
import com.wypozyczalnia.model.RaportUzytkownika;

import java.util.List;

public interface ReportService {

    List<RaportUzytkownika> getRaportUzytkownika(String id);
    List<RaportSamochodu> getRaportSamochodu(String id);
}
