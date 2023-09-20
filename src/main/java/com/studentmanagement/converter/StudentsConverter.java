package com.studentmanagement.converter;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.entity.Students;
import org.springframework.stereotype.Component;

@Component
public class StudentsConverter {
    public Students toEntity (StudentsDto studentsDto){
        Students students = new Students();
        students.setStudent_name(studentsDto.getStudent_name());
        students.setStudent_date(studentsDto.getStudent_date());
        students.setStudent_sex(studentsDto.getStudent_sex());
        students.setStudent_address(studentsDto.getStudent_address());
        students.setStudent_phone(studentsDto.getStudent_phone());
        return students;
    }

    public StudentsDto toDto(Students students){
        StudentsDto studentsDto = new StudentsDto();
        if(students.getStudentId() != null){
            studentsDto.setStudentId(students.getStudentId());
        }
        studentsDto.setStudent_name(students.getStudent_name());
        studentsDto.setStudent_date(students.getStudent_date());
        studentsDto.setStudent_sex(students.getStudent_sex());
        studentsDto.setStudent_address(students.getStudent_address());
        studentsDto.setStudent_phone(students.getStudent_phone());
        return studentsDto;
    }

    public Students toEntity (StudentsDto studentsDto,Students students){
        students.setStudent_name(studentsDto.getStudent_name());
        students.setStudent_date(studentsDto.getStudent_date());
        students.setStudent_sex(studentsDto.getStudent_sex());
        students.setStudent_address(studentsDto.getStudent_address());
        students.setStudent_phone(studentsDto.getStudent_phone());
        return students;
    }
}
