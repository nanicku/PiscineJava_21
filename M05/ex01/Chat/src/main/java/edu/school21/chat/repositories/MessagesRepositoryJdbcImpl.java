package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    private void closeConnections(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        rs.close();
        ps.close();
        conn.close();
    }

    private static final String SQL_SELECT_BY_ID =
            "SELECT * , users.id as id, chatrooms.id as id_room " +
                    "FROM messages " +
                    "	LEFT JOIN users ON messages.author = users.id \n" +
                    "	LEFT JOIN chatrooms ON messages.room = chatrooms.id\n " +
                    "WHERE messages.id=?";

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                closeConnections(resultSet, statement, connection);
                return null;
            }

            Message message = new Message();

            Long userId = resultSet.getLong(2);
            String userLogin = resultSet.getString("Login");
            String userPassword = resultSet.getString("Password");
            Long roomId = resultSet.getLong(3);
            String roomName = resultSet.getString("Name");

            User user = new User(userId, userLogin, userPassword);
            Chatroom chatRoom = new Chatroom(roomId, roomName);

            message.setId(resultSet.getLong(1));
            message.setAuthor(user);
            message.setRoom(chatRoom);
            message.setText(resultSet.getString(4));
            message.setDate(resultSet.getTimestamp(5).toLocalDateTime());

            closeConnections(resultSet, statement, connection);
            return Optional.of(message);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }
}
