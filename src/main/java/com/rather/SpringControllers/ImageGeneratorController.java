package com.rather.SpringControllers;

import com.rather.UsingAI.ImageGeneration.GenerateImageRequest;
import com.rather.UsingAI.ImageGeneration.GenerateImageResponse;
import com.rather.UsingAI.ImageGeneration.Interfaces.ImageGeneratorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageGeneratorController {
    private static final Logger LOG = LoggerFactory.getLogger(ImageGeneratorController.class);

    private final ImageGeneratorService imageGeneratorService;

    @PostMapping("generate")
    public ResponseEntity<GenerateImageResponse> generateImage(@Valid @RequestBody final GenerateImageRequest request) {
        LOG.info("Received image generation request: {}", request);
        final GenerateImageResponse response = imageGeneratorService.generateImage(request);
        LOG.info("Generated image: {}", response);
        return ResponseEntity.ok(response);
    }
}
