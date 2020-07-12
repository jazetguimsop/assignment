# connectivity assignment
This repo is to store connectivity between two cities assignment

This is a spring boot project
1. Application can be accessed using http://localhost:8080
2. This will redirect to swagger ui.
3. It has one controller with one api with name "connected" and will take 2 city names one for "origin" and another for "destination".
4. It returns "yes" in the response body section of the swagger if they both connected, otherwise return "no"
5. Test cases are written for this project using junit.
6. city.txt file contains all the pair of cities one per each row and is put under resources folder of the project structure. We can also read this file from external location also if required (from github kind of sources using cloud config server, I used in another projects).
7. we can modify this file, after we modify we need to restart the application to take the new values loaded into the application.
8. used logging also to log the entries into the console, we can modify it to write into the file as well.
