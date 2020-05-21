package com.itmck.web;

import com.itmck.pojo.Book;
import com.itmck.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by it_mck 2019/10/15 19:28
 *
 * @Description:
 * @Version: 1.0
 */
//@ApiIgnore
@Controller
@RequestMapping("/thy")
public class TestController {


    @Autowired
    private Book book;


    @RequestMapping("/book")
    @ResponseBody
    public String bookinfo() {

        return book.toString();
    }


    @RequestMapping("/tt")
    public String indexPage() {

        return "index";
    }

    @RequestMapping("/pojo")
    public @ResponseBody
    String indexPojo() {

        return "index";
    }

    @GetMapping("/u")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("javaboy:" + i);
            users.add(u);
        }
        model.addAttribute("users", users);
        return "/main/mainpage";
    }
}
