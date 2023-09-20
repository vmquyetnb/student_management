package com.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachersDto {
    private Long teacherId;

    private String teacherName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date teacher_date;

    private String teacher_sex;

    private String teacher_address;

    private String teacher_phone;
}
