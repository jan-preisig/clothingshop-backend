package com.netcetera.clothingshop.picture;

import java.io.IOException;

import com.netcetera.rest.WebServiceUrl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = WebServiceUrl.Image)
@RestController
public class ImageController {

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(
            @RequestParam(value = "imageName") final String imageName
    ) throws IOException {

        ClassPathResource imageFile = new ClassPathResource("image/"+ imageName );

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imageFile.getInputStream()));
    }
}