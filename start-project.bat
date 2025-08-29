@echo off
echo ========================================
echo Collaborative Task Management System
echo ========================================
echo.

echo Starting the project...
echo.

echo Step 1: Setting environment variables...
set DB_USERNAME=collab_user
set DB_PASSWORD=collab123
set JWT_SECRET=supersecretkey

echo Environment variables set successfully!
echo.

echo Step 2: Starting Backend...
echo Starting Spring Boot backend on port 8080...
start "Backend" cmd /k "cd backend && mvn spring-boot:run"

echo Waiting for backend to start...
timeout /t 10 /nobreak > nul

echo Step 3: Starting Frontend...
echo Starting React frontend on port 3000...
start "Frontend" cmd /k "cd frontend && npm start"

echo.
echo ========================================
echo Project is starting up!
echo ========================================
echo.
echo Backend: http://localhost:8080
echo Frontend: http://localhost:3000
echo.
echo Both terminals will open automatically.
echo Close this window when done.
echo.
pause
