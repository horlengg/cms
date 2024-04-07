package rupp.com.kh.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("error.html")
    public String loadErrorPage(){
        return "pages/page-error";
    }


    
    
}
