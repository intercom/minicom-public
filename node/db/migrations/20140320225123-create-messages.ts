import type { QueryInterface, DataTypes as SequelizeDataTypes } from 'sequelize';

export async function up(queryInterface: QueryInterface, Sequelize: typeof SequelizeDataTypes) {
  await queryInterface.createTable('messages', {
    id: {
      type: Sequelize.INTEGER,
      primaryKey: true,
      autoIncrement: true,
      allowNull: false,
    },
    user_id: {
      type: Sequelize.INTEGER,
      allowNull: false,
      references: {
        model: 'users',
        key: 'id',
      },
    },
    content: {
      type: Sequelize.STRING,
      allowNull: false,
    },
    read: {
      type: Sequelize.BOOLEAN,
      defaultValue: false,
    },
    created_at: {
      type: Sequelize.DATE,
      allowNull: false,
    },
    updated_at: {
      type: Sequelize.DATE,
      allowNull: false,
    },
  });

  await queryInterface.addIndex('messages', ['user_id']);
}

export async function down(queryInterface: QueryInterface) {
  await queryInterface.dropTable('messages');
}
