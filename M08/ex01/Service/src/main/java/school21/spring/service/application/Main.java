package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

import java.sql.SQLException;

public class Main   {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("\nusersRepositoryJdbc");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        System.out.println(usersRepository.findAll());

        usersRepository = context.getBean("UsersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll());

    }

}
