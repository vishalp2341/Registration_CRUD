<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="registration.css">
</head>
<body>
    <div class="container">
        <h2>Registration Form</h2>

        <!-- Success or Error messages -->
        <div class="message success" style="display: none;">Registration successful!</div>
        <div class="message error" style="display: none;">Error in registration. Please try again.</div>

        <!-- Registration Form -->
        <form action="RegistrationServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required placeholder="Enter your name">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required placeholder="Enter your email">

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>

            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" required placeholder="Enter your phone number">

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required placeholder="Enter your address">

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
