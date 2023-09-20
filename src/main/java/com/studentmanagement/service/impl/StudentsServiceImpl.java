package com.studentmanagement.service.impl;

import com.studentmanagement.converter.StudentsConverter;
import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.entity.Students;
import com.studentmanagement.repository.StudentsRepository;
import com.studentmanagement.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private StudentsConverter studentsConverter;

    @Override
    public List<StudentsDto> getAllStudents() {
        List<StudentsDto> result = new ArrayList<>();
        List<Students> students = studentsRepository.findAll();
        for(Students item : students){
            StudentsDto studentsDto = studentsConverter.toDto(item);
            result.add(studentsDto);
        }
        return result;
    }

    @Override
    public StudentsDto saveStudent(StudentsDto studentsDto) {
        Students students = new Students();
        if(studentsDto.getStudentId() !=null){
            Students oldStudent = studentsRepository.findById(studentsDto.getStudentId()).orElse(null);
            students = studentsConverter.toEntity(studentsDto, oldStudent);
        }
        else{
            students = studentsConverter.toEntity(studentsDto);
        }
        students = studentsRepository.save(students);
        return studentsConverter.toDto(students);
    }

    @Override
    public Students getStudentById(Long id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }
}
