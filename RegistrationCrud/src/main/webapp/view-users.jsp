<%@ page import="java.util.List" %>
<%@ page import="com.register.model.Registration" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Users</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        h2 {
            margin-top: 20px;
            font-size: 24px;
            color: #333;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #e35739;
            color: white;
        }

        table td {
            font-size: 14px;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        .actions {
            font-size: 14px;
        }

        .no-users {
            color: #666;
            font-style: italic;
        }

        .container {
            width: 90%;
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
       
        <h2>All Registered Users</h2>

        <!-- Display users in a table -->
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date of Birth</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate over the list of users -->
                <%
                    List<Registration> users = (List<Registration>) request.getAttribute("users");
                    if (users != null && !users.isEmpty()) {
                        for (Registration user : users) {
                %>
                    <tr>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getDateOfBirth() %></td>
                        <td><%= user.getPhoneNumber() %></td>
                        <td><%= user.getAddress() %></td>
                        <td class="actions">
                            <a href="update-user?id=<%= user.getId() %>">Edit</a>  <br>
                            <a href="delete-user?id=<%= user.getId() %>" onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                        </td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="6" class="no-users">No users found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        
    </div>
     <a href="registration.jsp" class="btn-register">Go back to Registration Page</a>
</body>
</html>
