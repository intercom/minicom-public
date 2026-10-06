# Java

This is the Java backend for Minicom, built with [Javalin](https://javalin.io/).

JDK 21 or newer is required to run the server.

There's nothing to be done here for the interview set-up, but feel free to look around! 👀

## Setup

From the project root run `script/java/setup`

This will verify JDK 21 or newer is installed and download all dependencies. It checks `JAVA_HOME` first (the same JDK Gradle uses), then `java` on your `PATH`.

## Starting the server

From the project root run `script/java/start`

The server listens on http://127.0.0.1:3000.

## Database

This project uses an in-memory database called H2.

For more information, check the official [H2 documentation](https://www.h2database.com/html/main.html).

The current schema and creation commands are located in `schema.sql`.

### Database credentials

_url_: `jdbc:h2:file:~/minicom`

_username_: `sa`

(no password)

### Modifying the database

If you want to make changes to the database you can do it by editing the schema file. This will involve **losing** any existing data you have. To change the database do the following steps:

   1. Edit the [schema file](https://github.com/intercom/minicom-public/blob/main/java/src/main/resources/schema.sql)
   2. Stop the server
   3. Delete the database file: `rm ~/minicom.mv.db`
   4. Restart the server, `script/java/start`
