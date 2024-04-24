# Music Visualiser Project

Names: Mateusz Matijuk, Daniel Carson

Student Number: C21473436, C21431136

# Description of the assignment
Object Oriented Programming group assignment to create an audio visualiser program using java processing libraries.

# Instructions
Clone this repository https://github.com/Matty185/MusicVisuals to access the program. You will find all of our files in java > src > C21473436. Start the program by running Main.java. 

![image](https://github.com/Matty185/MusicVisuals/assets/124153544/aa2bbfd2-500a-45b0-aec1-a2d442b5ab7d)

As shown on program run, user can navigate through our different visuals by pressing left and right key. Enjoy!

# How it works

## Rotating cube
  
![image](https://github.com/Matty185/MusicVisuals/assets/124153544/19773c18-4591-4eb4-874c-7bbfbfd46e74)

This visual involves the functionality needed to create an interactive 3D visual representation of a cube whose size and color respond to a given amplitude, with user interaction through mouse movement affecting its rotation. 

![image](https://github.com/Matty185/MusicVisuals/assets/124153544/3712ff45-d5d9-44af-bea1-1da373a01d13)

The cube is generated with the box() method in the render method, which is influenced by amplitute making the cube change size with music. The pushMatrix() and popMatrix() methods are used to save and restore the current transformation matrix. This allows rotation of the cube with a mouse drag without affecting any other objects drawn later. Using translate() the cube is centered on the screen. The visual is also equipped with colour changing based on amplitute achieved by mapping the hue based on amplitute with map().


## Rotating Cube 2
This cube will rotate automatically. 
<img width="1710" alt="Screenshot 2024-04-23 at 18 34 41" src="https://github.com/Matty185/MusicVisuals/assets/100539586/2a003452-16a1-43ef-8d17-02924d5e5ed8">

Star effects provide an illusion that the cube is moving through space. 
<img width="910" alt="Screenshot 2024-04-23 at 18 36 45" src="https://github.com/Matty185/MusicVisuals/assets/100539586/5472008d-d14e-4dc7-a981-8a38f9a6fcd6">


A grid layout on two opposite face give enhances the cube's 3D effect.
<img width="1160" alt="Screenshot 2024-04-23 at 18 37 27" src="https://github.com/Matty185/MusicVisuals/assets/100539586/625e8105-e22d-413d-a9ae-e8f19028fb32">


## Smaller cubes
  
![image](https://github.com/Matty185/MusicVisuals/assets/124153544/867a4dc4-0302-4257-8f78-8afb77ee83a9)

This is visually appealing, dynamic 3D visualization of cubes that float around the center of the screen, rotate continuously, and change size based on amplitude value.

![image](https://github.com/Matty185/MusicVisuals/assets/124153544/47b8d5ca-e933-400b-9706-4483846d801a)

![image](https://github.com/Matty185/MusicVisuals/assets/124153544/57968076-c92b-4767-b6ca-779231c34d25)

The constructor consists of multiple arrays to store all data needed for position, depth, rotation and colour of the cubes. Similrarly to the previous visual, it utilises the The pushMatrix() and popMatrix() methods, as well as rotate() to add life to the program.

![image](https://github.com/Matty185/MusicVisuals/assets/124153544/9a8c583c-8507-4335-9022-0b9c54da59ce)

The render method is very similar render method for the other cube. 


# What I am most proud of in the assignment
This project provided us with a new perspective of programming that supersedes the usual industry type problems found in other modules and instead, opened our eyes to the niche sub-section of creative programming. 

We particularly enjoyed using the Processing development environment that enabled us to create the interactive graphics and visuals seen in this project. 

Finally, the use of Github not only provided us with an insight into how projects are developed in industry, but ensured teamwork and cooperation throughout. 

