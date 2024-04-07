package rupp.com.kh.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rupp.com.kh.cms.entities.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long empId;
    private String fullName;
    private Gender gender;
    private String dob;
    private String effectiveDate;
    private String contractEndDate;
    private String phone;
    private String maritalStatus;
    private String idNo;
    private String idType;
    private String presentAddress;
    private String profileImage;
}