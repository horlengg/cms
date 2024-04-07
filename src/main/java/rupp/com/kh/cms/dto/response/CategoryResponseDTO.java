package rupp.com.kh.cms.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    
}
