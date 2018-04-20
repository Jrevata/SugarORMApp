package app.sugarorm.jrevata.sugarormapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import app.sugarorm.jrevata.sugarormapp.models.User;

/**
 * Created by JORDAN on 19/04/2018.
 */

public class UserRepository {

    public static List<User> list(){
        List<User> users= SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class,id);
        return user;
    }

    public static void create(String fullname, String email, String password){
        User user = new User(fullname,email,password);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String email, String password,Long id){

        User user = SugarRecord.findById(User.class,id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);

    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class,id);
        SugarRecord.delete(id);
    }
}

