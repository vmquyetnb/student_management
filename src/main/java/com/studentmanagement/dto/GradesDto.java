package com.studentmanagement.dto;

import com.studentmanagement.entity.Courses;
import com.studentmanagement.entity.Students;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradesDto {

    private Long gradesId;

    private float grade_value;

    private Timestamp create_day;

    private Timestamp update_day;

    private Students students;

    private Courses courses;

    private Long studentId;

    private Long courseId;

    private String courseName;
}
