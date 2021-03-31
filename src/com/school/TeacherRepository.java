package com.school;

import com.school.enums.TeacherType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


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

    public List<Teacher> aboveAverageSalary (){
        List<Teacher> filteredTeacherList = new ArrayList<>();
        OptionalDouble average = teachers.stream().filter(teacher -> teacher.getType().equals(TeacherType.FULL_TIME)).mapToDouble(Teacher::calculateSalary).average();
        if(average.isPresent()){
            filteredTeacherList = teachers.stream().filter(teacher -> teacher.calculateSalary() > average.getAsDouble()).collect(Collectors.toList());
        }
        return filteredTeacherList;
    }

    public Map<TeacherType,List<Teacher>> moreThanTenYearsExperienceTeachers (){
        return teachers.stream().collect(Collectors.toMap(Teacher::getType, teacher -> teachers.stream().filter(teacher1 -> teacher1.getExperienceYear()==10).collect(Collectors.toList())));
    }






}
