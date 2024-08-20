package com.rather.UsingAI.ImageGeneration;

import com.rather.UsingAI.ImageGeneration.Interfaces.ImageGeneratorClient;
import com.rather.UsingAI.ImageGeneration.Interfaces.ImageGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageGeneratorServiceImpl implements ImageGeneratorService {

    private final ImageGeneratorClient imageGeneratorClient;

    public GenerateImageResponse generateImage(final GenerateImageRequest request) {
        final GenerateImageResponse response = imageGeneratorClient.generateImage(request);
        // if necessary, the response can be further processed here

        return response;
    }

}