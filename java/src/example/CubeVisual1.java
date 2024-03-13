package example;

import processing.core.PApplet;

public class CubeVisual1 {
    PApplet parent;
    float angleX = 0;
    float angleY = 0;

    public CubeVisual1(PApplet p) {
        parent = p;
    }

    public void render(float amplitude) {
        parent.pushMatrix();
        parent.translate(parent.width / 2, parent.height / 2, -200);
        parent.rotateX(angleX);
        parent.rotateY(angleY);

        float hue = parent.map(amplitude * 25, 0, 1, 0, 255);
        int color = parent.color(hue, 255, 255); 
        parent.stroke(255);
        parent.fill(color);

        float boxSize = 200 + (200 * amplitude);
        parent.box(boxSize);
        parent.popMatrix();
    }

    public void updateRotation(float rate) {
        angleY += (parent.mouseX - parent.pmouseX) * rate;
        angleX += (parent.mouseY - parent.pmouseY) * rate;
    }
}
