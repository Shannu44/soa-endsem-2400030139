-- Run this after creating the database userdb in pgAdmin.
-- The Spring Boot application creates the users table automatically.
-- If the table already exists, this inserts two sample users.

INSERT INTO users (username, name, email, password)
VALUES
('shannu44', 'Shannu', 'shannu@gmail.com', 'sample-password-1'),
('ravi22', 'Ravi', 'ravi@gmail.com', 'sample-password-2')
ON CONFLICT (username) DO NOTHING;
