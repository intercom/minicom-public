const path = require('path');

module.exports = {
  development: {
    dialect: 'sqlite',
    storage: path.resolve(__dirname, '..', 'db', 'development.sqlite3'),
  },
  test: {
    dialect: 'sqlite',
    storage: ':memory:',
  },
};
