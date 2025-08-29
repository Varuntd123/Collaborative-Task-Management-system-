# Collaborative Task Management System

## Overview
A full-stack collaborative task management platform with multi-user roles (Admin, Manager, Team Member), real-time task management, role-based access, analytics, and more.

## Project Structure
- `/backend` — Java Spring Boot backend (REST API, MySQL)
- `/frontend` — React.js frontend (SPA)

## 📋 Prerequisites & Installation Guides

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
1. **Using Homebrew (Recommended)**
   ```bash
   brew install --cask temurin17
   ```

2. **Manual Installation**
   - Download macOS x64 DMG from https://adoptium.net/
   - Install and set JAVA_HOME in ~/.zshrc or ~/.bash_profile

3. **Verify Installation**
   ```bash
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

### 🟢 **Node.js 18+ & npm 9+ Installation**

#### Windows
1. **Download Node.js**
   - Visit: https://nodejs.org/
   - Download LTS version (18.x or higher)
   - Run installer

2. **Verify Installation**
   ```cmd
   node --version
   npm --version
   ```

#### macOS
```bash
# Using Homebrew
brew install node

# Verify installation
node --version
npm --version
```

#### Linux (Ubuntu/Debian)
```bash
# Using NodeSource repository
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install -y nodejs

# Verify installation
node --version
npm --version
```

### 🔧 **Git Installation**

#### Windows
1. **Download Git**
   - Visit: https://git-scm.com/download/win
   - Download and install

2. **Verify Installation**
   ```cmd
   git --version
   ```

#### macOS
```bash
# Git usually comes pre-installed
# If not, install with Homebrew
brew install git

# Verify installation
git --version
```

#### Linux (Ubuntu/Debian)
```bash
# Install Git
sudo apt install git

# Verify installation
git --version
```

## 🚀 Complete Setup & Execution Guide

### Prerequisites
- **Java 17+** installed and configured ✅
- **Maven 3.8+** installed and configured ✅
- **MySQL 8+** installed and running ✅
- **Node.js 18+** and **npm 9+** installed ✅
- **Git** for version control ✅

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
   set DB_PASSWORD=collab_user
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
