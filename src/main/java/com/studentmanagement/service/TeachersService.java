package com.studentmanagement.service;

import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.entity.Students;
import com.studentmanagement.entity.Teachers;

import java.util.List;

public interface TeachersService {
    List<TeachersDto> getAllTeacher();

    TeachersDto saveTeacher(TeachersDto teachersDto);

    Teachers getTeacherById(Long id);

    void deleteTeacherById(Long id);
}
