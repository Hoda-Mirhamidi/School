package com.school;

import java.util.ArrayList;
import java.util.List;


public class TeacherRepository {

    List<Teacher> teachers = new ArrayList<>();

    public Teacher addSchoolToTeacher (Teacher teacher, School school){
        teacher.getSchool().add(school);
        return teacher;
    }

    public Teacher addCourseToTeacher (Teacher teacher, Course course){
        teacher.getCourse().add(course);
        return teacher;
    }






}
