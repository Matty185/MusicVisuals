package C21473436;

import processing.core.PApplet;

public class SmallCubes {
    PApplet parent;
    int numCubes = 200; 
    float[][] rotations;
    float[][] positions;
    float[] depths;
    int[] colors;
    

    public SmallCubes(PApplet p) {
        this.parent = p;
        rotations = new float[numCubes][2];
        positions = new float[numCubes][2];
        depths = new float[numCubes];
        colors = new int[numCubes];

        
        for (int i = 0; i < numCubes; i++) {
            
            rotations[i][0] = parent.random(0.01f, 0.03f); 
            rotations[i][1] = parent.random(0.01f, 0.03f); 
            
            
            
            float angle = parent.random(PApplet.TWO_PI); 
            float radius = parent.random(200, 300); 
            positions[i][0] = parent.width / 2 + PApplet.cos(angle) * radius; 
            positions[i][1] = parent.height / 2 + PApplet.sin(angle) * radius;

      
            depths[i] = parent.random(-200, 200); 
            
        
            colors[i] = parent.color(parent.random(255), 255, 255, 255); 
        }
    }

    public void render(float amplitude) {
        for (int i = 0; i < numCubes; i++) {
            parent.pushMatrix();
           
            parent.translate(positions[i][0], positions[i][1], depths[i]);
            
            parent.rotateX(parent.frameCount * rotations[i][0]);
            parent.rotateY(parent.frameCount * rotations[i][1]);
           
            parent.fill(colors[i]);
           
            parent.box(30 + (200 * amplitude)); 
            parent.popMatrix();
        }
    }
}