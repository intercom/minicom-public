# Minicom

Welcome to Minicom! A prototype Intercom service. Inside this directory you'll find a foo website, and bar website and servers that represents a simplified version of how Intercom works.

## Installation

choose your preferred framework. The current choices available are:
```
rails
spring
node
django
```
anywhere you see `{your-framework}` in the instructions below, replace it with the keyword above.

Run the command that matches your framework to install it.

```
# Mac/Linux/Windows with WSL (Windows Subsystem for Linux)
script/{your-framework}/setup

# Windows without WSL (Windows Subsystem for Linux)
script\{your-framework}\setup

(examples)

script/rails/setup
script/spring/setup
script/node/setup
script/django/setup
```

## Getting started

run the following in 3 different terminal windows:

```
script/foo/start
script/bar/start
script/{your-framework}/start
```

This will get you the foo site running at http://127.0.0.1:8008, the bar interface running at http://127.0.0.1:8009 and a webserver running at http://127.0.0.1:3000.

## Structure

A quick overview of the application structure:

- **foo/** -- The root of the foo interface.
- **bar/** -- The root of the bar website.

Your framework will have a folder with it's name and have 2 endpoints:

- **POST /foo/** (validates that the frontend can talk to backend)
- **POST /bar/** (validates that the frontend can talk to backend)

## Folders

Each Server framework is in its own folder (named after the framework) and has its own readme. You can safely ignore anything in the frameworks that you are not using.

- [Rails](./rails/README.md)
- [Spring](./spring/README.md)
- [Django](./django/README.md)
- [Node](./node/README.md)

## Prototype!

This is just a prototype implementation.
