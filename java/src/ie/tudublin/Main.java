package ie.tudublin;

import C21473436.MattysVisual;
import example.CubeVisual;
import example.CubeVisual1;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new MattysVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}