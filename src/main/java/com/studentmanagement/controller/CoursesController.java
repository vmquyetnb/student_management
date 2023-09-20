package com.studentmanagement.controller;

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.entity.Courses;
import com.studentmanagement.service.CoursesService;
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
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/courses")
    public String listCourses (Model model){
        List<CoursesDto> listCourses =coursesService.getAllCourse();
        model.addAttribute("course", listCourses);
        return "course";
    }
    @GetMapping("/courses/new")
    public String createCourse (Model model){
        Courses courses = new Courses();
        model.addAttribute("teacher",teachersService.getAllTeacher());
        model.addAttribute("course",courses);
        return "create-course";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") CoursesDto  coursesDto) {
        coursesService.saveCourse(coursesDto);
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable("id") Long id, Model model){
        coursesService.deleteCourseById(id);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher",teachersService.getAllTeacher());
        model.addAttribute("course", coursesService.getCoursesById(id));
        return "edit-course";
    }
    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable("id")  Long id,
                                @ModelAttribute("course") CoursesDto coursesDto,
                                Model model) {
        coursesDto.setCourseId(id);
        coursesService.saveCourse(coursesDto);
        return "redirect:/courses";
    }


}
