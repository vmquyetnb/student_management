package com.studentmanagement.controller;

import com.studentmanagement.dto.GradesDto;
import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.entity.Grades;
import com.studentmanagement.entity.Students;
import com.studentmanagement.service.CoursesService;
import com.studentmanagement.service.GradesService;
import com.studentmanagement.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @Autowired
    private GradesService gradesService;

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/students")
    public String listStudent (Model model){
        List<StudentsDto> listStudent = studentsService.getAllStudents();
        model.addAttribute("student", listStudent);
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudent (Model model){
        Students student = new Students();
        model.addAttribute("student",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") StudentsDto studentsDto) {
        studentsService.saveStudent(studentsDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent (@PathVariable Long id){
        studentsService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentsService.getStudentById(id));
        return "edit-student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") StudentsDto studentsDto,
                                Model model) {
        studentsDto.setStudentId(id);
        studentsService.saveStudent(studentsDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/grades")
    public String listGradeCourseOfStudent (@PathVariable Long studentId,Model model){
        model.addAttribute("student", gradesService.getGradesResultByStudentId(studentId));
        return "student-grade";
    }

    @GetMapping("/students/{studentId}/grades/addGrade")
    public String createGrade(@PathVariable Long studentId,Model model){
        model.addAttribute("course",coursesService.getAllCourse());
        model.addAttribute("studentId", studentId);
        Grades grades = new Grades();
        model.addAttribute("grade",grades);
        return "create-student-grade";
    }

    @PostMapping( "/students/{studentId}/grades")
    public String saveGrade(@PathVariable Long studentId,
                            @ModelAttribute("grade") GradesDto gradesDto){
        gradesDto.setStudentId(studentId);
        gradesService.saveGrade(gradesDto);
        return "redirect:/students/{studentId}/grades";
    }

    @GetMapping("/students/{studentId}/grades/edit/{gradeId}")
    public String editGradeForm(@PathVariable Long studentId,@PathVariable Long gradeId, Model model) {
        model.addAttribute("course",coursesService.getAllCourse());
        model.addAttribute("grade", gradesService.getGradeById(gradeId));
        return "edit-student-grade";
    }

    @PostMapping("/students/{studentId}/grades/{gradeId}")
    public String updateGrade(@PathVariable Long studentId,
                                @PathVariable Long gradeId,
                                @ModelAttribute("grade") GradesDto gradesDto,
                                Model model) {
        gradesDto.setGradesId(gradeId);
        gradesDto.setStudentId(studentId);
        gradesService.saveGrade(gradesDto);
        return "redirect:/students/{studentId}/grades";
    }

    @GetMapping("/students/{studentId}/grades/{gradeId}")
    public String deleteGrade (@PathVariable Long studentId,
                                            @PathVariable Long gradeId){
        gradesService.deleteGrade(gradeId);
        return "redirect:/students/{studentId}/grades";
    }

}
