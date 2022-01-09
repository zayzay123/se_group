package fcu.sep.fcushop;

import fcu.sep.fcushop.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserModelTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testUserId() {
        String expectedOutput = "AB00000001";
        user.setId("AB00000001");
        String actualOutput = user.getId();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUserName() {
        String expectedOutput = "kamiki";
        user.setName("kamiki");
        String actualOutput = user.getName();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUserAccunt() {
        String expectedOutput = "kamiki01";
        user.setAccount("kamiki01");
        String actualOutput = user.getAccount();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUserpassword() {
        String expectedOutput = "Aasd159753";
        user.setPassword("Aasd159753");
        String actualOutput = user.getPassword();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUserEmail() {
        String expectedOutput = "kamiki01@gmail.com";
        user.setEmail("kamiki01@gmail.com");
        String actualOutput = user.getEmail();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUserPhoneNumber() {
        String expectedOutput = "0923459878";
        user.setPhoneNumber("0923459878");
        String actualOutput = user.getPhoneNumber();
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
