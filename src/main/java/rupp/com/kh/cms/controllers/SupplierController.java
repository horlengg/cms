package rupp.com.kh.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.services.SupplierService;

@Controller
@RequestMapping("supplier")
public class SupplierController {
    @Autowired SupplierService supplierService;

    @GetMapping
    public String loadPageCategory(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        model.addAttribute("supplierDTOs", supplierService.retrieveAllSupplier());
        model.addAttribute("principal", principal);
        return "pages/page-supplier";
    }
    
}
