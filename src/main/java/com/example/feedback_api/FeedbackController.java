package com.example.feedback_api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*") // allow all origins (dev)
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    // 1) Create new feedback
    // POST http://<PC_IP>:8083/api/feedback
    @PostMapping
    public FeedbackReport create(@RequestBody FeedbackReport report) {
        return repository.save(report);
    }

    // 2) Get all feedbacks
    // GET http://<PC_IP>:8083/api/feedback
    @GetMapping
    public List<FeedbackReport> getAllFeedbacks() {
        return repository.findAll();
    }
}
