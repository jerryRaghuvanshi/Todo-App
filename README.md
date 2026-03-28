# Todo-App
Spring Boot Todo Application built while following the in28minutes course. This project demonstrates a complete backend using Spring Boot, Spring MVC, JSP, and MySQL with features like user authentication, CRUD operations, and MVC architecture.

# 📝 Spring Boot Todo Application

A full-stack **Todo Management Web Application** built using **Spring Boot, Spring MVC, JSP, and MySQL**.
This project is developed as part of the **in28minutes Spring Boot course** to understand real-world backend development and MVC architecture.

---

## 🚀 Features

* 🔐 User Authentication (Login/Logout)
* 📝 Create, Update, Delete Todos (CRUD)
* 📅 Add target dates for tasks
* ✅ Mark tasks as completed
* 🌐 MVC Architecture using JSP views
* 💾 Persistent storage using MySQL
* 🔒 Spring Security integration

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Security

### Frontend

* JSP (Java Server Pages)
* HTML, CSS

### Database

* MySQL

### Build Tool

* Maven

---

## 📂 Project Structure

```
src/
 ├── main/
 │   ├── java/com/example/todo/
 │   │   ├── controller/
 │   │   ├── service/
 │   │   ├── model/
 │   │   └── security/
 │   ├── resources/
 │   │   ├── application.properties
 │   │   └── static/
 │   └── webapp/WEB-INF/jsp/
 │       ├── login.jsp
 │       ├── todo-list.jsp
 │       └── todo-form.jsp
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/todo-app.git
cd todo-app
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

---

### 4️⃣ Access the App

Open in browser:

```
http://localhost:8080
```

---

## 🔑 Default Credentials (if configured)

```
Username: user
Password: password
```

---

## 📚 Learning Outcomes

* Understanding of **Spring Boot fundamentals**
* Working with **Spring MVC architecture**
* Implementing **authentication with Spring Security**
* Handling **CRUD operations with database**
* Integrating **JSP with Spring Boot**

---

## 📸 Screenshots (Optional)

*Add your screenshots here*

---

## 🤝 Acknowledgements

* in28minutes Spring Boot Course
* Official Spring Documentation

---

## 📌 Future Improvements

* REST API version of the app
* React/Angular frontend
* Docker deployment
* JWT Authentication

---

## ⭐ Contribute

Feel free to fork this repo, raise issues, and submit pull requests!

---

## 📜 License

This project is open-source and available under the MIT License.
