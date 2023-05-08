package com.coco.board.presentation;

import com.coco.board.application.AdminService;
import com.coco.board.application.dto.UserDto;
import com.coco.board.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/manage")
    public String getUsers(Model model) {
        List<User> users = adminService.getUsers();
        model.addAttribute("users", users);
        return "admin/user-list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = adminService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @RequestParam String nickname, @RequestParam String email) {
        adminService.updateUser(id, nickname, email);
        return "redirect:/admin/manage";
    }
}
