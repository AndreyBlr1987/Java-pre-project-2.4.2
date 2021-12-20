package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("usersList", users);
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("role", roleService.getAllRoles());
        return "editPage";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user, @RequestParam("roles") String[] role) {
        user.setRoles(roleService.getSetOfRoles(role));
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/add")
    public String addPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("role", roleService.getAllRoles());
        return "new";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute User user, @RequestParam("roles") String[] role) {
        user.setRoles(roleService.getSetOfRoles(role));
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin";
    }


}

