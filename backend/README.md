# Collaborative Task Management System - Backend

## Overview
This is the Java Spring Boot backend for the Collaborative Task Management System. It provides REST APIs for user, team, and task management with robust business logic and role-based access.

## Features
- User, Team, Task CRUD APIs
- Role-based access control (Admin, Manager, Member)
- Analytics endpoints (tasks completed per user/team)
- Round-robin task assignment
- Prevent deletion of completed tasks
- Notification simulation (console/API)
- Concurrency handling for task updates

## Prerequisites
- Java 17+
- Maven 3.8+
- MySQL 8+

## Setup Instructions
1. **Clone the repository**
   ```sh
   git clone <your-repo-url>
   cd backend
   ```
2. **Configure the database**
   - Edit `src/main/resources/application.properties` with your MySQL username and password.
   - Run the SQL script to create the DB and tables:
     ```sh
     mysql -u <user> -p < db_setup.sql
     ```
3. **Build and run**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will run on `http://localhost:8080`.

## API Overview
- **Users:** `/api/users` (CRUD, get by team)
- **Teams:** `/api/teams` (CRUD)
- **Tasks:** `/api/tasks` (CRUD, by team/assignee/status)
- **Comments:** `/api/comments` (add/view by task)
- **Analytics:** `/api/tasks/analytics/completed/user/{userId}`
- **Role-based access:**
  - Admin: manage users/teams
  - Manager: assign tasks, view team progress
  - Member: update task status, add comments

## Testing
- Use Postman or any API client to test endpoints.
- Example: `GET /api/users`, `POST /api/tasks`, etc.

## Docker (Bonus)
To run backend in Docker:
```sh
docker build -t collab-task-backend .
docker run -p 8080:8080 collab-task-backend
```

## Notes
- Ensure MySQL is running and accessible.
- JWT authentication can be added for production.
- For any issues, check logs or raise an issue in the repo.

