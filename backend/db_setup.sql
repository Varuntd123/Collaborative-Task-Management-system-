-- Collaborative Task Management System DB Schema
CREATE DATABASE IF NOT EXISTS collab_task_db;
USE collab_task_db;

CREATE TABLE IF NOT EXISTS team (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    team_id BIGINT,
    role VARCHAR(20) NOT NULL,
    FOREIGN KEY (team_id) REFERENCES team(id)
);

CREATE TABLE IF NOT EXISTS task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    team_id BIGINT,
    assignee_id BIGINT,
    status VARCHAR(20),
    due_date DATETIME,
    created_at DATETIME,
    updated_at DATETIME,
    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY (assignee_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS comment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    task_id BIGINT,
    user_id BIGINT,
    content VARCHAR(1000) NOT NULL,
    created_at DATETIME,
    FOREIGN KEY (task_id) REFERENCES task(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);
