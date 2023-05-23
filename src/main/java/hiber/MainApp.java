package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new User(new Car("Chevrolet",2023),"Asja","Po","mother_of_pugs@gmail.com"));
      userService.add(new User(new Car("Mazda",6),"Lera","Voronova","nogotochki_i_resnichki@gmail.com"));
      userService.add(new User(new Car("Haval",2023),"Mary","Jane","who_is_spider_man@gmail.com"));
      userService.add(new User(new Car("Porsche",718),"Vicky","Rich","sama_kupila@gmail.com"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Chevrolet", 2023));

      context.close();
   }
}
