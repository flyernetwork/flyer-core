package br.com.flyernetwork.core.flyercore.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.amazonaws.services.s3.model.PutObjectResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.flyernetwork.core.flyercore.service.AmazonService;

@RequestMapping("/file/image")
@CrossOrigin("*")
@RestController
public class ImageResource {

    @Autowired
    private AmazonService amazonClient;

    @Autowired
    ImageResource(AmazonService amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/user")
    ResponseEntity<?> uploadUserPicture(@RequestParam("image") MultipartFile multipartFile) {
        try {
            File convFile = new File(multipartFile.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipartFile.getBytes());
            fos.close();

            PutObjectResult result = this.amazonClient.uploadFileToS3Bucket(convFile);
            
            convFile.delete();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

}
