package org.vtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vtech.entity.Courses;

@Repository
public interface CourseRepository extends CrudRepository<Courses, Integer> {

	@Query(value = "select * from courses_student where course_id=:COURSE_ID and student_id=:STUDENT_ID", nativeQuery = true)
	List<Object> findCoursesStudent(@Param("COURSE_ID") int COURSE_ID, @Param("STUDENT_ID") int STUDENT_ID);
	
	Courses findById(int id);
	
	@Query(value="select course_id from courses_student where course_id in(1,2,3) and student_id=:STUDENT_ID", nativeQuery = true)
	int[] getEnrolledCourseId(@Param("STUDENT_ID") int STUDENT_ID);
}
