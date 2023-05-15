package com.group20.coursemanagementsystem.repository;

import com.group20.coursemanagementsystem.exception.CourseNotFoundException;
import com.group20.coursemanagementsystem.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Course course) {
        return jdbcTemplate.update("insert_course(?, ?, ?, ?, ?)",
                course.getTitle(), course.getEcts(), course.isCompulsory(), course.getDescription(),
                course.getDepartment().getId());
    }

    public Course findById(Long id) {
        try {
            Course course = jdbcTemplate.queryForObject("SELECT * FROM course WHERE id = ?",
                    BeanPropertyRowMapper.newInstance(Course.class), id);

            return course;
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new CourseNotFoundException("Course not found by id: " + id);
        }
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM course WHERE id = ?", id);
    }

    public List<Course> findAll() {
        return jdbcTemplate.query("SELECT * FROM course", BeanPropertyRowMapper.newInstance(Course.class));
    }
}