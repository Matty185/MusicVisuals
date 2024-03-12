package example;

import ie.tudublin.*;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    // Variable to manage the current state of the application (menu or visualization)
    private int currentState;

    public void settings() {
        size(1024, 500);
    }

    public void setup() {
        startMinim();
        // Initially, set the state to show the menu
        currentState = 0; // 0 for menu, 1 for visualization

        loadAudio("Vegeta x Awaken Rare Hardstyle (AniLifts Remix).mp3");

        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
    }

    public void keyPressed() {
        if (currentState == 0) { // When in menu
            switch (key) {
                case '1':
                    // Switch to visualization
                    currentState = 1;
                    break;
                // Implement other cases if needed
            }
        } else { // When in visualization or other states
            switch (key) {
                case ' ':
                    // Toggle play/pause
                    if (getAudioPlayer().isPlaying()) {
                        getAudioPlayer().pause();
                    } else {
                        getAudioPlayer().play();
                    }
                    break;
                case '0':
                    // Return to menu and stop music
                    currentState = 0;
                    getAudioPlayer().pause(); // Use pause() or stop() depending on your need
                    getAudioPlayer().cue(0); // Rewind to the start of the track
                    break;
                case 'r':
                    // Add functionality for 'r' if needed
                    break;
            }
        }
    }

    public void draw() {
        if (currentState == 0) {
            // Display menu
            background(50);
            textSize(32);
            fill(255);
            text("Menu:", 100, 100);
            text("1. Start Visualization", 100, 150);
            text("Press 'Space' to pause", 100, 200);
            text("Press 'R' to restart", 100, 250);
            // Add other menu options if necessary
        } else if (currentState == 1) {
            // Visualization
            background(0);
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
