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
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String student_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "student_date")
    private Date student_date;

    @Column(name = "student_sex")
    private String student_sex;

    @Column(name = "student_address")
    private String student_address;

    @Column(name = "student_phone")
    private String student_phone;

    @ManyToMany(mappedBy = "students")
    List<Classes> classes = new ArrayList<>();

    @OneToMany(mappedBy = "students")
    List<Grades> grades = new ArrayList<>();
}
