package rupp.com.kh.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.services.CategoryService;

/**
 * CategoryController
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired CategoryService categoryService;

    @GetMapping
    public String loadPageCategory(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        model.addAttribute("categories", categoryService.retrieveAllCategoey());
        model.addAttribute("principal", principal);
        return "pages/page-category";
    }
    
}