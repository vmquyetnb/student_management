package com.studentmanagement.converter;

import com.studentmanagement.dto.GradesDto;
import com.studentmanagement.entity.Grades;
import org.springframework.stereotype.Component;

@Component
public class GradesConverter {
    public Grades toEntity (GradesDto gradesDto){
        Grades grades = new Grades();
        grades.setGrade_value(gradesDto.getGrade_value());
        return grades;
    }

    public GradesDto toDto(Grades grades){
        GradesDto gradesDto = new GradesDto();
        if(gradesDto.getGradesId() != null){
            gradesDto.setGradesId(grades.getGradesId());
        }
        gradesDto.setGradesId(grades.getGradesId());
        gradesDto.setGrade_value(grades.getGrade_value());
        gradesDto.setCourseName(grades.getCourses().getCourseName());
        gradesDto.setStudentId(grades.getStudents().getStudentId());
        return gradesDto;
    }

    public Grades toEntity (GradesDto gradesDto, Grades grades){
        grades.setGrade_value(gradesDto.getGrade_value());
        return grades;
    }
}
