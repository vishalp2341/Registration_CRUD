<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <link rel="stylesheet" href="styles.css">
    
     <style>
        /* Global styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            box-sizing: border-box;
        }

        h2 {
            margin-top: 20px;
            font-size: 24px;
            color: #333;
            text-align: center;
        }

        /* Container for content */
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Table styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
        }

        table td {
            font-size: 14px;
            color: #555;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        /* Links inside the table */
        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Action buttons column */
        .actions {
            font-size: 14px;
        }

        .actions a {
            margin-right: 15px;
        }

        /* Empty state */
        .no-users {
            color: #666;
            font-style: italic;
            text-align: center;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .container {
                width: 100%;
                padding: 15px;
            }

            table {
                width: 100%;
            }

            table th, table td {
                font-size: 12px;
                padding: 10px;
            }

            h2 {
                font-size: 20px;
            }
        }

        /* Button confirmation hover */
        .actions a:hover {
            background-color: #4CAF50;
            color: white;
            padding: 5px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h2>Update User</h2>

    <form action="update-user" method="post">
        <input type="hidden" name="id" value="${user.id}">
        
        <label>Name:</label>
        <input type="text" name="name" value="${user.name}" required><br><br>
        
        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" required><br><br>
        
        <label>Date of Birth:</label>
		<input type="date" name="dob" value="${formattedDob}" required><br><br>

        <label>Phone Number:</label>
		<input type="text" name="phone" value="${user.phoneNumber}" required><br><br>
        
        <label>Address:</label>
        <input type="text" name="address" value="${user.address}" required><br><br>
        
        <input type="submit" value="Update">
    <a href="registration.jsp" class="btn-register">Go back to Registration Page</a>
    </form>
    
</body>
</html>
