# Quiz Application

The Quiz Application is a backend application that can perform CRUD operations on Question and Quiz Service, developed using Spring Boot, MySQL and REST APIs. It enables customers to add a question, get the list of all questions, send response for some questions and get the score in response from the server.

## Prerequisites

- JDK 11 or higher
- Maven
- MySQL Database
- IntelliJ IDEA Ultimate
- POSTMAN

## Installation

1. Clone the repository: `git clone <repository_url>`
2. Navigate to the project directory: `cd quizapp`

## Configuration

1. Configure MySQL Database:
   - Create a new database schema for the application in mySQL Workbench.
   - Update the database configuration in `src/main/resources/application.properties` file with your MySQL connection details like url, password.

2. Open the downloaded project in IntelliJ IDEA Ultimate
   
3. Build and Run the application:
   - Click on the green arrow button to run the application.

4. Test the submit feature
   - Fetch some questions from the Database and send your responses as the List of {id, response} to the server.
   - Server checks the response with the actual Right_Answers and calculates the total score.
   - In response you will get the total score you got based on the options chosen.
   - Send all the GET and POST requests using POSTMAN

## Usage

### Customer Features:

1. **Add a Question:**
   - Customers can add a question by giving some pre-set values like: Question title, 4 options and category, etc.
   - Given question will be added to the Database.
2. **Get All Questions or From a Category:**
   - Customers can get the list of all the questions present in the Database.
   - Customers can get all the questions based on the input category like Java, DSA, etc.

3. **Create a Quiz:**
   - Customers can create a Quiz by sending three parameters namely: Quiz Title, Category and Number of Questions(numQ).
   - The system will fetch numQ questions from the Database and create a quiz and then add the quiz to the Database.
   - Response will be **success** and **HTTP 201 CREATED**
4. **Get a Quiz:**
   - Customers can get a quiz based on the input quiz_id
   - Response will be the list of all questions for **quiz_id** quiz **HTTP 200 OK**
5. **Submit a Quiz:**
   - Customers can send responses for some questions in the form of JSON.
   - Server will computer and return the total score based on the input.
   - You will get total score along with **HTTP 200 OK** as the response from server.
## HTTP Status Codes Used
1. **HTTP 200 OK:** The request succeeded. The result meaning of "success" depends on the HTTP method
   - GET: The resource has been fetched and transmitted in the message body.
2. **HTTP 201 CREATED:** The request succeeded, and a new resource was created as a result. This is typically the response sent after POST requests, or some PUT requests. 
  For more information, you can see the documentaion at https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
## Contributing

Contributions to the **Quiz Application** are welcome. If you find any issues or have suggestions for improvement, please create a new issue or submit a pull request.
