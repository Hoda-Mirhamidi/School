package com.school;

import com.school.enums.TeacherType;

import java.util.*;
import java.util.stream.Collectors;


public class TeacherRepository {

    public List<Teacher> teachers = new ArrayList<>();

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

        List<Teacher> fullTimeList = teachers.stream().filter(teacher -> teacher.getType()==TeacherType.FULL_TIME).filter(teacher -> teacher.getExperienceYear()==10).collect(Collectors.toList());
        List<Teacher> partTimeList = teachers.stream().filter(teacher -> teacher.getType()==TeacherType.PART_TIME).filter(teacher -> teacher.getExperienceYear()==10).collect(Collectors.toList());
        Map<TeacherType,List<Teacher>> teacherTypeListMap = new HashMap<>();
        teacherTypeListMap.put(TeacherType.FULL_TIME,fullTimeList);
        teacherTypeListMap.put(TeacherType.PART_TIME,partTimeList);
        return teacherTypeListMap ;
    }






}
