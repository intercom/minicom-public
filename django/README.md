# Django

Welcome to the Django backend! 

There's nothing to be done here for the interview set-up, but feel free to look around! 👀

For all operations, run them from the project root folder.

## Setup

From the project root run  `script/django/setup`

## Starting the server

From the project root run  `script/django/start`

## Database

(Run all the below from the Django folder. `minicom-public/django`. Make sure the virtual env is activated: `source venv/bin/activate`)

- **Database console** `./manage.py dbshell`

Within the shell:

- **List tables** `.tables`
- **Show table contents** `.dump <table_name>`

### Adding a column

Migrations in Django rely on inferring differences between your model definitions and table schemas. They don't work particularly well with SQLite (the default database for this project).

We recommend you nuke and recreate your DB for schema changes:

```
source venv/bin/activate
rm -f ./db.sqlite3
./manage.py makemigrations
./manage.py migrate
```

More information at the [Django documentation](https://docs.djangoproject.com/en/5.1/ref/models/fields/).