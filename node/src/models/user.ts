import { Model, DataTypes, Optional } from 'sequelize';
import sequelize from '../database';

interface UserAttributes {
  id: number;
  email: string;
}

type UserCreationAttributes = Optional<UserAttributes, 'id'>;

class User extends Model<UserAttributes, UserCreationAttributes> {
  declare id: number;
  declare email: string;
  declare readonly createdAt: Date;
  declare readonly updatedAt: Date;
}

User.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    email: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    tableName: 'users',
    underscored: true,
  }
);

export default User;
