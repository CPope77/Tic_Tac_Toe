cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;C:\Users\Connor\Robot_Framework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.robot
cd ..