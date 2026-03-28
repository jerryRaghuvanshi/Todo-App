<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Todo</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: white;
            padding: 25px;
            border-radius: 10px;
            width: 350px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input, textarea, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .btn {
            width: 100%;
            margin-top: 15px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }

        .btn-submit {
            background-color: #28a745;
        }

        .btn-submit:hover {
            background-color: #218838;
        }

        .btn-back {
            background-color: #007BFF;
            margin-top: 10px;
            display: block;
            text-align: center;
            text-decoration: none;
            padding: 10px;
            color: white;
        }

        .btn-back:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

<div class="form-container">

    <h2>➕ Add New Todo</h2>

    <form:form method="post" modelAttribute="todoUser"
               action="${todoUser.id == 0 ? 'add-todo' : 'update-todo'}">

        <label>User Name</label>
        <form:input path="userName" placeholder="Enter user name" required="true"/>

        <form:hidden path="id"/>


        <label>Description</label>
        <form:textarea path="description" placeholder="Enter todo description" required="true"/>

        <label>Target Date</label>
        <form:input path="targetDate" type="date" required="true"/>

        <label>Status</label>
        <form:select path="done">
            <form:option value="false" label="Pending"/>
            <form:option value="true" label="Done"/>
        </form:select>

        <button type="submit" class="btn btn-submit">Save Todo</button>

    </form:form>

    <a href="/todoList" class="btn btn-back">⬅ Back to List</a>

</div>

</body>
</html>