package rupp.com.kh.cms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProRequestDTO {
    private String productName;
    private Double unitPrice;
    private Integer qty;
}
