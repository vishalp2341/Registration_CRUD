User Registration CRUD Application 
This is a simple Java-based User Registration CRUD application that performs Create, Read, 
Update, and Delete operations using JDBC. The application allows users to register, view a 
list of all registered users, update user details, and delete users. 
Technologies Used 
• Java (JDBC): The application is built using Java with JDBC for database interaction 
and CRUD operations. 
• MySQL: The database used to store user registration data. 
• JSP (JavaServer Pages): Used for rendering dynamic HTML pages. 
• Servlets: To handle HTTP requests and manage the flow of data between the front
end and back-end. 
Features 
• Register a new user 
• View a list of all registered users 
• Update user details 
• Delete a user 
• User details include name, email, phone number, date of birth, and address. 
Project Setup 
Prerequisites 
• JDK 8 or higher 
• MySQL database 
• Maven (for dependency management) 
Steps to Run the Application 
1. Clone the repository. 
2. Navigate into the project directory. 
3. Configure the Database: 
o Create a database in MySQL with the name “Registration”. 
4. Update the database connection settings in the code. 
5. Run the application: 
o Deploy the project to a servlet container like Apache Tomcat. 
o Access the application through your browser at 
http://localhost:8080/registration-management. 
Project Structure 
• /src/main/java: Contains the Java source code (Servlets, DAO, and Models). 
• /src/main/webapp/WEB-INF: Contains JSP files for the front-end. 
• /src/main/resources: Contains configuration files (e.g., db.properties). 
• /lib: External libraries used in the project. 
