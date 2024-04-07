package rupp.com.kh.cms.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import rupp.com.kh.cms.entities.EmployeeEntity;
import rupp.com.kh.cms.entities.Role;

public class CurrentUserDetailDTO extends User {
    
    public CurrentUserDetailDTO(
            String email, 
            String password,
            Collection<? extends GrantedAuthority> authorities
            
    ) {
        super(email, password,authorities);
    }
    private Long id;
    private Role role;
    private EmployeeEntity employee;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public EmployeeEntity getEmployee() {
        return employee;
    }
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    

}
