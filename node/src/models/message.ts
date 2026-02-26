import { Model, DataTypes, Optional } from 'sequelize';
import sequelize from '../database';

interface MessageAttributes {
  id: number;
  user_id: number;
  content: string;
  read: boolean;
}

type MessageCreationAttributes = Optional<MessageAttributes, 'id' | 'read'>;

class Message extends Model<MessageAttributes, MessageCreationAttributes> {
  declare id: number;
  declare user_id: number;
  declare content: string;
  declare read: boolean;
  declare readonly createdAt: Date;
  declare readonly updatedAt: Date;
}

Message.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    user_id: {
      type: DataTypes.INTEGER,
      allowNull: false,
    },
    content: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    read: {
      type: DataTypes.BOOLEAN,
      defaultValue: false,
    },
  },
  {
    sequelize,
    tableName: 'messages',
    underscored: true,
  }
);

export default Message;
