package com.bhirava.ovilearning.ui.component.util;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class JLoopVideoPanel extends JFXPanel {
    private static final long serialVersionUID = 1L;

    public JLoopVideoPanel(String vedioPath, int w, int h) {
        final Media m = new Media(vedioPath);
        final MediaPlayer mp = new MediaPlayer(m);
        final MediaView mv = new MediaView(mp);

        final DoubleProperty width = mv.fitWidthProperty();
        final DoubleProperty height = mv.fitHeightProperty();

        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

        mv.setPreserveRatio(false);

        StackPane root = new StackPane();
        root.getChildren().add(mv);

        final Scene scene = new Scene(root, w, h);
        scene.setFill(Color.BLACK);

        setScene(scene);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.setAutoPlay(true);
        mp.setOnEndOfMedia(new Runnable() {

            public void run() {
                mp.play();

            }
        });

        mp.play();
    }
}
