package rupp.com.kh.cms.services.impl;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import rupp.com.kh.cms.services.FileUploadService;

@SuppressWarnings("deprecation")
@Service
public class FileUploadServiceImpl implements FileUploadService{

    private String FOLDER_ID = "1zMadfUpW7RkpL6Q-qxN1skPsmmGZzRnP";
    private String GOOLE_IMAGE_PREVIEW = "https://drive.google.com/thumbnail?id=";
    private final String DEFAULT_EMPLOYEE_PROFILE = "https://drive.google.com/thumbnail?id=1-YNn0imkZlYy2R181VtzzDPamd6Ft-ci";
    
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACOUNT_KEY_PATH = getPathToGoodleCredentials();

    private static String getPathToGoodleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory, "cred.json");
        return filePath.toString();
    }


    private Drive createDriveService() throws GeneralSecurityException, IOException {

        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .build();

    }
    
    @Override
    public String uploadToGoogleDrive(File file) {
        String URI = null;
        try{
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(file.getName());
            fileMetaData.setParents(Collections.singletonList(FOLDER_ID));
            FileContent mediaContent = new FileContent("image/jpeg", file);
            com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
                    .setFields("id").execute();
            file.delete();
            URI = GOOLE_IMAGE_PREVIEW + uploadedFile.getId();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return URI;
    }


    @Override
    public void deleteFileOnGoogleDrive(String fileId) throws Exception {
        Drive drive = createDriveService();
        drive.files().delete(fileId).execute();
    }


    @Override
    public Boolean hasDefaultProfileURI(String URI) {
        return URI.equals(DEFAULT_EMPLOYEE_PROFILE);
    }


    @Override
    public String getDefaultProfileImageURI() {
        return DEFAULT_EMPLOYEE_PROFILE;
    }


    @Override
    public String getProfileId(String URI) {
        return URI.substring(URI.indexOf("id=") + 3);
    }
    
}
