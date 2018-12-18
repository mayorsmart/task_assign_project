package com.taskapptest;


import com.task.entities.Task;
import com.task.entities.User;
import com.task.services.TaskService;
import com.task.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskProjectTest {


    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb(){

        {
            User newUser = new User("testuser@mail.com","testuser","123456");
            userService.createUser(newUser);
        }

        {
            User newUser = new User("testadmin@mail.com","testadmin","123456");
            userService.createUser(newUser);
        }

        Task userTask = new Task("06/12/2018","0:11","11:00","i am working");
        User user = userService.findOne("testuer@mail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser(){

        User user = userService.findOne("testuser@mail.com");
        assertNotNull(user);
        User admin = userService.findOne("testadmin@mail.com");
        assertEquals(admin.getEmail(),"testadmin@mail.com");

    }

    @Test
    public void testTask(){
        User user = userService.findOne("testuser@mail.com");
        List<Task> tasks = taskService.findUserTask(user);
        assertNotNull(tasks);
    }



}
