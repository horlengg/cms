package rupp.com.kh.cms.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private String backUrl;
    public ResourceNotFoundException(String message,String backUrl) {
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
