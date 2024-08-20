package com.rather.UsingAI.ImageGeneration.Interfaces;

import com.rather.Configurations.ImageGeneratorConfig;
import com.rather.UsingAI.ImageGeneration.GenerateImageRequest;
import com.rather.UsingAI.ImageGeneration.GenerateImageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "imageGenerator", url = "${openai.image-generator.url}", configuration = ImageGeneratorConfig.class)
public interface ImageGeneratorClient {

    @PostMapping(value = "/v1/images/generations")
    GenerateImageResponse generateImage(@RequestBody final GenerateImageRequest request);

}