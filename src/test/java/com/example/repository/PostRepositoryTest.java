package com.example.repository;

import com.example.MysqltimezoneApplication;
import com.example.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MysqltimezoneApplication.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @Test
    public void test() {
        Post post = new Post();
        post.setPostDate(new Date());
        post.setTitle("First Post");
        post.setValidDate(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        final ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        post.setExpiryDate(zonedDateTime.toLocalDateTime());
        post.setModifiedDate(zonedDateTime);
        repository.save(post);

        Post dbpost = repository.findOne(post.getPostId());
        assertNotNull(dbpost);
        System.out.println(dbpost.getTitle());
    }

}