package peaksoft.demo.api;

import peaksoft.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.demo.service.userService;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class Userapi {
    private final userService userService;
    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "getAllUsers";
    }
    @GetMapping("/new")
    public String createUser(Model model){
        model.addAttribute("user",new User());
        return "newUser";
    }
    @PostMapping("/save")
        public String saveUser(@ModelAttribute("user")User user){
        userService.saveUser(user);
        return "redirect:/api/users";
    }
    @GetMapping("/{id}/getUser")
    public String getUserToUpdate(@PathVariable Long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "updateUser";
    }
    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable Long id,@ModelAttribute User user){
        userService.updateUser(id,user);
        return "redirect:/api/users";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/api/users";
    }
}
