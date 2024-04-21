package C21473436;

public class MattysVisual extends Visual {
    CubeVisual cube;
    SmallCubes sc;
    StarfieldVisual starfield;
    BoxVisual box;

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
        sc = new SmallCubes(this);

        starfield = new StarfieldVisual(this, 1000); // Adjust number of stars as needed
        box = new BoxVisual(this);

        currentState = 1;
    }

    public void mouseDragged() {
        cube.updateRotation(0.01f);
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == RIGHT) {
                currentState = (currentState % 3) + 1;
            } else if (keyCode == LEFT) {
                currentState = (currentState == 1) ? 3 : currentState - 1;
            }
        }
    }

    public void draw() {
        background(0);
        calculateAverageAmplitude();
        lerpedAmplitude = lerp(lerpedAmplitude, getAmplitude(), 0.2f);
        
        switch (currentState) {
            case 1:
                cube.render(lerpedAmplitude);
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

        float textSize = map(lerpedAmplitude, 0, 1, 16, 32);
        int textColor = lerpColor(color(255), color(0, 0, 0), getAmplitude());
    
        fill(textColor);
        textSize(textSize + (textSize * lerpedAmplitude));
        textAlign(CENTER, CENTER);
        text(audioFileName, width / 2, height - 30);
        text("Use LEFT and RIGHT arrows to switch screens", width / 2, height - 50);
    }
    
}
