package rupp.com.kh.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.services.UserService;

@Controller
public class AuthController {

    @Autowired UserService userService;


    @GetMapping("/user")
    public String loadPageUser(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        model.addAttribute("listUser", userService.retrieveAllUser());
        model.addAttribute("principal", principal);
        return "pages/page-user";
    }

    @GetMapping("/login")
    public String loadPageLogin(){
        return "pages/page-login";
    }
    
}
