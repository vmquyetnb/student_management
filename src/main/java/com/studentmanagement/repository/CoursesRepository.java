package com.studentmanagement.repository;

import com.studentmanagement.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {
    Courses findOneByCourseId(Long courseId);
    @Query(value = "select c.course_id,c.course_name,t.teacher_name from courses c left join teachers t on t.teacher_id=c.teacher_id  where c.course_id=?1", nativeQuery = true)
    Courses findCoursesAndTeacherOrderByCourseId(Long id);
//    @Query(value = "select c.course_id,c.course_name,c.teacher_id,t.teacher_name from courses c inner join teachers t on t.teacher_id = c.teacher_id where c.course_id = ?1", nativeQuery = true)
//    List<Courses> getAllCoursesAndTeacherByCourseId(Long courseId);
}
