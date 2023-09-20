package com.studentmanagement.service;

import com.studentmanagement.dto.GradesDto;
import com.studentmanagement.entity.Grades;

import java.util.List;

public interface GradesService {
    List<GradesDto> getGradesResultByStudentId(Long studentId);

    GradesDto saveGrade(GradesDto gradesDto);

    Grades getGradeById(Long id);

    void deleteGrade(Long id);
}
