package com.rather;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<JavaFxApplication.StageReadyEvent> {
    @Override
    public void onApplicationEvent(JavaFxApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(StageInitializer.class.getResource("/fxml/main-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 859, 693);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("TableParser");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
