package com.studentmanagement.converter;

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.entity.Courses;
import org.springframework.stereotype.Component;

@Component
public class CoursesConverter {
    public Courses toEntity (CoursesDto coursesDto){
        Courses courses = new Courses();
        courses.setCourseName(coursesDto.getCourseName());
       // courses.setTeachers(coursesDto.getTeachers());
        return courses;
    }

    public CoursesDto toDto (Courses courses){
        CoursesDto coursesDto = new CoursesDto();
        if(coursesDto.getCourseId() != null){
            coursesDto.setCourseId(courses.getCourseId());
        }
        coursesDto.setCourseId(courses.getCourseId());
        coursesDto.setCourseName(courses.getCourseName());
        coursesDto.setTeacherName(courses.getTeachers().getTeacherName());
        return coursesDto;
    }

    public Courses toEntity (CoursesDto coursesDto,Courses courses){
        courses.setCourseName(coursesDto.getCourseName());
        //courses.setTeachers(coursesDto.getTeachers());
        return courses;
    }
}
