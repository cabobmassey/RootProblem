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

In my initial approach to this problem I had the idea that I should just store the entire input file as one long string. I wrote out a simple flow chart like below:

![alt text](https://github.com/cabobmassey/RootProblem/blob/master/Root%20Coding%20Problem%20Simple%20Flowchart.png)

I also wrote out how I thought each class might act initially:

![alt text](https://github.com/cabobmassey/RootProblem/blob/master/FileReader%20Flow-2.png)

![alt text](https://github.com/cabobmassey/RootProblem/blob/master/FileProcessor%20Flow.png)

My thought process was to maintain appropriate separation of concerns by keeping each class in a very rigid set of requirements. However, after actually getting into it, I realized that just storing the values as one long string would not be the easiest way to capture the data. It seemed like I needed to create two objects (Driver and Trip) which had attributes I could assign these values to. So I ended up using the RootFileReader class to create my Driver and Trip objects as well. This way, I was able to capture the data and assign it to the object immediately.

The next issue was storing that data. I went through a couple of iterations with arrays and array lists, but those weren't working. I considered that in the real world we would be sing a database, so I thought about just using an in-memory H2 database, but I thought that might not be practical for this exercise. In the end the thing that seemed most reasonable to me was to create a HashMap. This HashMap would act like a table and hold the Driver's name along with the Driver object associated with that name. This way, whenever a Trip came in for that Driver, I could add the Trip data to the Driver object by using the name.

After I got over that problem the rest was just about deciding where to do the math and when to update the object. I created the RootDriverLogic class to handle most of that. I also used this to reject trips which are not within the given threshold of >5 or <100.

Once the trips are calculated and the Driver object is populated with correct data, I print out the results. I used try-with-resources blocks whenever doing any file handling simply because it's less prone to leaving file streams open after writing or reading which could cause memory issues.

Lastly, I have created a test class which does unit testing for edge cases and also ensures that objects are getting created correctly. Admittedly, testing has never been my strong suit, but I have been trying to improve there. Any feedback would be very helpful.

This is just a quick breakdown of how I approached the problem. I definitely have more to say about why I went in this direction and there are already a few thing I would consider doing differently, so I hope I get to chat with you all soon. Thanks!
