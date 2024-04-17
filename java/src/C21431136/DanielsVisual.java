package C21431136;

import C21473436.Visual;
import processing.core.PVector;

public class DanielsVisual extends Visual {
    boolean twocubes = false;

    float smoothedBoxSize = 0;
    PVector[] stars = new PVector[1000]; // Adjust number of stars as needed

    public void settings() {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }
    
    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

        }
        if (key == '1') {
            twocubes = !twocubes;

        }
    }

    public void setup() {
        colorMode(HSB);
        noCursor();

        setFrameSize(256);

        startMinim();
        loadAudio("ready_to_flow.mp3");

        // Initialize stars
        for (int i = 0; i < stars.length; i++) {
            // Random positions for stars
            stars[i] = new PVector(random(-width * 2, width * 2), random(-height * 2, height * 2), random(-500, 500));
        }
    }

    public void drawStars() {
        // Draw stars
        stroke(255); // White color for stars
        strokeWeight(4); // Star size
        for (PVector star : stars) {
            pushMatrix(); // Save the current transformation matrix
            translate(star.x, star.y, star.z); // Move to the star's location
            point(0, 0); // Draw a point at the translated location
            popMatrix(); // Restore the original transformation matrix
            
            // Adjust the star's z position to simulate movement towards the viewer
            star.z += map(getSmoothedAmplitude(), 0, 1, 2, 20); // Speed based on amplitude
            
            // If the star moves past the viewer, reset its position to the far plane
            if (star.z > 500) {
                star.z = -500;
                star.x = random(-width * 2, width * 2);
                star.y = random(-height * 2, height * 2);
            }
        }
    }

    void drawBackground() {
        // Use smoothed amplitude to determine color
        float hue = map(getSmoothedAmplitude(), 0, 1, 0, 255);
        background(hue, 255, 255);
    }
    

    public void draw() {

        // drawBackground();
        calculateAverageAmplitude();
        background(3);
        noFill();
        lights();
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        // Render the starfield
        pushMatrix();
        translate(width / 2, height / 2);
        drawStars();
        popMatrix();

        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        float boxSize = 50 + (getAmplitude() * 300);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);


        rotateY(angle);
        rotateX(angle);
        strokeWeight(5);
        box(smoothedBoxSize);
        
        // Draw vertical lines
        strokeWeight(2); // Thinner lines for the edges
        float halfBox = smoothedBoxSize / 2; // Half the size of the box

        // Define the number of lines per face
        int linesPerFace = 4; 

        // Draw lines on each face
        // Correct approach to draw lines on the top and bottom faces
        for (int i = 0; i <= linesPerFace; i++) {
            float offsetX = map(i, 0, linesPerFace, -halfBox, halfBox); // Horizontal offset for lines on the top and bottom faces

            // Top face (keeping Z constant at halfBox)
            line(offsetX, -halfBox, halfBox, offsetX, halfBox, halfBox); // Span across X, top face
            
            // Bottom face (keeping Z constant at -halfBox)
            line(offsetX, -halfBox, -halfBox, offsetX, halfBox, -halfBox); // Span across X, bottom face
        }

        for (int j = 0; j <= linesPerFace; j++) {
            float offsetY = map(j, 0, linesPerFace, -halfBox, halfBox); // Vertical offset for lines on the top and bottom faces

            // Top face (keeping Z constant at halfBox, span across Y)
            line(-halfBox, offsetY, halfBox, halfBox, offsetY, halfBox);
            
            // Bottom face (keeping Z constant at -halfBox, span across Y)
            line(-halfBox, offsetY, -halfBox, halfBox, offsetY, -halfBox);
        }
        
        angle += 0.01f;
    }

    float angle = 0;
}