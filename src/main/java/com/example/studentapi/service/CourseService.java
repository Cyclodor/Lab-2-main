package com.example.studentapi.service;

import com.example.studentapi.model.Course;
import com.example.studentapi.repository.CourseRepository;
import com.example.studentapi.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ScheduleDAO scheduleDAO;

    @Autowired
    public CourseService(CourseRepository courseRepository, ScheduleDAO scheduleDAO) {
        this.courseRepository = courseRepository;
        this.scheduleDAO = scheduleDAO;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getExternalCourses() {
        return scheduleDAO.getStudentCourses();
    }

    public String getScheduleByGroup(String group) {
        return scheduleDAO.getScheduleByGroup(group);
    }
} 