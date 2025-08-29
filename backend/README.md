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

## 📋 Prerequisites & Installation

### 🔧 **Java 17+ Installation**

#### Windows
1. **Download OpenJDK 17**
   - Visit: https://adoptium.net/temurin/releases/
   - Download Windows x64 MSI installer
   - Run installer as Administrator

2. **Set Environment Variables**
   ```cmd
   # Set JAVA_HOME
   setx JAVA_HOME "C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot"
   
   # Add to PATH
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```

3. **Verify Installation**
   ```cmd
   java -version
   javac -version
   ```

#### macOS
```bash
# Using Homebrew (Recommended)
brew install --cask temurin17

# Verify installation
java -version
javac -version
```

#### Linux (Ubuntu/Debian)
```bash
# Update package list
sudo apt update

# Install OpenJDK 17
sudo apt install openjdk-17-jdk

# Set JAVA_HOME
echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> ~/.bashrc
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> ~/.bashrc
source ~/.bashrc

# Verify installation
java -version
javac -version
```

### 🏗️ **Maven 3.8+ Installation**

#### Windows
1. **Download Maven**
   - Visit: https://maven.apache.org/download.cgi
   - Download Binary zip archive

2. **Extract and Setup**
   ```cmd
   # Extract to C:\Program Files\Apache\maven
   # Set environment variables
   setx MAVEN_HOME "C:\Program Files\Apache\maven"
   setx PATH "%PATH%;%MAVEN_HOME%\bin"
   ```

3. **Verify Installation**
   ```cmd
   mvn -version
   ```

#### macOS
```bash
# Using Homebrew
brew install maven

# Verify installation
mvn -version
```

#### Linux (Ubuntu/Debian)
```bash
# Install Maven
sudo apt install maven

# Verify installation
mvn -version
```

### 🗄️ **MySQL 8+ Installation**

#### Windows
1. **Download MySQL Installer**
   - Visit: https://dev.mysql.com/downloads/installer/
   - Download MySQL Installer for Windows

2. **Installation Steps**
   - Run installer as Administrator
   - Choose "Developer Default" or "Server only"
   - Set root password (remember this!)
   - Complete installation

3. **Start MySQL Service**
   ```cmd
   # As Administrator
   net start mysql80
   ```

4. **Verify Installation**
   ```cmd
   mysql -u root -p
   # Enter your root password
   ```

#### macOS
```bash
# Using Homebrew
brew install mysql

# Start MySQL service
brew services start mysql

# Secure installation
mysql_secure_installation

# Verify installation
mysql -u root -p
```

#### Linux (Ubuntu/Debian)
```bash
# Install MySQL
sudo apt update
sudo apt install mysql-server

# Start MySQL service
sudo systemctl start mysql
sudo systemctl enable mysql

# Secure installation
sudo mysql_secure_installation

# Verify installation
sudo mysql -u root -p
```

## Prerequisites
- Java 17+ ✅
- Maven 3.8+ ✅
- MySQL 8+ ✅

## 🚀 Complete Setup & Execution Guide

### Step 1: Environment Setup
1. **Verify Java Installation**
   ```bash
   java -version
   # Should show Java 17 or higher
   
   mvn -version
   # Should show Maven 3.8 or higher
   ```

2. **Verify MySQL Installation**
   ```bash
   mysql --version
   # Should show MySQL 8.0 or higher
   ```

### Step 2: Database Configuration
1. **Start MySQL Service**
   ```bash
   # Windows (as Administrator)
   net start mysql80
   
   # macOS/Linux
   sudo systemctl start mysql
   # OR
   sudo service mysql start
   ```

2. **Create Database Schema**
   ```bash
   # Option 1: Direct import
   mysql -u root -p < db_setup.sql
   
   # Option 2: Interactive MySQL
   mysql -u root -p
   # Then in MySQL prompt:
   source db_setup.sql;
   exit;
   ```

3. **Verify Database Creation**
   ```bash
   mysql -u root -p
   SHOW DATABASES;
   USE collab_task_db;
   SHOW TABLES;
   # Should show: team, user, task, comment
   exit;
   ```

### Step 3: Application Configuration
1. **Set Environment Variables**
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

2. **Alternative: Edit application.properties**
   ```bash
   # Edit src/main/resources/application.properties
   # Update these lines:
   spring.datasource.username=collab_user
   spring.datasource.password=your_secure_password
   jwt.secret=your_super_secret_key_here
   ```

