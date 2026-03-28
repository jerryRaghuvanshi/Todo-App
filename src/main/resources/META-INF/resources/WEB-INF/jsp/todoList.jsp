<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Todo List</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
        }

        /* 🔷 NAVBAR */
        .navbar {
            background-color: #007BFF;
            color: white;
            padding: 12px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .nav-left a {
            color: white;
            text-decoration: none;
            margin-right: 15px;
            font-weight: bold;
        }

        .nav-left a:hover {
            text-decoration: underline;
        }

        .nav-right {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .logout-btn {
            background-color: #dc3545;
            padding: 6px 12px;
            border-radius: 5px;
            text-decoration: none;
            color: white;
        }

        .logout-btn:hover {
            background-color: #c82333;
        }

        /* 🔷 MAIN CONTAINER */
        .container {
            width: 85%;
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .btn {
            padding: 8px 15px;
            border-radius: 5px;
            text-decoration: none;
            color: white;
        }

        .btn-add {
            background-color: #28a745;
        }

        .btn-warning {
            background-color: #ffc107;
            color: black;
        }

        .btn-success {
            background-color: #17a2b8;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .done {
            color: green;
            font-weight: bold;
        }

        .pending {
            color: red;
            font-weight: bold;
        }

        .no-data {
            text-align: center;
            color: gray;
            padding: 20px;
        }
    </style>
</head>

<body>

<!-- 🔷 NAVBAR -->
<div class="navbar">
    <div class="nav-left">
        <a href="/">🏠 Home</a>
        <a href="todoList">📋 Todos</a>
    </div>

    <div class="nav-right">
        <span>👤 ${todos[0].userName}</span>
        <a href="logout" class="logout-btn">Logout</a>
    </div>
</div>

<!-- 🔷 CONTENT -->
<div class="container">

    <h2>📋 Todo List</h2>

    <div class="top-bar">
        <span>Total Todos: ${todos.size()}</span>
        <a href="add-todo" class="btn btn-add">+ Add Todo</a>
    </div>

    <table>
        <tr>
            <th>User</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Status</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>

        <c:choose>
            <c:when test="${not empty todos}">
                <c:forEach var="todo" items="${todos}">
                    <tr>
                        <td>${todo.userName}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>

                        <td>
                            <c:choose>
                                <c:when test="${todo.done}">
                                    <span class="done">✔ Done</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="pending">⏳ Pending</span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <td>
                            <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                        </td>

                        <td>
                            <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>

            <c:otherwise>
                <tr>
                    <td colspan="6" class="no-data">No Todos Available</td>
                </tr>
            </c:otherwise>
        </c:choose>

    </table>

</div>

</body>
</html>