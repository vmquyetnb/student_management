package com.studentmanagement.service.impl;

import com.studentmanagement.converter.CoursesConverter;
import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.entity.Courses;
import com.studentmanagement.entity.Students;
import com.studentmanagement.entity.Teachers;
import com.studentmanagement.repository.CoursesRepository;
import com.studentmanagement.repository.TeachersRepository;
import com.studentmanagement.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    public CoursesRepository coursesRepository;

    @Autowired
    public TeachersRepository teachersRepository;

    @Autowired
    public CoursesConverter coursesConverter;

    @Override
    public List<CoursesDto> getAllCourse() {
        List<CoursesDto> result = new ArrayList<>();
        List<Courses> courses = coursesRepository.findAll();
        for(Courses item : courses){
            CoursesDto coursesDto = coursesConverter.toDto(item);
            result.add(coursesDto);
        }
        return result;
    }

    @Override
    public CoursesDto saveCourse(CoursesDto coursesDto) {
        Courses courses = new Courses();
        if(coursesDto.getCourseId() !=null){
            Courses oldCourse = coursesRepository.findById(coursesDto.getCourseId()).orElse(null);
            courses = coursesConverter.toEntity(coursesDto, oldCourse);
        }
        else{
            courses = coursesConverter.toEntity(coursesDto);
        }
        Teachers teachers = teachersRepository.findOneByTeacherId(coursesDto.getTeacherId());
        courses.setTeachers(teachers);
        courses = coursesRepository.save(courses);
        return coursesConverter.toDto(courses);
    }

    @Override
    public Courses getCoursesById(Long id) {
        return  coursesRepository.findById(id).get();
    }

    @Override
    public void deleteCourseById(Long courseId) {
        coursesRepository.deleteById(courseId);
    }
}
