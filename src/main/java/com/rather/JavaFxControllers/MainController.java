package com.rather.JavaFxControllers;

import com.rather.UsingAI.ImageGeneration.GenerateImageRequest;
import com.rather.UsingAI.ImageGeneration.GenerateImageResponse;
import com.rather.UsingAI.ImageGeneration.ImageGeneratorServiceImpl;
import com.rather.UsingAI.ImageGeneration.Interfaces.ImageGeneratorClient;
import io.github.jetkai.openai.api.CreateImage;
import io.github.jetkai.openai.api.data.image.ImageData;
import io.github.jetkai.openai.openai.OpenAI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class MainController {
    @FXML
    private ImageView questionImageView;
    @FXML
    private Button questionButton;

    @FXML
    public void initialize() {
        questionButton.setOnAction(actionEvent -> {
            //Initialize ExampleImageCreation class
            //ImageView imageCreation = new ImageView();

            //A text description of the desired image(s). The maximum length is 1000 characters
            String description = "A picture of a red panda with glasses, drawn as a cartoon.";

            //The number of images to generate. Must be between 1 and 10.
            int amount = 1;

            //The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024
            String size = "1024x1024";

            URI[] imageLinks = communicate(description, amount, size);

            for(URI imageLink : imageLinks) {
                System.out.println("Opening URI ["+imageLink+"] in the web browser.");
                try {
                    Desktop.getDesktop().browse(imageLink);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }

    private URI[] communicate(String imageDescription, int numberOfImages, String size) {
        //Alternatively can use ImageData.create(imageDescription, numberOfImages, size);
        ImageData imageData = ImageData.builder()
                //A text description of the desired image(s). The maximum length is 1000 characters
                .setPrompt(imageDescription)
                //The number of images to generate. Must be between 1 and 10.
                .setN(numberOfImages)
                //The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024
                .setSize(size)
                .build();

        System.out.println(OpenAI.builder());

        OpenAI openAI = OpenAI.builder()
                //Set our OpenAI API key
                .setApiKey(System.getenv("TOKEN"))
                //Specify the createImage API endpoint
                .createImage(imageData)
                .build()
                //Sends the request to OpenAI's endpoint & parses the response data
                .sendRequest();

        //Call the CreateImage API from OpenAI & create instance
        Optional<CreateImage> createImage = openAI.image();

        //Gather the URI(s) from the API response
        return createImage.map(CreateImage::asUriArray).orElse(null);
    }
}
