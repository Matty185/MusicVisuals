package example;

import ie.tudublin.*;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    private int currentState;
    private float lerpedAmplitude;

    public void settings() {
        size(1024, 500);
    }

    public void setup() {
        startMinim();
        currentState = 0;

        loadAudio("Vegeta x Awaken Rare Hardstyle (AniLifts Remix).mp3");
        getAudioPlayer().play();

        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);

        lerpedAmplitude = 0;
    }

    public void keyPressed() {
        if (currentState == 0) {
            switch (key) {
                case '1':
                    currentState = 1;
                    break;
            }
        } else {
            switch (key) {
                case ' ':
                    if (getAudioPlayer().isPlaying()) {
                        getAudioPlayer().pause();
                    } else {
                        getAudioPlayer().play();
                    }
                    break;
                case '0':
                    currentState = 0;
                    break;
            }
        }
    }

    public void draw() {
        background(0);

        if (currentState == 0) {
            calculateAverageAmplitude();
            float amplitude = getAmplitude();

          
            lerpedAmplitude = lerp(lerpedAmplitude, amplitude, 0.1f);

            textSize(32);

            
            int colorValue = (int)map(lerpedAmplitude, 0, 1, 0, 255);
            fill(colorValue, 255 - colorValue, colorValue); 

           
            float yBase = 150;
            float jumpHeight = 150 * lerpedAmplitude;

            text("Menu:", 100, yBase - jumpHeight - 50);
            text("1. Start Visualization", 100, yBase - jumpHeight);
            text("Press 'Space' to pause", 100, yBase - jumpHeight + 50);
            text("Press 'R' to restart", 100, yBase - jumpHeight + 100);
        } else if (currentState == 1) {
            try {
                calculateFFT();
            } catch (VisualException e) {
                e.printStackTrace();
            }
            calculateFrequencyBands();
            calculateAverageAmplitude();
            wf.render();
            abv.render();
        }
    }
}
