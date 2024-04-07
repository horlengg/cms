package rupp.com.kh.cms.dto.response;

import java.util.Date;

import rupp.com.kh.cms.entities.Role;

public class UserResponseDTO {
    private String email;
    private Role role;
    private Date createdAt;
    private Date updatedAt;

    public UserResponseDTO(){}
    
    public UserResponseDTO(String email, Role role, Date createdAt, Date updatedAt) {
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    
}
