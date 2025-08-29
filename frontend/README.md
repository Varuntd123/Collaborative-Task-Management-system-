# Collaborative Task Management System - Frontend

## Overview
This is the React.js frontend for the Collaborative Task Management System. It provides a clean, responsive UI for Admin, Manager, and Team Member roles, with role-based dashboards and real-time task management features.

## Features
- Login with role selection (demo)
- Admin dashboard: manage users and teams
- Manager dashboard: assign tasks, view team progress
- Member dashboard: view/update assigned tasks, add comments
- Responsive tables and forms
- API integration with Spring Boot backend
- Secure authentication handling
- Role-based access control

## 📋 Prerequisites & Installation

### 🟢 **Node.js 18+ & npm 9+ Installation**

#### Windows
1. **Download Node.js**
   - Visit: https://nodejs.org/
   - Download LTS version (18.x or higher)
   - Run installer with default settings

2. **Verify Installation**
   ```cmd
   node --version
   npm --version
   ```

3. **Update npm (if needed)**
   ```cmd
   npm install -g npm@latest
   ```

#### macOS
```bash
# Using Homebrew (Recommended)
brew install node

# Alternative: Using Node Version Manager (nvm)
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
source ~/.zshrc  # or ~/.bash_profile
nvm install 18
nvm use 18

# Verify installation
node --version
npm --version
```

#### Linux (Ubuntu/Debian)
```bash
# Using NodeSource repository (Recommended)
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install -y nodejs

# Alternative: Using snap
sudo snap install node --classic

# Verify installation
node --version
npm --version
```

### 🔧 **Git Installation (if not already installed)**

#### Windows
1. **Download Git**
   - Visit: https://git-scm.com/download/win
   - Download and install with default settings

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

## Prerequisites
- Node.js 18+ ✅
- npm 9+ ✅

## 🚀 Complete Setup & Execution Guide

### Step 1: Environment Setup
1. **Verify Node.js Installation**
   ```bash
   node --version
   # Should show Node.js 18 or higher
   
   npm --version
   # Should show npm 9 or higher
   ```

2. **Verify Backend is Running**
   ```bash
   # Ensure backend is running on port 8080
   curl http://localhost:8080/api/users
   # Should return JSON response
   ```

### Step 2: Frontend Setup
1. **Navigate to Frontend Directory**
   ```bash
   cd frontend
   ```

2. **Install Dependencies**
   ```bash
   npm install
   ```
   
   **Expected Output:**
   ```
   added XXX packages, and audited XXX packages in Xs
   found 0 vulnerabilities
   ```

3. **Verify package.json Configuration**
   ```bash
   # Check proxy setting points to backend
   cat package.json | grep proxy
   # Should show: "proxy": "http://localhost:8080"
   ```

### Step 3: Start Development Server
1. **Start the Application**
   ```bash
   npm start
   ```
   
   **Expected Output:**
   ```
   Compiled successfully!
   
   Local:            http://localhost:3000
   On Your Network:  http://192.168.x.x:3000
   
   Note that the development build is not optimized.
   To create a production build, use npm run build.
   ```

2. **Verify Frontend is Running**
   - Open browser and navigate to `http://localhost:3000`
   - You should see the login page
   - Check browser console for any errors

### Step 4: Testing & Verification
1. **Test Login Functionality**
   - Select different roles (Admin, Manager, Member)
   - Verify role-based dashboard access
   - Check that API calls are working

2. **Test API Integration**
   ```bash
   # In browser console, verify API calls
   # Should see requests to http://localhost:8080/api/*
   ```

3. **Test Responsive Design**
   - Resize browser window
   - Test on mobile viewport
   - Verify tables and forms are responsive

### Step 5: Production Build (Optional)
1. **Create Production Build**
   ```bash
   npm run build
   ```
   
   **Expected Output:**
   ```
   Compiled successfully.
   
   File sizes after gzip:
   
   build/static/js/main.XXXXX.js    XX.X KB
   build/static/css/main.XXXXX.css  X.X KB
   ```

2. **Serve Production Build**
   ```bash
   # Install serve globally
   npm install -g serve
   
   # Serve the build folder
   serve -s build -l 3000
   ```

## 🔧 Troubleshooting

### Common Issues & Solutions

1. **Port 3000 Already in Use**
   ```bash
   # Windows
   netstat -ano | findstr :3000
   taskkill /PID <PID> /F
   
   # macOS/Linux
   lsof -i :3000
   kill -9 <PID>
   ```

2. **Backend Connection Failed**
   ```bash
   # Verify backend is running
   curl http://localhost:8080/api/users
   
   # Check proxy setting in package.json
   cat package.json | grep proxy
   ```

3. **Build Errors**
   ```bash
   # Clear npm cache
   npm cache clean --force
   
   # Delete node_modules and reinstall
   rm -rf node_modules package-lock.json
   npm install
   ```

4. **Runtime Errors**
   ```bash
   # Check browser console for errors
   # Verify all dependencies are installed
   npm list
   ```

### Debug Mode
1. **Enable React Developer Tools**
   - Install React Developer Tools browser extension
   - Use browser console for debugging

2. **Environment Variables**
   ```bash
   # Create .env file for custom configuration
   echo "REACT_APP_API_URL=http://localhost:8080" > .env
   ```

## 📱 Access URLs
- **Development**: http://localhost:3000
- **Production Build**: http://localhost:3000 (after npm run build)
- **Backend API**: http://localhost:8080

## Security Features
- **Environment Variables**: Configure sensitive data via environment variables
- **HTTPS**: Use HTTPS in production environments
- **Input Validation**: All user inputs are validated
- **XSS Protection**: Built-in React XSS protection
- **CORS**: Proper CORS configuration with backend

## Project Structure
- `src/components/` — Dashboard components for each role, tables, forms
- `src/App.js` — Routing and layout
- `src/index.js` — App entry point
- `public/` — Static assets and HTML

## API Integration
- All API calls are proxied to `http://localhost:8080` (Spring Boot backend)
- Update proxy in `package.json` if backend runs elsewhere
- Secure authentication token handling
- Error handling and user feedback

## Usage
- Use the login form to select a role and demo dashboards
- For real authentication, integrate with backend JWT endpoints
- All user actions are logged for security monitoring

## Security Best Practices
- Never store sensitive data in localStorage
- Implement proper session management
- Use HTTPS in production
- Regular dependency updates
- Input sanitization and validation

## 📝 Notes
- For demo: Enter valid user/team IDs to view data
- Ensure backend is running for full functionality
- Check browser console for any errors
- Monitor network requests for security issues
- The app automatically proxies API calls to the backend

## Screenshots
_Add screenshots here when available_
