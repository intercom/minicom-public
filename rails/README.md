# Rails

Welcome to the Rails backend! 

There's nothing to be done here for the interview set-up, but feel free to look around! 👀

## Setup

From the project root run  `script/rails/setup`

## Starting the server

From the project root run  `script/rails/start`

For all operations other than start and setup, cd into the `rails` folder to run commands.

## Database
Run all the below from the Rails folder.
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
Apply the change with `rake db:migrate`

### More information

 [Rails Documentation](https://guides.rubyonrails.org/active_record_migrations.html)
