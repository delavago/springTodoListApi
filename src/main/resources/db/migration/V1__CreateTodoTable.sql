CREATE TABLE IF NOT EXISTS todo (
       id UUID PRIMARY KEY NOT NULL,
       title VARCHAR(50) NOT NULL,
       description VARCHAR(200)
);