package portfolioproject.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import portfolioproject.model.User;
import portfolioproject.service.UserService;

public class UserServiceTest {

    @Test
    public void testUpdateUser() {

        User user = new User();

        user.setUserId(1);
        user.setFullName("Poornima");
        user.setEmail("abc@gmail.com");
        user.setPhone("1234567890");

        UserService service = new UserService();

        service.updateUser(user,
                "M.M.Poornima",
                "poornima@gmail.com",
                "9876543210");

        assertEquals("M.M.Poornima", user.getFullName());

    }

}