# Rails

Welcome to the Rails backend! For all operations other than start and setup (which are run from the project root), cd into the rails folder to run commands.

## Setup

From the project root run  `script/rails/setup`
## Starting the server

From the project root run  `script/rails/start`

## Database
(Run all the below from the rails folder. `minicom-2/rails`)
- **Create a migration.** Change the structure of the database tables. `bin/rails generate migration AddPartNumberToProducts`
- **Apply migration to database.** `rake db:migrate`
- **Reset database. Purge all data and reload tables.** `rake db:reset`
### Adding a column
Open the generated file, put an `add_column` call in the change method.

```
def change
    add_column :messages, :read, :boolean, :default => false
end
```
Apply the change to database with `rake db:migrate`

More infomation at the [Rails Documentation](https://guides.rubyonrails.org/active_record_migrations.html)
