package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> findUserByUsername(String username){
        // List<User> userList = new LinkedList<>();
        String findByUsernameSQL = "select * from user where username = ?";

        // BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        // List<User> Users = jdbcTemplate.query(findByUsernameSQL, rowMapper, username);
        SqlRowSet rs = jdbcTemplate.queryForRowSet(findByUsernameSQL, username);

        if(!rs.next()){
            return Optional.empty(); 
        }

        User user = new User();
        user.setUserId(rs.getString("user_id")); 
        user.setUsername(rs.getString("username")); 
        user.setName(rs.getString("name")); 
        
        return Optional.of(user);
    }

    public String insertUser(User user){

        String insertSQL = "insert into user (user_id, username) values (?, ?)";

        String genId = UUID.randomUUID().toString().substring(0, 8);

        user.setUserId(genId);
        
        jdbcTemplate.update(insertSQL, user.getUserId(), user.getUsername());

        return genId; 

    }
}


