package com.intercom.spring.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.intercom.spring.models.Message;

import com.intercom.spring.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/admin_api/messages")
    public void createMessage(@RequestParam Map<String, String> param) {
      String content = param.get("content").toString().replaceAll("\"","");
      int user_id = Integer.parseInt(param.get("user_id"));
      Timestamp current =  new Timestamp(System.currentTimeMillis());
      String updateSql = String.format("INSERT INTO messages (USER_ID, CONTENT, CREATED_AT, UPDATED_AT) VALUES (%d, '%s', '%s', '%s')", user_id, content, current.toString(), current.toString());
      jdbcTemplate.update(updateSql);
    }

    @PostMapping("/customer_api/read")
    public void readMessage(@RequestParam Map<String, String> param) {
      int message_id = Integer.parseInt(param.get("message_id"));
      Timestamp current =  new Timestamp(System.currentTimeMillis());
      String updateSql = String.format("UPDATE messages SET MESSAGE_READ = TRUE, UPDATED_AT = '%s' WHERE id = %d", current.toString(), message_id);
      jdbcTemplate.update(updateSql);
    }
}