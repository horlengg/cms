package rupp.com.kh.cms.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class CustomExceptionHandler {

    // @ExceptionHandler(Exception.class)
    // public String handleGlobalException(Exception ex,RedirectAttributes attributes) {
    //     attributes.addFlashAttribute("errorMessage", ex.getMessage());
    //     attributes.addFlashAttribute("backUrl", "");
    //     return "redirect:/error.html";
    // }
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex,RedirectAttributes attributes) {
        attributes.addFlashAttribute("errorMessage", ex.getMessage());
        attributes.addFlashAttribute("backUrl", ex.getBackUrl());
        return "redirect:/error.html";
    }

}
