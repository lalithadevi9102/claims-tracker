package org.launchcode.claimstracker.controllers;

import org.launchcode.claimstracker.models.Bill;
import org.launchcode.claimstracker.models.User;
import org.launchcode.claimstracker.services.BillService;
import org.launchcode.claimstracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.*;

@Controller
public class DashboardController {

    @Autowired
    private BillService billService;

    @Autowired
    private UserService userService;

    private static final String userSessionKey = "user";

    @GetMapping("dashboard")
    public String dashboard(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        User user = userService.findById(userId);
        List<Bill> bills = user.getBills();

        if (bills == null) {
            model.addAttribute("title", "No bills yet");
        } else {
            model.addAttribute("chartBillData", user.billsToJson());
            model.addAttribute("bill", bills);
            model.addAttribute("username", user.getFirstName());
        }

        return "dashboard"; }

    @GetMapping("create-bill")
    public String createBill() {
        return "bill/create-bill";
    }

    @PostMapping("dashboard")
    public String deleteBill(@RequestParam(required = false) int[] billIds) {

        if (billIds !=null) {
            for (int id : billIds) {
                billService.deleteById(id);
            }
        }
        return "redirect:/dashboard";
    }
}
