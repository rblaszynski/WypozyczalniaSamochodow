package com.wypozyczalnia.service;

import com.wypozyczalnia.dao.JDBCDriver;
import com.wypozyczalnia.model.RaportSamochodu;
import com.wypozyczalnia.model.RaportUzytkownika;
import com.wypozyczalnia.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    private static JDBCDriver jdbcDriver = new JDBCDriver();

    private static List<RaportSamochodu> raportSamochodu = new ArrayList<>();
    private static List<RaportUzytkownika> raportUzytkownika = new ArrayList<>();


    @Override
    public List<RaportUzytkownika> getRaportUzytkownika(String id) {
        raportUzytkownika = jdbcDriver.getClientReport(id);
        return raportUzytkownika;
    }

    @Override
    public List<RaportSamochodu> getRaportSamochodu(String id) {
        raportSamochodu = jdbcDriver.getCarReport(id);
        return raportSamochodu;
    }
}
