# 🚀 Complete Project Execution Guide

## 📋 Prerequisites Checklist
- [ ] **Java 17+** installed and configured
- [ ] **Maven 3.8+** installed and configured  
- [ ] **MySQL 8+** installed and running
- [ ] **Node.js 18+** and **npm 9+** installed
- [ ] **Git** for version control

## 🔄 Three Ways to Start the Project

### 🎯 **Method 1: Automated Scripts (Easiest)**

#### Windows Users
```cmd
# Simply double-click:
start-project.bat
```

#### Unix/Linux/macOS Users
```bash
# Make executable and run:
chmod +x start-project.sh
./start-project.sh
```

**What happens automatically:**
- ✅ Sets environment variables
- ✅ Starts backend in new terminal
- ✅ Starts frontend in new terminal
- ✅ Opens both services

### 🎯 **Method 2: Step-by-Step Manual (Recommended for learning)**

#### Step 1: Database Setup
```bash
# Start MySQL
# Windows (as Administrator)
net start mysql80

# macOS/Linux
sudo systemctl start mysql

# Create database
mysql -u root -p < backend/db_setup.sql
```

#### Step 2: Backend Setup
```bash
# Navigate to backend
cd backend

# Set environment variables
# Windows (PowerShell)
$env:DB_USERNAME="collab_user"
$env:DB_PASSWORD="your_password"
$env:JWT_SECRET="your_secret"

# macOS/Linux
export DB_USERNAME=collab_user
export DB_PASSWORD=your_password
export JWT_SECRET=your_secret

# Build and run
mvn clean install
mvn spring-boot:run
```

#### Step 3: Frontend Setup
```bash
# New terminal - navigate to frontend
cd frontend

# Install dependencies
npm install

# Start frontend
npm start
```

### 🎯 **Method 3: All-in-One Commands (Advanced)**

```bash
# Terminal 1 - Backend
cd backend && export DB_USERNAME=collab_user && export DB_PASSWORD=your_password && mvn spring-boot:run

# Terminal 2 - Frontend  
cd frontend && npm install && npm start

# Terminal 3 - Database
mysql -u root -p < backend/db_setup.sql
```

## 🔍 Verification Steps

### Backend Verification
```bash
# Test API endpoints
curl http://localhost:8080/api/users
curl http://localhost:8080/api/teams
curl http://localhost:8080/api/tasks

# Expected: JSON responses (empty arrays if no data)
```

### Frontend Verification
- Open browser to `http://localhost:3000`
- Should see login page
- Select different roles to test dashboards

## 📱 Access URLs
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **Postman Collection**: `postman_collection.json`

## 🐛 Troubleshooting Quick Fixes

### Port Already in Use
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# macOS/Linux
lsof -i :8080
kill -9 <PID>
```

### Database Connection Issues
```bash
# Check MySQL status
# Windows
sc query mysql80

# macOS/Linux
sudo systemctl status mysql
```

### Build Errors
```bash
# Backend
mvn clean
mvn dependency:resolve

# Frontend
npm cache clean --force
rm -rf node_modules package-lock.json
npm install
```

## 🎉 Success Indicators

**Backend Success:**
```
Started CollabTaskBackendApplication in X.XXX seconds
Tomcat started on port(s): 8080 (http)
```

**Frontend Success:**
```
Compiled successfully!
Local: http://localhost:3000
```

**Database Success:**
```
mysql> SHOW TABLES;
+------------------------+
| Tables_in_collab_task_db |
+------------------------+
| comment                 |
| task                    |
| team                    |
| user                    |
+------------------------+
```

## 🔒 Security Notes
- ✅ Environment variables configured
- ✅ Database credentials secured
- ✅ JWT authentication ready
- ✅ Role-based access control implemented

## 📞 Need Help?
1. Check the troubleshooting sections in README files
2. Verify all prerequisites are installed
3. Check console logs for error messages
4. Ensure MySQL is running and accessible
5. Verify ports 8080 and 3000 are free

---
**🎯 Recommendation**: Start with Method 1 (automated scripts) for the easiest experience!
