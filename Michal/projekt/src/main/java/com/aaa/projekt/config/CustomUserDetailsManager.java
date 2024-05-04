package com.aaa.projekt.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomUserDetailsManager extends JdbcUserDetailsManager {

    private final JdbcTemplate jdbcTemplate;
    public CustomUserDetailsManager(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<CustomUserDetails> users = jdbcTemplate.query(
                "select * from users where username = ?",
                new String[]{username},
                new RowMapper<CustomUserDetails>() {
                    @Override
                    public CustomUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        String email = rs.getString("email");
                        boolean enabled = rs.getBoolean("enabled");


                        List<GrantedAuthority> authorities = jdbcTemplate.query(
                                "select authority from authorities where username = ?",
                                new String[]{username},
                                (resultSet, i) -> new SimpleGrantedAuthority(resultSet.getString("authority"))
                        );


                        return new CustomUserDetails(username, password, email, enabled, authorities);
                    }
                });
        if (users.isEmpty()) {
            return null;
        }

        CustomUserDetails customUserDetails = users.get(0);
        return new User(customUserDetails.getUsername(), customUserDetails.getPassword(), customUserDetails.isEnabled(), true, true, true, customUserDetails.getAuthorities());
    }


    public void insertUser(String username, String password, String email, boolean enabled, GrantedAuthority authority) {

        jdbcTemplate.update(
                "INSERT INTO users (username, password, email, enabled) VALUES (?, ?, ?, ?)",
                username, password, email, enabled);


        jdbcTemplate.update(
                "INSERT INTO authorities (username, authority) VALUES (?, ?)",
                username, authority.getAuthority());
    }

    public void saveUser(CustomUserDetails userDetails) {

        insertUser(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getEmail(),
                userDetails.isEnabled(),
                userDetails.getAuthorities().isEmpty() ? null : userDetails.getAuthorities().iterator().next());
    }


}

