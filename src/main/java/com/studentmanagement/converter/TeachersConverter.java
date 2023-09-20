package com.studentmanagement.converter;

import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.entity.Teachers;
import org.springframework.stereotype.Component;

@Component
public class TeachersConverter {
    public Teachers toEntity (TeachersDto teachersDto){
        Teachers teachers = new Teachers();
        teachers.setTeacherName(teachersDto.getTeacherName());
        teachers.setTeacher_date(teachersDto.getTeacher_date());
        teachers.setTeacher_sex(teachersDto.getTeacher_sex());
        teachers.setTeacher_address(teachersDto.getTeacher_address());
        teachers.setTeacher_phone(teachersDto.getTeacher_phone());
        return teachers;
    }

    public TeachersDto toDto(Teachers teachers){
        TeachersDto teachersDto = new TeachersDto();
        if(teachers.getTeacherId() != null){
            teachersDto.setTeacherId(teachers.getTeacherId());
        }
        teachersDto.setTeacherName(teachers.getTeacherName());
        teachersDto.setTeacher_date(teachers.getTeacher_date());
        teachersDto.setTeacher_sex(teachers.getTeacher_sex());
        teachersDto.setTeacher_address(teachers.getTeacher_address());
        teachersDto.setTeacher_phone(teachers.getTeacher_phone());
        return teachersDto;
    }

    public Teachers toEntity (TeachersDto teachersDto,Teachers teachers){
        teachers.setTeacherName(teachersDto.getTeacherName());
        teachers.setTeacher_date(teachersDto.getTeacher_date());
        teachers.setTeacher_sex(teachersDto.getTeacher_sex());
        teachers.setTeacher_address(teachersDto.getTeacher_address());
        teachers.setTeacher_phone(teachersDto.getTeacher_phone());
        return teachers;
    }
}
