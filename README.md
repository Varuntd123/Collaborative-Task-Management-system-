# Collaborative Task Management System

## Overview
A full-stack collaborative task management platform with multi-user roles (Admin, Manager, Team Member), real-time task management, role-based access, analytics, and more.

## Project Structure
- `/backend` — Java Spring Boot backend (REST API, MySQL)
- `/frontend` — React.js frontend (SPA)

## 🚀 Complete Setup & Execution Guide

### Prerequisites
- **Java 17+** installed and configured
- **Maven 3.8+** installed and configured
- **MySQL 8+** installed and running
- **Node.js 18+** and **npm 9+** installed
- **Git** for version control

### Step 1: Database Setup
1. **Start MySQL Service**
   ```bash
   # Windows (as Administrator)
   net start mysql80
   
   # macOS/Linux
   sudo systemctl start mysql
   # OR
   sudo service mysql start
   ```

2. **Create Database and Tables**
   ```bash
   # Connect to MySQL
   mysql -u root -p
   
   # In MySQL prompt, run:
   source backend/db_setup.sql
   
   # Or directly from command line:
   mysql -u root -p < backend/db_setup.sql
   ```

3. **Create Database User (Optional but Recommended)**
   ```sql
   CREATE USER 'collab_user'@'localhost' IDENTIFIED BY 'your_secure_password';
   GRANT ALL PRIVILEGES ON collab_task_db.* TO 'collab_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

### Step 2: Backend Setup & Execution
1. **Navigate to Backend Directory**
   ```bash
   cd backend
   ```

2. **Configure Environment Variables**
   ```bash
   # Windows (PowerShell)
   $env:DB_USERNAME="collab_user"
   $env:DB_PASSWORD="your_secure_password"
   $env:JWT_SECRET="your_super_secret_key_here"
   
   # Windows (Command Prompt)
   set DB_USERNAME=collab_user
   set DB_PASSWORD=your_secure_password
   set JWT_SECRET=your_super_secret_key_here
   
   # macOS/Linux
   export DB_USERNAME=collab_user
   export DB_PASSWORD=your_secure_password
   export JWT_SECRET=your_super_secret_key_here
   ```

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Backend**
   ```bash
   mvn spring-boot:run
   ```
   
   **Expected Output:**
   ```
   Started CollabTaskBackendApplication in X.XXX seconds
   Backend running on: http://localhost:8080
   ```

5. **Verify Backend is Running**
   ```bash
   # Test the API
   curl http://localhost:8080/api/users
   # Should return JSON response (empty array if no users)
   ```

### Step 3: Frontend Setup & Execution
1. **Open New Terminal/Command Prompt**
   ```bash
   # Navigate to project root
   cd /path/to/your/project
   
   # Navigate to frontend directory
   cd frontend
   ```

2. **Install Dependencies**
   ```bash
   npm install
   ```

3. **Start the Frontend**
   ```bash
   npm start
   ```
   
   **Expected Output:**
   ```
   Compiled successfully!
   Local:            http://localhost:3000
   On Your Network:  http://192.168.x.x:3000
   ```

4. **Verify Frontend is Running**
   - Open browser and navigate to `http://localhost:3000`
   - You should see the login page

### Step 4: Testing the System
1. **Backend API Testing**
   ```bash
   # Test Users API
   curl -X GET http://localhost:8080/api/users
   
   # Test Teams API
   curl -X GET http://localhost:8080/api/teams
   
   # Test Tasks API
   curl -X GET http://localhost:8080/api/tasks
   ```

2. **Frontend Testing**
   - Open `http://localhost:3000` in browser
   - Use the login form to select different roles
   - Test Admin, Manager, and Member dashboards

3. **Postman Collection**
   - Import `postman_collection.json` into Postman
   - Test all API endpoints systematically

### Step 5: Production Deployment (Optional)
1. **Build Frontend for Production**
   ```bash
   cd frontend
   npm run build
   ```

2. **Build Backend JAR**
   ```bash
   cd backend
   mvn clean package
   ```

3. **Run Production Backend**
   ```bash
   java -jar target/collab-task-backend-1.0.0.jar
   ```

## 🔧 Troubleshooting

### Common Issues & Solutions

1. **Port Already in Use**
   ```bash
   # Windows
   netstat -ano | findstr :8080
   taskkill /PID <PID> /F
   
   # macOS/Linux
   lsof -i :8080
   kill -9 <PID>
   ```

2. **Database Connection Failed**
   - Verify MySQL is running
   - Check credentials in environment variables
   - Ensure database `collab_task_db` exists

3. **Frontend Build Errors**
   ```bash
   # Clear npm cache
   npm cache clean --force
   
   # Delete node_modules and reinstall
   rm -rf node_modules package-lock.json
   npm install
   ```

4. **Backend Build Errors**
   ```bash
   # Clean Maven cache
   mvn clean
   
   # Update Maven dependencies
   mvn dependency:resolve
   ```

## 📱 Access URLs
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **API Documentation**: http://localhost:8080/api (when running)

## 🎯 Quick Start Commands (All in One)

### Option 1: Manual Commands
```bash
# Terminal 1 - Backend
cd backend
export DB_USERNAME=collab_user
export DB_PASSWORD=your_password
mvn spring-boot:run

# Terminal 2 - Frontend
cd frontend
npm install
npm start

# Terminal 3 - Database (if needed)
mysql -u root -p < backend/db_setup.sql
```

### Option 2: Automated Scripts (Recommended)

#### Windows Users
```cmd
# Double-click or run:
start-project.bat
```

#### Unix/Linux/macOS Users
```bash
# Make executable and run:
chmod +x start-project.sh
./start-project.sh
```

**Note**: The automated scripts will:
- Set environment variables automatically
- Start backend and frontend in separate terminals
- Handle the complete startup process

## Features
- User, Team, Task CRUD
- Role-based dashboards
- Analytics endpoints
- Round-robin assignment
- Notification simulation
- Responsive UI
- Secure authentication with JWT
- Role-based access control

## Security Features
- Environment variable configuration for sensitive data
- JWT-based authentication
- Role-based access control
- Secure database connections
- Input validation and sanitization

## Testing
- Use Postman for API testing
- Test all user roles and edge cases
- Comprehensive API collection included

## (Bonus) Docker
- Backend can be containerized (see backend README)

---
_See each folder for more details._
