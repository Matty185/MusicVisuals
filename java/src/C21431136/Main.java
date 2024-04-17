package C21431136;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new DanielsVisual());
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}