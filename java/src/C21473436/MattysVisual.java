package C21473436;

// Extends Visual to get drawing and audio methods
public class MattysVisual extends Visual {
    // Declare objects used in program
    CubeVisual cube;
    SmallCubes sc;
    StarfieldVisual starfield;
    BoxVisual box;

    private int currentState; // Manage different states
    private String audioFileName = "Vegeta x Awaken Rare Hardstyle (AniLifts Remix).mp3"; // Audio file
    private float lerpedAmplitude; // Smoothed amplitude value 

    // Window size and rendering mode
    public void settings() {
        fullScreen(P3D); // Set the program to run in full screen using P3D renderer
    }

    public void setup() {
        startMinim(); // Start audio processing library
        loadAudio(audioFileName); // Load audio
        getAudioPlayer().play(); // Play audio
        cube = new CubeVisual(this); // Initialise our objects
        sc = new SmallCubes(this);

        starfield = new StarfieldVisual(this, 1000); 
        box = new BoxVisual(this);

        currentState = 1; // Declare starting state
    }

    // Update cube rotation on mouse drag
    public void mouseDragged() {
        cube.updateRotation(0.01f);
    }

    // Change visual displayed with keyboard input
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == RIGHT) {
                currentState = (currentState % 3) + 1;
            } else if (keyCode == LEFT) {
                currentState = (currentState == 1) ? 3 : currentState - 1;
            } 
        }
    }

    // Render visuals
    public void draw() {
        background(0); // Set background colour to black
        calculateAverageAmplitude(); // Avg amplitude
        lerpedAmplitude = lerp(lerpedAmplitude, getAmplitude(), 0.2f);
        
        // Switch case to render visuals 
        switch (currentState) {
            case 1:
                cube.render(lerpedAmplitude); // 
                break;
            case 2:
                cube.render(lerpedAmplitude);
                sc.render(lerpedAmplitude);
                break;
            case 3:
                starfield.render(lerpedAmplitude);
                box.render(lerpedAmplitude);
                break;
            default:
                break;
        }

        float textSize = map(lerpedAmplitude, 0, 1, 16, 32); // Adjust text size on amplitude
        int textColor = lerpColor(color(255), color(0, 0, 0), getAmplitude()); // Adjust text color 
        fill(textColor); // Fill text with color
        textSize(textSize + (textSize * lerpedAmplitude)); 
        textAlign(CENTER, CENTER); // Align text to centre 
        text(audioFileName, width / 2, height - 30); // Show name of song
        text("Use LEFT and RIGHT arrows to switch screens", width / 2, height - 50); // Show text
    }
    
}
