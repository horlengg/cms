package rupp.com.kh.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired ProductService productService;

    @GetMapping
    public String loadPageProduct(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        model.addAttribute("productDTOs", productService.retrieveAllProduct());
        model.addAttribute("principal", principal);
        return "pages/page-product";
    }
    
}
