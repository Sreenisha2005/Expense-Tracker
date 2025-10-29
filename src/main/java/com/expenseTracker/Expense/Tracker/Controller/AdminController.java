package com.expenseTracker.Expense.Tracker.Controller;

import com.expenseTracker.Expense.Tracker.Entity.User;
import com.expenseTracker.Expense.Tracker.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) { this.userRepository = userRepository; }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}