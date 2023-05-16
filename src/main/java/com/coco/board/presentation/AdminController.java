package com.coco.board.presentation;

import com.coco.board.application.AdminService;
import com.coco.board.application.dto.UserDto;
import com.coco.board.application.security.auth.LoginUser;
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
    public String getUsers(Model model, @LoginUser UserDto.Response user) {

        if (user != null) {
            model.addAttribute("user", user);
        }

        List<User> users = adminService.getUsers();
        model.addAttribute("users", users);
        return "admin/user-list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin/manage";
    }

}
