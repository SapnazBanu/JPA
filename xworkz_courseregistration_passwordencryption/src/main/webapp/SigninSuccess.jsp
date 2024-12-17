<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f9;
        }
        h1 {
            color: #333;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
        }
    </style>
</head>
<body>
    <body>
        <h1>Welcome, <a href="user">${userName}</a></h1>

        <c:if test="${not empty userName}">
            <h2>User Details:</h2>
            <p>Name: ${userDetails.name}</p>
            <p>Email: ${userDetails.email}</p>
            <p>Age: ${userDetails.age}</p>
            <p>Phone: ${userDetails.phno}</p>
        </c:if>
    </body>
    </div>
</body>
</html>
