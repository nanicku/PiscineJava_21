package edu.school21;

import edu.school21.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {

        ApplicationContext context1 = new ClassPathXmlApplicationContext("context.xml");
        Printer printer1 = context1.getBean("printerWithPrefix", Printer.class);
        printer1.print ("Hello!") ;

    }
}