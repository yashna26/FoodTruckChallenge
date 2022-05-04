# FoodTruckChallenge

This project is about finding the nearest food trucks when a user searches from anywhere in San Francisco.


# Requirements
Java 1.8+
Tomcat 9.0+
Eclipse IDE ( Any suitable IDE)
Spring MVC Dependencies ( Useful link - https://crunchify.com/simplest-spring-mvc-hello-world-example-tutorial-spring-model-view-controller-tips/ ) 

Note : I didn’t use Maven. I copied over the jar files in the class path directly.


# Challenges
 There were issues around my eclipse setup. Couple of java version were not compatible with eclipse version I had earlier.
I wasn’t able to download a few Java versions in my MacBook. ( if you have a newer Mac with M1 chip ,this might might occur).



# Things I was able to achieve so far
-> Come up with a tech stack I want to use. There was some back and forth about using different/new technologies but I decided to start with something simple and advance from there.
-> Came up with a solution about how to design and how this would work. 
-> Researched around for a while figuring out what public API I can use to get User’s current location in order to me to find the nearby places. Came across googlepi.geolocation() which would take a user’s api key and return the latitude longitude. ( implemented this)
-> Once I have the above information, Parsed the csv file that was available to map it to Java model class. ( implemented this).


# Things I had in mind but wasn’t able to implement
-> Once I have both the coordinates , calculate the distance between the user and the food truck locations.
-> Use a data structure ( my thought was priority Queue) to store the nearest places based on distance and return them at the end to the users.


# If I had more time
Finish up the things I have in mind and Structure out the project . Think about using the schedules that shows which date/time the food truck are available at particular location.


 
