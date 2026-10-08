package com.teologia.app.service;

import com.teologia.app.dto.CreateScheduleEventRequest;
import com.teologia.app.model.ClassGroup;
import com.teologia.app.model.ScheduleEvent;
import com.teologia.app.repository.ClassGroupRepository;
import com.teologia.app.repository.ScheduleEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleEventService {

    private final ScheduleEventRepository scheduleRepository;
    private final ClassGroupRepository classGroupRepository;

    public ScheduleEventService(ScheduleEventRepository scheduleRepository, ClassGroupRepository classGroupRepository) {
        this.scheduleRepository = scheduleRepository;
        this.classGroupRepository = classGroupRepository;
    }

    @Transactional
    public ScheduleEvent createEvent(CreateScheduleEventRequest request) {
        ClassGroup classGroup = classGroupRepository.findById(request.classGroupId())
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada."));

        ScheduleEvent event = new ScheduleEvent(
                request.title(),
                request.description(),
                request.startTime(),
                request.endTime(),
                request.locationOrLink(),
                classGroup
        );

        return scheduleRepository.save(event);
    }

    public List<ScheduleEvent> findByClassGroup(Long classGroupId) {
        return scheduleRepository.findByClassGroupId(classGroupId);
    }

    public List<ScheduleEvent> findEventsByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(LocalTime.MAX);
        return scheduleRepository.findByStartTimeBetweenOrderByStartTimeAsc(start, end);
    }
}