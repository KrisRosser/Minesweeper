# Project Title

In the game Minesweeper, the goal is to find where all the mines are 
located within an M x N field. The game shows a number in a square, 
which tells you how many mines are adjacent to that square. Each 
square has at most eight adjacent squares. The 4 x 4 field on the left 
contains two mines, each represented by a "#" character. If we 
represent the same field by the hint numbers described above, we end 
up with the field on the right:

    # . . .         # 1 0 0
    . . . .         2 2 1 0
    . # . .         1 # 1 0
    . . . .         1 1 1 0

## Getting Started

### Prerequisites

What things you need to install the software and how to install them

Winzip, 7zip, File Explorer, etc.

You will need Java Runtime Environment version 7 or higher.

Java is the programming language for this software.

For easy development and debugging this software was designed with Gradle Software Development Build Tool.

Gradle is not technically necessary, but is recommended. https://gradle.org/

### Installing

Download or clone this repository to a folder of your choice.

I would recommend including a .gitignore file for convienience.

This project is designed to be used in conjunction with Gradle Software Develoment Tool.

Once in all files are situated, simple use gradle run or gradle runrobot to play and/or test the program.

## Running the tests

Using the command "gradle build" will compile all the files and run all the acceptance tests for you.

Using the command "gradle run" will perform the Gradle build and then run the program.

Using the command "gradle runrobot" will perform the Gradle build and the have a robot play a quick game for further acceptance testing.

### Break down into end to end tests

This software comes with a battery of unit tests included.

These tests cover functionality of all the files, methods, and algorithms used.

```
build\reports\tests\test\index.html will provide you with a complete and easy to read breakdown of all tests.
```

## Built With

* [Gradle Software Develpment Tool] https://gradle.org/

## Authors

* **Framework designed by Dr. Aaron Garrett** 

The students who worked on this project were Kristofer Rosser and Earl

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

