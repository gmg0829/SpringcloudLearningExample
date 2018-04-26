package application.controller;

import application.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/4/24  17:52
 */
@RestController
public class UserController {

    @Autowired
    UserClient userClient;
    @RequestMapping(value = "getUser")
    public String getUser(String name){
        String names=userClient.getName(name);
        return names;

    }

    @RequestMapping(value = "getClient")
    public String getClient(){
        return "client";

    }
}
