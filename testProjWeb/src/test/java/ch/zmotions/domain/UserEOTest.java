package ch.zmotions.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEOTest {

    @Test
    public void testNewUser(){
        UserEO user = new UserEO();
        Assert.notNull(user);
    }
}
