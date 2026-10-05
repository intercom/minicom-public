CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(64),
  created_at  datetime,
  updated_at datetime
);

CREATE TABLE IF NOT EXISTS messages (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  user_id INTEGER,
  content VARCHAR(5000),
  message_read BOOLEAN,
  created_at  datetime,
  updated_at datetime,
  FOREIGN KEY(user_id) REFERENCES users(id)
);