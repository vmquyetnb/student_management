package com.studentmanagement.service;

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.entity.Courses;

import java.util.List;

public interface CoursesService {
    List<CoursesDto> getAllCourse();

    CoursesDto saveCourse(CoursesDto coursesDto);

    Courses getCoursesById(Long id);

    void deleteCourseById(Long id);
}
