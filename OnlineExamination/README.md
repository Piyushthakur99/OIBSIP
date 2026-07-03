# Online Examination System

A simple, clean, beginner-friendly Core Java console application built for the Oasis Infobyte Java Development Virtual Internship. The project simulates an online exam platform without using a database, Spring Boot, GUI, or external libraries.

## Internship Details

- Internship Name: Oasis Infobyte Java Development Virtual Internship
- Project Type: Core Java Console Application
- Project Name: Online Examination System

## Features

- Login with predefined user credentials
- Update password with validation
- View user profile details
- Start a 10-question Java MCQ exam
- Show remaining time before each question
- Auto-submit when the 2-minute timer expires
- Display result with score, percentage, and pass/fail status
- Logout with a clean exit message

## Technologies Used

- Core Java
- Maven
- Scanner
- ArrayList
- Classes and Objects
- Encapsulation
- Loops and Conditional Statements
- Exception Handling

## Project Structure

```text
OnlineExamination/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── oibsip/
│                   └── onlineexam/
│                       ├── App.java
│                       ├── ExamService.java
│                       ├── LoginService.java
│                       ├── Question.java
│                       ├── ResultService.java
│                       ├── TimerService.java
│                       └── User.java
├── screenshots/
│   ├── login-screen.png
│   ├── menu-screen.png
│   ├── exam-screen.png
│   ├── result-screen.png
│   └── logout-screen.png
├── .gitignore
├── pom.xml
└── README.md
```

## How to Run

### Using Terminal

```bash
mvn clean compile
mvn exec:java
```

### Using VS Code or IntelliJ IDEA

1. Open the `OnlineExamination` folder in your IDE.
2. Make sure Java 17+ and Maven are installed.
3. Run `com.oibsip.onlineexam.App`.

## Demo Credentials

- User ID: `oibsip01`
- Password: `java123`

## Sample Output

```text
==================================================
          ONLINE EXAMINATION SYSTEM
==================================================
Login successful. Welcome, Aarav Sharma!

-------------------- MAIN MENU --------------------
1. Start Examination
2. Update Password
3. View Profile
4. Logout
--------------------------------------------------

Remaining Time: 02:00

Question 1
What is JVM?

A. Java Variable Manager
B. Java Virtual Machine
C. Java Version Manager
D. Java Visual Model

Enter answer (A/B/C/D): B

Time Up! Exam Submitted Successfully.

==================== RESULT ======================
Total Questions   : 10
Attempted         : 10
Correct Answers   : 8
Wrong Answers     : 2
Final Score       : 80/100
Percentage        : 80%
Status            : PASS
==================================================
```

## Screenshots

Place the project screenshots in the `screenshots` folder with the following names:

- `login-screen.png`
- `menu-screen.png`
- `exam-screen.png`
- `result-screen.png`
- `logout-screen.png`

## Author Information

- Name: Piyush Thakur
- Internship: Oasis Infobyte Java Development Virtual Internship
- Project: Online Examination System

## Notes

- The application uses hardcoded credentials because no database is required.
- The exam timer is implemented with a simple elapsed-time check.
- Questions are stored in memory using an `ArrayList`.

## Repository

All internship tasks are maintained inside a single repository named `OIBSIP`.