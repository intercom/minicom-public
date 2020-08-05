# Django

Welcome to the Django backend! For all operations run them from the project root folder.

## Setup

From the project root run  `script/django/setup`

## Starting the server

From the project root run  `script/django/start`

## Database

- **Database console** `./django/manage.py dbshell`
- **List tables** `.tables`
- **Show table contents** `.dump table_name`

### Adding a column

Migrations in Django rely on inferring differences between your model definitions and table schemas. They’re not great and don’t work particularly well with SQLite (the default database for this project).
We recommend you nuke and recreate your DB for schema changes:
  `rm django/db.sqlite3 && ./django/manage.py makemigrations && ./django/manage.py migrate`

  More information at the [Django documentation](https://docs.djangoproject.com/en/1.8/ref/models/fields/).