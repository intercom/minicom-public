# Node

Welcome to the Node backend! The server is written in TypeScript and all code lives in `./node/src`.

## Setup

From the project root run `script/node/setup`

This will install dependencies and run database migrations.

## Starting the server

From the project root run `script/node/start`

The server listens on port 3000.

## Database

This project uses SQLite with [Sequelize](https://sequelize.org/) ORM. The database file is stored at `db/development.sqlite3`.

### Migrations

Migrations live in `db/migrations/` and follow the same timestamped `up`/`down` pattern as Rails:

```bash
npm run db:migrate          # Run pending migrations
npm run db:rollback         # Undo the last migration
npm run db:create-migration # Generate a new migration file
```

### Models

- `User` — `src/models/user.ts`
- `Message` — `src/models/message.ts`
- Associations defined in `src/models/index.ts`
