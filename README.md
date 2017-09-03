# robotest
Robot program.

The robot lives in a room and is controlled by simple commands like turn left, turn right and go forward.

There are differnt robots and different types of rooms.

If a robot hits the wall of the room when it tries to go forward it will stay at the current position.

## Robot commands
Depending on language the

  Command        English        Swedish 
  Turn right     R              H
  Turn left      L              V
  Go forward     F              G
  
The commands can be given as a sequence of commands like RFFRFF.

## Room
For each room it is possible to control the entry point where the robot will start.

The X axis is positive to EAST.

The Y axis is positive to SOUTH.

### Universal room
A very large room with no walls.

### Circular room
Circular walls. The radius of the room control the size, but since the robot world contains of squares where the robot can stand the room consist of radius steps in any direction so the actual diameter for the room is radius+radius+1 since the center square also counts.

### Rectangular room
Rectangular room with specific number of squares width and height.

## Robots

### Basic robot
Robot optimized for readability and accuracy. If speed is of interest try out some of the other robots.

### Micro robot
Robots that moves and turn fast as long as no one are communicating with it.
