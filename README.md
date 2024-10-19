# Object Oriented Programming (2023) - University Member Management System

## Project Overview

This project is an individual assignment for the "Object-Oriented Programming – Java" course, offered in the 2nd semester of the 2023 academic year at the University of Piraeus, Department of Informatics. The goal of this project is to develop a console-based Java application that manages university members, including students, professors, administrative staff, and management. The application supports key object-oriented programming principles and allows users to perform various operations such as adding, viewing, editing, and deleting member records. Data is persisted using Java Serialization to ensure information is saved between sessions.

## Course Information
- **Institution:** [University of Piraeus](https://www.unipi.gr/en/)
- **Department:** [Department of Informatics](https://cs.unipi.gr/en/)
- **Course:** Object Oriented Programming (2023)
- **Semester:** 2nd


## Technologies Used

- Java

## Usage Examples

### Main Menu

```console
*------Project by P20094-------*
  Welcome to the University App
+------------------------------+
|Please select an option below:|
+------------------------------+
1. View all the users that have registered in the app
2. Add a new user
3. Search by full name
4. Search by registration number
5. Edit user profile based on the user's registration number
6. Delete a user by user's registration number
7. Exit the app
------------------------------
You want the option number:
```
### Add a new Member

```console
You want the option number: 2

Please select the type of user you want to add:
1. Student
2. Professor
3. Secretary
4. Administrator
5. Return to main menu
You want the option number: 1
Please fill the following fields:
------------------------------
Full Name: Student Example
Email: student@example.com
Year of enrollment: 2023

Student created successfully!
Student's ID: S22002

S22002 saved successfully!
```

### Search by full name

```console
You want the option number: 3

Please type the full name of the user: Student Example
Searching all profiles... Please wait!
User found!
Role ='Student', Full Name ='Student Example', ID ='S22002', Email ='student@example.com'', Year of enrollment ='2023'
```

## Setup Instructions

1. **Java Installation:** Ensure you have Java Development Kit (JDK) installed on your system.
2. **Clone the Repository:** Clone the project repository from GitHub to your local machine.
3. **Import the Project:** Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
4. **Compile and Run:** Compile and run the Main.java file to start the application.
5. **Preloaded Data:** A sample member list is preloaded from a serialized file when the application starts.


## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
