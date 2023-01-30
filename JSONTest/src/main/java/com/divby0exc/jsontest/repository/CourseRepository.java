package com.divby0exc.jsontest.repository;

import com.divby0exc.jsontest.db.MysqlDatabase;
import com.divby0exc.jsontest.model.Course;
import com.divby0exc.jsontest.model.NullCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private Connection conn;

    public CourseRepository() {
        conn = MysqlDatabase.getInstance().getConnection();
    }

    private Course transform(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setAttendees(rs.getInt("attendees"));

        return course;
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Course course = transform(rs);
                courses.add(course);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }

    public Course get(int id) {
        Course course = null;
        String sql = "SELECT * FROM courses WHERE id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()) {
                return new NullCourse();
            }

            course = transform(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return course;
    }

    public Course save(Course course) {
        String sql = "INSERT INTO courses (name, description, attendees) VALUES (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getName());
            pstmt.setString(2, course.getDescription());
            pstmt.setInt(3, course.getAttendees());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return course;
    }
    public Course patch(Course course) {
        String sql = "UPDATE courses " +
                "SET name=?, description=?, attendees=? WHERE id=?";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            if (course.getName() != null) {
                pstmt.setString(1, course.getName());
            } else {}
            if(course.getDescription()!=null) {
                pstmt.setString(2, course.getDescription());
            }else{}
            if(course.getAttendees()!=-1) {
                pstmt.setInt(3, course.getAttendees());
            } else {}
            pstmt.setLong(4, course.getId());
            ResultSet rs = pstmt.executeQuery();

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return course;
    }
}