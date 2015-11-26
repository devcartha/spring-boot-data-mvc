package tn.devcartha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.devcartha.entities.User;
import tn.devcartha.repositories.IUserRepository;
import java.util.List;

/**
 * Created by Devcartha on 11/25/2015.
 */
@Controller
public class UserController {

    @Autowired
    IUserRepository userDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView mv = new ModelAndView("registrationForm");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute User user) {
        this.userDao.save(user);
        List<User> users= this.userDao.findByUsernameOrPassword("souhail","chaouechi");
        ModelAndView mv = new ModelAndView("registrationSuccess");
        mv.addObject("users",users);
        return mv;
    }

}
