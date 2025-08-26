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

## Prerequisites
- Node.js 18+
- npm 9+

## Setup Instructions
1. **Install dependencies**
   ```sh
   cd frontend
   npm install
   ```
2. **Start the development server**
   ```sh
   npm start
   ```
   The app runs on `http://localhost:3000` and proxies API calls to the backend.

## Project Structure
- `src/components/` — Dashboard components for each role, tables, forms
- `src/App.js` — Routing and layout
- `src/index.js` — App entry point
- `public/` — Static assets and HTML

## API Integration
- All API calls are proxied to `http://localhost:8080` (Spring Boot backend)
- Update proxy in `package.json` if backend runs elsewhere

## Usage
- Use the login form to select a role and demo dashboards
- For real authentication, integrate with backend JWT endpoints

## Notes
- For demo: Enter valid user/team IDs to view data
- Ensure backend is running for full functionality

## Screenshots
_Add screenshots here when available_
