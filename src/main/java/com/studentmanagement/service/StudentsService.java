package com.studentmanagement.service;


import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.entity.Students;

import java.util.List;

public interface StudentsService {

    List<StudentsDto> getAllStudents();

    StudentsDto saveStudent(StudentsDto studentsDto);

    Students getStudentById(Long id);

    void deleteStudentById(Long id);

}
