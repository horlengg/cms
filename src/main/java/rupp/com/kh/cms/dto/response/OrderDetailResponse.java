package rupp.com.kh.cms.dto.response;

// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor()
// @Builder
public class OrderDetailResponse {

    private String customerName;
    private String dateTime;
    private Integer totalItem;
    private Integer amount;

    public OrderDetailResponse(){}
    
    public OrderDetailResponse(String customerName, String dateTime, Integer totalItem, Integer amount) {
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.totalItem = totalItem;
        this.amount = amount;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public Integer getTotalItem() {
        return totalItem;
    }
    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    

}
