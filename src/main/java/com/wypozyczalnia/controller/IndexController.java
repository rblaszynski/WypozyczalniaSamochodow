package com.wypozyczalnia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/CarManagement", method = RequestMethod.GET)
    public String getCarManagement() {
        return "CarManagement";
    }

    @RequestMapping(value = "/UserManagement", method = RequestMethod.GET)
    public String getUserManagement() {
        return "UserManagement";
    }

    @RequestMapping(value = "/HireCar", method = RequestMethod.GET)
    public String getHireCar() {
        return "HireCar";
    }

    @RequestMapping(value = "/HireRaport", method = RequestMethod.GET)
    public String getHireRaport() {
        return "HireRaport";
    }
    @RequestMapping(value = "/Queries", method = RequestMethod.GET)
    public String getQueries() {
        return "Queries";
    }

}