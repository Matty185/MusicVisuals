package C21473436;

import processing.core.PApplet;

public class BoxVisual {
    PApplet parent;
    float angle = 0;
    float smoothedBoxSize = 0;

    public BoxVisual(PApplet p) {
        parent = p;
    }

    public void render(float amplitude) {
        float boxSize = 50 + (amplitude * 300);
        smoothedBoxSize = PApplet.lerp(smoothedBoxSize, boxSize, 0.2f);

        parent.pushMatrix();
        parent.translate(parent.width / 2, parent.height / 2);
        parent.rotateY(angle);
        parent.rotateX(angle);

        parent.strokeWeight(5);
        parent.box(smoothedBoxSize);

        parent.strokeWeight(2);
        float halfBox = smoothedBoxSize / 2;
        int linesPerFace = 4;

        for (int i = 0; i <= linesPerFace; i++) {
            float offset = parent.map(i, 0, linesPerFace, -halfBox, halfBox);
            parent.line(offset, -halfBox, halfBox, offset, halfBox, halfBox);
            parent.line(offset, -halfBox, -halfBox, offset, halfBox, -halfBox);
            parent.line(-halfBox, offset, halfBox, halfBox, offset, halfBox);
            parent.line(-halfBox, offset, -halfBox, halfBox, offset, -halfBox);
        }

        angle += 0.01f;
        parent.popMatrix();
    }
}
