package com.diegovilca.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SceneSwitch {
    public SceneSwitch(AnchorPane currentAnchorPane, String xfmlPath) {
        try {
            AnchorPane nextAnchorPane = FXMLLoader.load(ConverterGUI.class.getClassLoader().getResource(xfmlPath));
            currentAnchorPane.getChildren().removeAll();
            currentAnchorPane.getChildren().setAll(nextAnchorPane);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
