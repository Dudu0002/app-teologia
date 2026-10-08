package com.teologia.app.controller;

import com.teologia.app.dto.CreateScheduleEventRequest;
import com.teologia.app.model.ScheduleEvent;
import com.teologia.app.service.ScheduleEventService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    private final ScheduleEventService scheduleService;

    public ScheduleController(ScheduleEventService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleEvent> createEvent(@Valid @RequestBody CreateScheduleEventRequest request) {
        ScheduleEvent created = scheduleService.createEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/class-group/{classGroupId}")
    public ResponseEntity<List<ScheduleEvent>> getEventsByClassGroup(@PathVariable Long classGroupId) {
        return ResponseEntity.ok(scheduleService.findByClassGroup(classGroupId));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ScheduleEvent>> getEventsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(scheduleService.findEventsByDateRange(startDate, endDate));
    }
}