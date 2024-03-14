package C21473436;

public class MattysVisual extends Visual {
    CubeVisual cube;

    private int currentState;
    private String audioFileName = "Vegeta x Awaken Rare Hardstyle (AniLifts Remix).mp3";
    private float lerpedAmplitude;

    public void settings() {
        size(1024, 500, P3D);
    }

    public void setup() {
        startMinim();
        loadAudio(audioFileName);
        getAudioPlayer().play();
        cube = new CubeVisual(this);

        currentState = 1;
    }

    public void mouseDragged() {
        cube.updateRotation(0.01f);
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == RIGHT) {
                currentState = (currentState % 2) + 1;
            } else if (keyCode == LEFT) {
                currentState = (currentState == 1) ? 2 : 1;
            }
        }
    }

    public void draw() {
        background(0);
        calculateAverageAmplitude();
        lerpedAmplitude = lerp(lerpedAmplitude, getAmplitude(), 0.2f);
    
        if (currentState == 1) {
            cube.render(lerpedAmplitude);
        }

        float textSize = map(lerpedAmplitude, 0, 1, 16, 32);
        int textColor = lerpColor(color(255), color(0, 0, 0), getAmplitude());
    
        fill(textColor);
        textSize(textSize);
        textAlign(CENTER, CENTER);
        text(audioFileName, width / 2, height - 30);
        text("Use LEFT and RIGHT arrows to switch screens", width / 2, height - 50);
    }
    
}
