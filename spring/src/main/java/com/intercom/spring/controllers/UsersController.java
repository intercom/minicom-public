package com.intercom.spring.controllers;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercom.spring.models.Message;
import com.intercom.spring.models.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {


    @Autowired
    JdbcTemplate jdbcTemplate;


    ObjectMapper mapper = new ObjectMapper();


    @GetMapping("/admin_api/users")
    public List<User> all() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
    }


    @PostMapping("/customer_api/ping")
    public List<Message> findOrCreateUserAndReturnMessages(@RequestParam Map<String, String> param) throws IOException {
        String email = param.get("email").toString().replaceAll("\"","");
        String sql = String.format("SELECT * FROM users WHERE email = '%s'", email);
        User user = new User();
        try {
            user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
        } catch(Exception e) {
            Timestamp current =  new Timestamp(System.currentTimeMillis());
            String updateSql = String.format("INSERT INTO users (EMAIL, CREATED_AT, UPDATED_AT) VALUES ('%s', '%s', '%s')", email, current.toString(), current.toString());
            jdbcTemplate.update(updateSql);
            user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
        }
        String messages_sql = String.format("SELECT * FROM messages WHERE USER_ID = %d and MESSAGE_READ is NULL", user.getId());
        return jdbcTemplate.query(messages_sql, BeanPropertyRowMapper.newInstance(Message.class));
    }
}