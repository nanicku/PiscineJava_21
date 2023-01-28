package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.exceptions.NotSavedSubEntityException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

public class Program {
    private static Long id_id;

    public static void main(String[] args) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/Chat");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("postgres");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        User creator = new User(1L, "Felix", "123456", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(3L, "Communication", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        try {
            messagesRepository.save(message);
            System.out.println("id = " + message.getId());

        } catch (NotSavedSubEntityException e) {
            System.exit(-1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hikariDataSource.close();
    }
}
