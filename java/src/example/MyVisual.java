package example;

import ie.tudublin.*;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    private int currentState;
    private String audioFileName = "Vegeta x Awaken Rare Hardstyle (AniLifts Remix).mp3";
    private float lerpedAmplitude;

    

    public void settings() {
        size(1024, 500);
    }

    public void setup() {
        startMinim();
        loadAudio(audioFileName);
        getAudioPlayer().play();
    
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
    
        currentState = 1; // Start with WaveForm visualization
    }
    

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == RIGHT) {
                currentState = (currentState % 2) + 1; // Cycle forward through the visualizations
            } else if (keyCode == LEFT) {
                currentState = (currentState == 1) ? 2 : 1; // Cycle backward through the visualizations
            }
        }
    }
    

    public void draw() {
        background(0);
    
        // Process audio for visualization
        calculateAverageAmplitude();
        float amplitude = getAmplitude();
        lerpedAmplitude = lerp(lerpedAmplitude, amplitude, 0.1f); // Smooth the amplitude changes
    
        // Display the selected visualization
        if (currentState == 1) {
            wf.render();
        } else if (currentState == 2) {
            abv.render();
        }
    
        // Dynamic text size based on amplitude
        float textSize = map(lerpedAmplitude, 0, 1, 16, 32); // Adjust min and max text size as needed
    
        // Dynamic text color based on amplitude
        int textColor = lerpColor(color(128), color(255, 0, 0), amplitude); // From white to red
    
        // Display the audio file's name and instructions with dynamic size and color
        fill(textColor);
        textSize(textSize);
        textAlign(CENTER, CENTER);
        text(audioFileName, width / 2, height - 30);
        text("Use LEFT and RIGHT arrows to switch screens", width / 2, height - 50);
    }
    
    
}
