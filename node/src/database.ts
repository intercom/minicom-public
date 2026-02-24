import { Sequelize } from 'sequelize';
import path from 'path';

const env = process.env.NODE_ENV || 'development';

const storage =
  env === 'test'
    ? ':memory:'
    : path.resolve(__dirname, '..', 'db', 'development.sqlite3');

const sequelize = new Sequelize({
  dialect: 'sqlite',
  storage,
  logging: false,
});

export default sequelize;
