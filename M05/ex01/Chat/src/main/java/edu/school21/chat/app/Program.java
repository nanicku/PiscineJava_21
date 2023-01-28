package edu.school21.chat.app;

import edu.school21.chat.models.Message;

import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;

import java.util.Optional;
import java.util.Scanner;

import com.zaxxer.hikari.HikariDataSource;

public class Program {
    private static Long id_id;

    public static void main(String[] args) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/Chat");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("postgres");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message ID\n-> ");
            id_id = scanner.nextLong();
        } catch (Exception e) {
            System.out.println("Sorry, it is not number..");
            hikariDataSource.close();
            System.exit(-1);
        }

        MessagesRepository message = new MessagesRepositoryJdbcImpl(hikariDataSource);
        try {
            Optional<Message> msg = message.findById(id_id);
            if (msg.isPresent()) {
                System.out.println(msg.get().toString());
            }
        } catch (Exception e) {
            System.out.println("Message not found");
            hikariDataSource.close();
            System.exit(-1);
        }
        hikariDataSource.close();
    }
}
