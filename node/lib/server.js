const express = require('express');
const logger = require('morgan');
const parser = require('body-parser');
const cors = require('./cors');
const Database = require('./db');

class Server {
  app = null;
  db = null;

  constructor() {
    this.app = express();
    this.db = new Database();
    this.prepareApp();
    this.setupAPIEndpoints();
  }

  prepareApp() {
    this.app.set('port', process.env.PORT || 3000);
    this.app.use(cors);
    this.app.use(logger('dev'));
    this.app.use(parser.urlencoded({ extended: false }));
  }

  setupAPIEndpoints() {
    this.app.post('/foo', (req, res) => {
      res.json({success: true});
    });    
    this.app.post('/bar', (req, res) => {
      res.json({success: true});
    });   
  }

  start() {
    this.app.listen(this.app.get('port'), () => {
      console.log('Admin listening on port ' + this.app.get('port'));
    });
  }
}

module.exports = Server;