### Step 4: Build & Run
1. **Clean and Build**
   ```bash
   mvn clean install
   ```
   
   **Expected Output:**
   ```
   [INFO] BUILD SUCCESS
   [INFO] Total time: XX.XXX s
   ```

2. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   
   **Expected Output:**
   ```
   Started CollabTaskBackendApplication in X.XXX seconds
   Tomcat started on port(s): 8080 (http)
   Started CollabTaskBackendApplication in X.XXX seconds
   ```

3. **Verify Application is Running**
   ```bash
   # Test the API
   curl http://localhost:8080/api/users
   
   # Expected response: [] (empty array if no users)
   ```

### Step 5: Testing & Verification
1. **Test All API Endpoints**
   ```bash
   # Users API
   curl -X GET http://localhost:8080/api/users
   
   # Teams API
   curl -X GET http://localhost:8080/api/teams
   
   # Tasks API
   curl -X GET http://localhost:8080/api/tasks
   
   # Comments API
   curl -X GET http://localhost:8080/api/comments
   ```

2. **Create Test Data**
   ```bash
   # Create a team
   curl -X POST http://localhost:8080/api/teams \
     -H "Content-Type: application/json" \
     -d '{"name": "Development Team"}'
   
   # Create a user
   curl -X POST http://localhost:8080/api/users \
     -H "Content-Type: application/json" \
     -d '{"username": "admin", "email": "admin@example.com", "password": "admin123", "role": "ADMIN"}'
   ```

## 🔧 Troubleshooting

### Common Issues & Solutions

1. **Port 8080 Already in Use**
   ```bash
   # Windows
   netstat -ano | findstr :8080
   taskkill /PID <PID> /F
   
   # macOS/Linux
   lsof -i :8080
   kill -9 <PID>
   ```

2. **Database Connection Failed**
   ```bash
   # Check MySQL status
   # Windows
   sc query mysql80
   
   # macOS/Linux
   sudo systemctl status mysql
   
   # Test MySQL connection
   mysql -u collab_user -p
   ```

3. **Build Errors**
   ```bash
   # Clean Maven cache
   mvn clean
   
   # Update dependencies
   mvn dependency:resolve
   
   # Check Java version compatibility
   java -version
   ```

4. **Runtime Errors**
   ```bash
   # Check application logs
   # Look for error messages in console output
   
   # Verify environment variables
   echo $DB_USERNAME
   echo $DB_PASSWORD
   ```

### Debug Mode
1. **Enable Debug Logging**
   ```bash
   # Add to application.properties
   logging.level.com.collabtask=DEBUG
   logging.level.org.springframework.security=DEBUG
   ```

2. **Run with Debug**
   ```bash
   mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
   ```

## 📊 API Documentation

### Core Endpoints
- **Users:** `/api/users` (CRUD, get by team)
- **Teams:** `/api/teams` (CRUD)
- **Tasks:** `/api/tasks` (CRUD, by team/assignee/status)
- **Comments:** `/api/comments` (add/view by task)
- **Analytics:** `/api/tasks/analytics/completed/user/{userId}`

### Role-based Access
- **Admin**: manage users/teams
- **Manager**: assign tasks, view team progress
- **Member**: update task status, add comments

## 🐳 Docker Deployment

### Build Docker Image
```bash
docker build -t collab-task-backend .
```

### Run Docker Container
```bash
docker run -p 8080:8080 \
  -e DB_USERNAME=collab_user \
  -e DB_PASSWORD=your_password \
  -e JWT_SECRET=your_secret \
  collab-task-backend
```

### Docker Compose (Optional)
```yaml
# docker-compose.yml
version: '3.8'
services:
  backend:
    build: .
    ports:
      - "8080:8080"
    environment:
      - DB_USERNAME=collab_user
      - DB_PASSWORD=your_password
      - JWT_SECRET=your_secret
    depends_on:
      - mysql
```

## 📝 Production Notes
- Ensure MySQL is running and accessible
- JWT authentication is implemented for production
- For any issues, check logs or raise an issue in the repo
- **Security**: Never commit real credentials to version control
- Use environment variables for all sensitive configuration
- Enable HTTPS in production environments
- Set up proper monitoring and logging

