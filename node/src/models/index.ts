import User from './user';
import Message from './message';

User.hasMany(Message, { foreignKey: 'user_id' });
Message.belongsTo(User, { foreignKey: 'user_id' });

export { User, Message };
