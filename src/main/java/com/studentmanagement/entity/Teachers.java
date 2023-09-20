package com.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_date")
    @Temporal(TemporalType.DATE)
    private Date teacher_date;

    @Column(name = "teacher_sex")
    private String teacher_sex;

    @Column(name = "teacher_address")
    private String teacher_address;

    @Column(name = "teacher_phone")
    private String teacher_phone;

    @OneToMany(mappedBy = "teachers")
    private List<Classes> classes = new ArrayList<>();

    @OneToMany(mappedBy = "teachers")
    private List<Courses> courses = new ArrayList<>();
}
