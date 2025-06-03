# Spring

This is the Spring backend for Minicom.

There's nothing to be done here for the interview set-up, but feel free to look around! 👀

## Setup

The start command runs any setup scripts you need.

### Required
- [Java 21 SDK](https://www.oracle.com/java/technologies/downloads/#java21) - please ensure to have JDK 21 properly installed in order to run the application.
  - If you're using [asdf](https://asdf-vm.com/) to manage runtimes, simply run `asdf install java` to get it installed.

## Starting the server

From the project root run  `script/spring/start`

## Database

This project uses an in-memory database called H2.

Access the database by navigating to http://localhost:3000/h2-console/login.jsp. The current schema and creation commands are located in `schema.sql`. To update the tables, you will have to run similar SQL commands directly in the console.

### Database credentials
If the setup script doesn't prepopulate the correct URL, be sure to use the one below.

*url*: `jdbc:h2:file:~/minicom`

*username*: `sa`

(no password)

### More information
[H2 documentation](https://www.h2database.com/html/main.html)

