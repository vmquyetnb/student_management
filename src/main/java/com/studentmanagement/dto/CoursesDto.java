package com.studentmanagement.dto;

import com.studentmanagement.entity.Teachers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto {

    private Long courseId;

    private String courseName;

    private Long teacherId;

    private String teacherName;

    private Teachers teachers;

}
