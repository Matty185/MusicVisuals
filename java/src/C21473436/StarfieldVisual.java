package C21473436;

import processing.core.PVector;
import processing.core.PApplet;

public class StarfieldVisual {
    PApplet parent;
    PVector[] stars;

    public StarfieldVisual(PApplet p, int numberOfStars) {
        parent = p;
        stars = new PVector[numberOfStars];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new PVector(parent.random(-parent.width * 2, parent.width * 2), parent.random(-parent.height * 2, parent.height * 2), parent.random(-500, 500));
        }
    }

    public void render(float amplitude) {
        parent.stroke(255); // White color for stars
        parent.strokeWeight(4); // Star size
        for (PVector star : stars) {
            parent.pushMatrix();
            parent.translate(star.x, star.y, star.z);
            parent.point(0, 0);
            parent.popMatrix();

            star.z += parent.map(amplitude, 0, 1, 2, 20);
            if (star.z > 500) {
                star.z = -500;
                star.x = parent.random(-parent.width * 2, parent.width * 2);
                star.y = parent.random(-parent.height * 2, parent.height * 2);
            }
        }
    }
}
