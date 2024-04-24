package C21473436;

import processing.core.PApplet; // Import PApplet class for processing functions

// Class to render small cubes
public class SmallCubes {
    PApplet parent; // Referance to parent PApplet
    int numCubes = 500;  // Set number of cubes (feel free to change)
    // Arrays to store rotations, positions, depths and colours
    float[][] rotations;
    float[][] positions;
    float[] depths;
    int[] colors;
    
    // Constructor 
    public SmallCubes(PApplet p) {
        this.parent = p;
        rotations = new float[numCubes][2];
        positions = new float[numCubes][2];
        depths = new float[numCubes];
        colors = new int[numCubes];

        // For loop to intialise properties of each cube
        for (int i = 0; i < numCubes; i++) {
            // Set random rotation speeds
            rotations[i][0] = parent.random(0.01f, 0.03f); 
            rotations[i][1] = parent.random(0.01f, 0.03f); 
            
            //Set positions based on a random angle and radius
            float angle = parent.random(PApplet.TWO_PI); 
            float radius = parent.random(200, 700); 
            positions[i][0] = parent.width / 2 + PApplet.cos(angle) * radius; 
            positions[i][1] = parent.height / 2 + PApplet.sin(angle) * radius;
      
            // Random depth
            depths[i] = parent.random(-200, 200); 
        
            // Random colour
            colors[i] = parent.color(parent.random(255), 255, 255, 255); 
        }
    }

    // Render method
    public void render(float amplitude) {
        for (int i = 0; i < numCubes; i++) {
            parent.pushMatrix(); // Save current transformation matrix
           
            parent.translate(positions[i][0], positions[i][1], depths[i]); // Translate positions of cubes and apply depth
            
            // Apply rotations 
            parent.rotateX(parent.frameCount * rotations[i][0]);
            parent.rotateY(parent.frameCount * rotations[i][1]);
           
            // Set cube colour
            parent.fill(colors[i]);
           
            parent.box(30 + (200 * amplitude)); // Generate cube
            parent.popMatrix(); // Restore matrix
        }
    }
}