package com.expenseTracker.Expense.Tracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {
    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) { this.assistantService = assistantService; }

    @PostMapping
    public ResponseEntity<?> ask(@RequestBody AssistantRequest req, Authentication auth) {
        String username = auth != null ? auth.getName() : req.getUsername();
        var result = assistantService.handle(username, req.getQuestion());
        return ResponseEntity.ok(result);
    }

    // public assistant endpoint (e.g., pre-auth help pages)
    @PostMapping("/public/help")
    public ResponseEntity<?> publicHelp(@RequestBody AssistantRequest req) {
        var result = assistantService.handle(req.getUsername(), req.getQuestion());
        return ResponseEntity.ok(result);
    }
}