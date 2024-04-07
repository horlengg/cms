package rupp.com.kh.cms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProResponseDTO {
    private String name;
    private String description;
    private Integer qty;
    private Double unitPrice;
    
}
