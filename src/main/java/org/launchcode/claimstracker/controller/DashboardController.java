package org.launchcode.claimstracker.controller;

import org.launchcode.claimstracker.models.Claim;
import org.launchcode.claimstracker.models.User;
import org.launchcode.claimstracker.services.ClaimService;
import org.launchcode.claimstracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.Gson;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import java.util.*;


@Controller
public class DashboardController {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private UserService userService;

    private static final String userSessionKey = "user";

    @GetMapping("dashboard")
    public String dashboard(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        User user = (User) userService.findById(userId);
        List<Claim> claims = user.getClaims();

        if (claims == null) {
            model.addAttribute("title", "No claims yet");
        } else {
 //           model.addAttribute("chartClaimData", user.claimsToJson());
            model.addAttribute("claim", claims);
            model.addAttribute("username", user.getFirstName());
        }

        return "dashboard"; }




}
