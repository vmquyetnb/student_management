package com.studentmanagement.controller;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.entity.Students;
import com.studentmanagement.entity.Teachers;
import com.studentmanagement.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping("/teachers")
    public String listTeacher (Model model){
        List<TeachersDto> listTeacher = teachersService.getAllTeacher();
        model.addAttribute("teacher", listTeacher);
        return "teachers";
    }
    @GetMapping("/teachers/new")
    public String createTeacher (Model model){
        Teachers teacher = new Teachers();
        model.addAttribute("teacher",teacher);
        return "create-teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") TeachersDto  teachersDto) {
        teachersService.saveTeacher(teachersDto);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String deleteTeacher (@PathVariable Long id){
        teachersService.deleteTeacherById(id);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", teachersService.getTeacherById(id));
        return "edit-teacher";
    }
    @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id,
                                @ModelAttribute("teacher") TeachersDto teachersDto,
                                Model model) {
        teachersDto.setTeacherId(id);
        teachersService.saveTeacher(teachersDto);
        return "redirect:/teachers";
    }

}
