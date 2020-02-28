# doctor-calendar-app
Doctor Appointment Calendar App

Requirements : mysql, maven, java jdk 

* Create Mysql database - doctor_db
* Create doctor_table with columns : doc_id (primary_key, unsigned, auto_increment, unique), firstname, lastname
* Create appt_table with columns : apptointmentid (primary_key, unsigned, auto_increment, unique), date, time, doc_id, patientfirstname, patientlastname, kindofappointment
* Refer doctor_table.json, appt_data.csv for the mysql schemas
* Add data on mysql to doctor_table with doc_id = 1, firstname = "John", lastname = "Doe" and so on.
* Change mysql username and password as per your installation 
* Go to src/main/resources/application.properties,change spring.datasource.username and spring.datasource.password as per your mysql installation.
* Build : `mvn package`
* To run the SpringBoot application go to the target directory and run the following command:
`java -jar doctor-calendar-1.0.0.jar`
* Alternatively, you can run the app without packaging it using - mvn spring-boot:run. 
* The app will start running at port 8080.
* Test the app using postman - sample queries are available in Doctor-Calendar.postman_collection.json
