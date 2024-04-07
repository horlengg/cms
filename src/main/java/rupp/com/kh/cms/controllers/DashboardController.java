
package rupp.com.kh.cms.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.dto.response.OrderDetailResponse;
import rupp.com.kh.cms.services.DashboardService;

/**
 * DashboardController
 */
@Controller
public class DashboardController {

    @Autowired DashboardService dashboardService;
    
    
    
    @GetMapping("/")
    public String loadPageDashboard(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        List<OrderDetailResponse> ordersList = new ArrayList<>();
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        ordersList.add(new OrderDetailResponse("Ly Horleng",LocalDate.now().toString(),2,5));
        model.addAttribute("orderList", ordersList);
        model.addAttribute("totalProducts", dashboardService.retrieveTotalProducts());
        model.addAttribute("totalCategories", dashboardService.retrieveTotalCategories());
        model.addAttribute("totalSuppliers", dashboardService.retrieveTotalSupplier());
        model.addAttribute("totalUsers", dashboardService.retrieveTotalUsers());
        model.addAttribute("totalEmployees", dashboardService.retrieveTotalEmployees());
        model.addAttribute("principal", principal);
        return "pages/page-dashboard";
    }

    
}