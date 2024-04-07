package rupp.com.kh.cms.exceptions;

public class BadRequestException  extends RuntimeException{
    
    private String backUrl;
    public BadRequestException(String message,String backUrl) {
        super(message);
        this.backUrl = backUrl;
    }
    public String getBackUrl() {
        return backUrl;
    }
    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }
    
}
