package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import serivce.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",iUserService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute User user) {
        iUserService.save(user);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", iUserService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute User user) {
        iUserService.edit(user);
        return new ModelAndView("redirect:/show");
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iUserService.findAllByUserName(findName));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iUserService.delete(iUserService.findById(id));
        return new ModelAndView("redirect:/show");
    }


}
