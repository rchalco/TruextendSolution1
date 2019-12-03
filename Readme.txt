This is solution a Backend Question DK - Ruben Chalco.
write-up  around what technologies/frameworks used:
Java 1.8.0
IDE Apache Neat Beans 11
Deploy in server Payara
Service RestFul over JAXRS
Pattern used: Factory, Controller.
DB: no BD, static data at RAM.
URI Module: resources/EnrollmentService/{Operation}
Operation and Implementations:
Create/Edit/Delete Student: CreateStudent/EditStudent/DelStudent
Create/Edit/Delete Class: CreateClass/EditClass/DelClass
Browse list of all Student: getAllStudent
Browse list of all Classes: getAllClass
View all Students assigned to a Class: getStudentsByClass
View all Classes assigned to a Student: getClassByStudent
Search Student/Classes by available fields/associations: getInfoEnrollment

All operation CRUD and Querys, return a object wrapper with state, message and data. Example:
{
    "message": "Student added",
    "state": "success"
}

For testing using JS o Postman, json example for operation CreateStudent:
{"studentid":4, "firstname":"test4", "lastname":"test44"}
