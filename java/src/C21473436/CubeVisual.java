package C21473436;

import processing.core.PApplet; // Import PApplet class for processing functions

// Class for rendering a rotating cube 
public class CubeVisual {
    PApplet parent; // Referance to parent processing sketch

    // Rotation angles
    float angleX = 0; 
    float angleY = 0;

    // Class constructor to associate this visual with parent
    public CubeVisual(PApplet p) {
        parent = p; // Store the passed PApplet referance as p
    }

    public void render(float amplitude) {
        parent.pushMatrix(); // Save current transformation matrix 
        parent.translate(parent.width / 2, parent.height / 2, -200); // Centre the cube
        // Apply rotation
        parent.rotateX(angleX);
        parent.rotateY(angleY);

        float hue = parent.map(amplitude * 200, 0, 1, 0, 255);
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
