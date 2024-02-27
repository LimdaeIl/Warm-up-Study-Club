package com.group.libarayapp.repository.user;

import com.group.libarayapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    // JdbcTemplate 을 생성자에 작성하여 스프링 컨테이너가 넣어준다. : 생성자를 이용해 주입받는 방법 (권장)
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id) {
        String readSql = "select * from user where id=?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(String name, long id) {
        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);

    }

    public boolean isUserNotExist(String name) {
        String readSql = "select * from user where name=?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void deleteUser(String name) {
        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void saveUser(String name, Integer age) {
        String sql = "INSERT INTO user(name, age) VALUES(? ,?)";
        jdbcTemplate.update(sql, name, age);
    }

    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }
}

