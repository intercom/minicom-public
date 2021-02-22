const low = require('lowdb');
const FileSync = require('lowdb/adapters/FileSync');
const shortid = require('shortid');
const adapter = new FileSync('db.json');
const db = low(adapter);

class Database {
  constructor() {
    db.defaults({}).write();
  }
}

module.exports = Database;
