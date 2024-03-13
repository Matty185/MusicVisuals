package example;

import ie.tudublin.Visual;
import processing.core.*;

class RotatableCube {
    PApplet parent; // Reference to the parent sketch
    PVector rotation;
    float size;
    int fillColor;

    // Constructor
    RotatableCube(PApplet p, float sz) {
        parent = p;
        size = sz;
        rotation = new PVector(0, 0, 0);
        fillColor = parent.color(255, 0, 0); // Default fill color
    }

    // Method to draw the cube
    void display() {
        parent.pushMatrix();
        parent.translate(parent.width / 2, parent.height / 2);
        parent.rotateX(rotation.x);
        parent.rotateY(rotation.y);
        parent.stroke(255); // White outline
        parent.fill(fillColor);
        parent.box(size);
        parent.popMatrix();
    }

    // Method to update the cube's rotation
    void updateRotation(float rotX, float rotY) {
        rotation.x += rotX;
        rotation.y += rotY;
    }

    // Method to change the cube's color based on the music's amplitude
    void reactToMusic(float amplitude) {
        fillColor = parent.lerpColor(parent.color(255), parent.color(255, 0, 0), amplitude); // From white to red
    }
}

