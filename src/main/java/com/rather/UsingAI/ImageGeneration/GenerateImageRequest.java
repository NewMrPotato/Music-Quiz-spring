package com.rather.UsingAI.ImageGeneration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rather.UsingAI.ImageGeneration.Annotations.ValidSize;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GenerateImageRequest {
    @NotBlank
    private String prompt;

    @ValidSize
    private String size;

    @Min(1)
    @Max(10)
    @JsonProperty("num_images")
    private int numImages;
}
