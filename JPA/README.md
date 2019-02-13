## Assignments 4
You can test the project by using Postman
step 1:
Run Cs5200Fall2018CuiJpaApplication.java  as Java Application

step 2: Insert data 
POST  http://localhost:8080/api/test

step 3:
GET  http://localhost:8080/api/test/user
GET  http://localhost:8080/api/test/faculty
GET  http://localhost:8080/api/test/student
GET  http://localhost:8080/api/test/course
GET  http://localhost:8080/api/test/section
GET  http://localhost:8080/api/test/courseByFaculty
GET  http://localhost:8080/api/test/sectionByCourse
GET  http://localhost:8080/api/test/studentBySection
GET  http://localhost:8080/api/test/sectionByStudent
GET  http://localhost:8080/api/test/seatBySection


For enrollment, the professor want us to try many to many, So I didn't break it into two one to many relationship. the project already has one to many relationship. And this assignment didn;t use any field in enrollment. If it used, i will fix it.
The course and section part prove I can use one to many relationship, and the enrollment part prove I can use many to many relationship.
I did write the enrollment, but I decide to not use it.