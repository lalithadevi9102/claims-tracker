package org.launchcode.claimstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller

public class HomeController {
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
