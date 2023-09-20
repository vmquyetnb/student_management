package com.studentmanagement.repository;

import com.studentmanagement.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesRepository extends JpaRepository<Grades,Long> {
    @Query(value = "select s.student_name,c.course_name,g.student_id,g.course_id,g.grades_id,g.grade_value,g.create_day,g.update_day from  grades g \n" +
            "            inner join students s on s.student_id = g.student_id\n" +
            "            inner join courses c on c.course_id = g.course_id where g.student_id = ?1",nativeQuery = true)
    List<Grades> getGradesResultByStudentId( Long studentId);
}
