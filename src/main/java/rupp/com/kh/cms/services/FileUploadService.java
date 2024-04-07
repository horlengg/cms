package rupp.com.kh.cms.services;

import java.io.File;

public interface FileUploadService {

    String uploadToGoogleDrive(File file);
    void deleteFileOnGoogleDrive(String fileId) throws Exception;
    Boolean hasDefaultProfileURI(String URI);
    String getDefaultProfileImageURI();
    String getProfileId(String URI);
}
