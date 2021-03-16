# RootProblem

To run this program a file called testFile.txt should be passed into the src/main/resources folder with the appropriate format. Once the program is run a new file with the appropriate data should be written out into that same folder. It will be called something like "Root_Driver_Report_DATE.txt" 

This is a Maven project which consists of two classes which act as models and five classes which handle the business logic. Those classes are as follows:

- RootDriver - The model for a driver
- RootTrip - The model for a trip
- RootDriverLogic - The logic handler for calculating driver data
- RootFileReader - The file reader (also creates driver and trip objects)
- RootFileProcessor - The file processor which sorts the drivers and hands off values to the reader and writer
- RootFileWriter - The file writer which just writes the data to a text file.
- RootClassDriver - The class which holds the main method for this program

In my inital approach to this problem I had the idea that I should just store the entire input file as one long string. I wrote out a littel flow chart like below:

