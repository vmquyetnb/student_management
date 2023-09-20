package com.studentmanagement.service.impl;

import com.studentmanagement.converter.TeachersConverter;
import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.entity.Students;
import com.studentmanagement.entity.Teachers;
import com.studentmanagement.repository.TeachersRepository;
import com.studentmanagement.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private TeachersConverter teachersConverter;

    @Override
    public List<TeachersDto> getAllTeacher() {
        List<TeachersDto> result = new ArrayList<>();
        List<Teachers> teachers = teachersRepository.findAll();
        for(Teachers item : teachers){
            TeachersDto teachersDto = teachersConverter.toDto(item);
            result.add(teachersDto);
        }
        return result;
    }


    @Override
    public TeachersDto saveTeacher(TeachersDto teachersDto) {
        Teachers teachers = new Teachers();
        if(teachersDto.getTeacherId() !=null){
            Teachers oldTeacher = teachersRepository.findById(teachersDto.getTeacherId()).orElse(null);
            teachers = teachersConverter.toEntity(teachersDto, oldTeacher);
        }
        else{
            teachers = teachersConverter.toEntity(teachersDto);
        }
        teachers = teachersRepository.save(teachers);
        return teachersConverter.toDto(teachers);
    }

    @Override
    public Teachers getTeacherById(Long id) {
        return teachersRepository.findById(id).get();
    }

    @Override
    public void deleteTeacherById(Long id) {
        teachersRepository.deleteById(id);
    }
}
