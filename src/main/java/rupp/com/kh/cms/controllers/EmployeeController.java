package rupp.com.kh.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.dto.EmployeeDTO;
import rupp.com.kh.cms.services.EmployeeService;

import java.util.List;

/**
 * EmployeeController
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired EmployeeService employeeService;

    @GetMapping
    public String loadEmployeePage(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        List<EmployeeDTO> employees =  employeeService.retrieveAllEmployee();
        model.addAttribute("employees",employees);
        model.addAttribute("principal", principal);
        return "pages/page-employee";
    }

    // create employee
    
    @GetMapping("/form")
    public String loadFormCreateEmployee(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model){
        model.addAttribute("formTitle", "Create Employee");
        model.addAttribute("empFormDTO", new EmployeeDTO());
        model.addAttribute("btnName", "Create");
        model.addAttribute("isViewForm", false);
        model.addAttribute("profileImage", "http://localhost:8080/images/default-employee-profile.png");
        model.addAttribute("principal", principal);
        return "pages/form/form-employee";
    }
    
    @PostMapping("/form")
    public String handleCreateEmployee(@RequestParam("profile-image") MultipartFile file,@ModelAttribute EmployeeDTO employee) throws Exception{
        if(employee.getEmpId() != null) {
            employeeService.updateEmployee(employee.getEmpId(),employee,file);
        }else {
            employeeService.createEmployee(employee,file);
        }
        return "redirect:/employee";
    }

    // update employee

    @GetMapping("/form/{empId}")
    public String loadFormUpdateEmployee(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model,@PathVariable Long empId){
        EmployeeDTO empFormDTO = employeeService.retrieveEmployee(empId);
        model.addAttribute("principal", principal);
        model.addAttribute("formTitle", "Update Employee");
        model.addAttribute("empFormDTO", empFormDTO);
        model.addAttribute("btnName", "Update");
        model.addAttribute("isViewForm", false);
        model.addAttribute("profileImage", empFormDTO.getProfileImage());
        return "pages/form/form-employee";
    }
    @GetMapping("/form/view/{empId}")
    public String viewEmployeeDetail(@AuthenticationPrincipal CurrentUserDetailDTO principal,Model model,@PathVariable Long empId){
        EmployeeDTO empFormDTO = employeeService.retrieveEmployee(empId);
        model.addAttribute("formTitle", "Employee Details");
        model.addAttribute("empFormDTO", empFormDTO);
        model.addAttribute("btnName", "");
        model.addAttribute("isViewForm", true);
        model.addAttribute("profileImage", empFormDTO.getProfileImage());
        model.addAttribute("principal", principal);
        return "pages/form/form-employee";
    }

    @GetMapping("/delete/{empId}")
    public String handleDeleteEmployee(Model model,@PathVariable Long empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee";
    }


    
    
}