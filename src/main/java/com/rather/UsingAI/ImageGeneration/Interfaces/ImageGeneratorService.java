package com.rather.UsingAI.ImageGeneration.Interfaces;

import com.rather.UsingAI.ImageGeneration.GenerateImageRequest;
import com.rather.UsingAI.ImageGeneration.GenerateImageResponse;

public interface ImageGeneratorService {
    GenerateImageResponse generateImage(GenerateImageRequest generateImageRequest);
}
