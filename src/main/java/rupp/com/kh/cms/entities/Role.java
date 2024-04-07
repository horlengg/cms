package rupp.com.kh.cms.entities;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
    ADMIN{
        @Override
        public List<GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
    },
    CASHIER{
        @Override
        public List<GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE_STAFF"));
        }
    };
    // CUSTOMER{
    //     @Override
    //     public List<GrantedAuthority> getAuthorities() {
    //         return List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
    //     }
    // };
    public abstract List<GrantedAuthority> getAuthorities();
}
