package com.studentmanagement.repository;

import com.studentmanagement.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers,Long> {
    Teachers findOneByTeacherId(Long teacherId);
    @Query(value = "SELECT t.* FROM teachers t LEFT JOIN courses c ON t.teacher_id = c.teacher_id WHERE c.course_id IS NULL",nativeQuery = true)
    List<Teachers> getTeachersNotCourse();
}
