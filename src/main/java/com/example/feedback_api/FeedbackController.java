package com.example.feedback_api;

import jakarta.validation.Valid;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*") // allow all origins (dev)
public class FeedbackController {

    private final FeedbackRepository repository;

     // Fallback storage if DB is down (prevents 500)
    private final List<FeedbackReport> inMemory = new CopyOnWriteArrayList<>();

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

     // POST /api/feedback
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody FeedbackReport report) {
        try {
            FeedbackReport saved = repository.save(report);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (DataAccessException ex) {
            report.setId(UUID.randomUUID().toString());     // generate id manually
            inMemory.add(report);

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("stored", "memory");
            res.put("message", "DB unavailable, stored in memory temporarily");
            res.put("report", report);

            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
    }

    // GET /api/feedback
    @GetMapping
    public ResponseEntity<?> getAllFeedbacks() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (DataAccessException ex) {
            // DB down -> return fallback data
            return ResponseEntity.ok(inMemory);
        }
    }

    // Optional: health check
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
