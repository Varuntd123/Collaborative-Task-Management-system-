#!/bin/bash

echo "========================================"
echo "Collaborative Task Management System"
echo "========================================"
echo

echo "Starting the project..."
echo

echo "Step 1: Setting environment variables..."
export DB_USERNAME=collab_user
export DB_PASSWORD=collab123
export JWT_SECRET=supersecretkey

echo "Environment variables set successfully!"
echo

echo "Step 2: Starting Backend..."
echo "Starting Spring Boot backend on port 8080..."
gnome-terminal --title="Backend" -- bash -c "cd backend && mvn spring-boot:run; exec bash" 2>/dev/null || \
xterm -title "Backend" -e "cd backend && mvn spring-boot:run; exec bash" 2>/dev/null || \
osascript -e 'tell app "Terminal" to do script "cd backend && mvn spring-boot:run"' 2>/dev/null || \
echo "Please start backend manually: cd backend && mvn spring-boot:run"

echo "Waiting for backend to start..."
sleep 10

echo "Step 3: Starting Frontend..."
echo "Starting React frontend on port 3000..."
gnome-terminal --title="Frontend" -- bash -c "cd frontend && npm start; exec bash" 2>/dev/null || \
xterm -title "Frontend" -e "cd frontend && npm start; exec bash" 2>/dev/null || \
osascript -e 'tell app "Terminal" to do script "cd frontend && npm start"' 2>/dev/null || \
echo "Please start frontend manually: cd frontend && npm start"

echo
echo "========================================"
echo "Project is starting up!"
echo "========================================"
echo
echo "Backend: http://localhost:8080"
echo "Frontend: http://localhost:3000"
echo
echo "Both terminals should open automatically."
echo "If not, start them manually using the commands above."
echo
echo "Press Enter to continue..."
read
