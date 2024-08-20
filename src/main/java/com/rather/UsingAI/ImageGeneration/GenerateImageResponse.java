package com.rather.UsingAI.ImageGeneration;

import lombok.Data;
import java.util.List;

@Data
public class GenerateImageResponse {
    private List<GeneratedImage> data;
}