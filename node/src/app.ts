import app from './server';
import sequelize from './database';

async function start() {
  await sequelize.authenticate();
  app.listen(app.get('port'), () => {
    console.log('Listening on port ' + app.get('port'));
  });
}

start();
