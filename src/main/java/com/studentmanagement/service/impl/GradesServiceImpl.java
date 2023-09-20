package com.studentmanagement.service.impl;

import com.studentmanagement.converter.GradesConverter;
import com.studentmanagement.dto.GradesDto;
import com.studentmanagement.entity.Courses;
import com.studentmanagement.entity.Grades;
import com.studentmanagement.entity.Students;
import com.studentmanagement.repository.CoursesRepository;
import com.studentmanagement.repository.GradesRepository;
import com.studentmanagement.repository.StudentsRepository;
import com.studentmanagement.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GradesServiceImpl implements GradesService {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private GradesConverter gradesConverter;

    @Override
    public List<GradesDto> getGradesResultByStudentId(Long studentId) {
        List<GradesDto> result = new ArrayList<>();
            List<Grades> grades = gradesRepository.getGradesResultByStudentId(studentId);
            for (Grades item : grades) {
                GradesDto gradesDto = gradesConverter.toDto(item);
                result.add(gradesDto);
            }
        return result;

    }

    @Override
    public GradesDto saveGrade(GradesDto gradesDto) {
        Grades grades = new Grades();
        if(gradesDto.getGradesId() !=null){
            Grades oldGrade = gradesRepository.findById(gradesDto.getGradesId()).orElse(null);
            grades = gradesConverter.toEntity(gradesDto, oldGrade);
        }
        else{
            grades = gradesConverter.toEntity(gradesDto);
        }
        Courses courses = coursesRepository.findOneByCourseId(gradesDto.getCourseId());
        grades.setCourses(courses);
        grades = gradesRepository.save(grades);
        return gradesConverter.toDto(grades);
    }

    @Override
    public Grades getGradeById(Long id) {
        return gradesRepository.findById(id).get();
    }

    @Override
    public void deleteGrade(Long id) {
        gradesRepository.deleteById(id);
    }

}
