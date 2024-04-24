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

        float hue = parent.map(amplitude * 25, 0, 1, 0, 255); // Scale amplitude and map it to a hue value
        int color = parent.color(hue, 255, 255);  // Generate a color from the hue
        
        parent.stroke(255); // Set outline to white
        parent.fill(color); // Fill with colour

        float boxSize = 200 + (200 * amplitude); // Calculate the box size based on amplitude
        parent.box(boxSize); // Generate box
        parent.popMatrix(); // Restore previous transformation matrix
    }

    // Update rotation angles based on mouse movement and rate
    public void updateRotation(float rate) {
        angleY += (parent.mouseX - parent.pmouseX) * rate;
        angleX += (parent.mouseY - parent.pmouseY) * rate;
    }
}
