package com.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsDto {
    private Long studentId;

    private String student_name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date student_date;

    private String student_sex;

    private String student_address;

    private String student_phone;

}
