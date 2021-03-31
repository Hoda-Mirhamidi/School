package com.school.main;

import com.school.*;
import com.school.enums.Degree;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("math", 1);
        Course course1 = new Course("computer", 2);
        Course course2 = new Course("physic", 3);
        Course course3 = new Course("history", 4);
        Course course4 = new Course("art", 5);


        School school =  new School("maktab", 1);
        School school1 = new School("madani", 2);
        School school2 = new School("alavi", 3);
        School school3 = new School("razavi", 3);
        School school4 = new School("jalal", 1);
        School school5 = new School("diba", 1);


        FullTimeTeacher t1 = new FullTimeTeacher("First","First","1",3_000_000);
        FullTimeTeacher t2 = new FullTimeTeacher("Second","Second","2",4_500_000);
        FullTimeTeacher t3 = new FullTimeTeacher("Third","Third","3",6_000_000);
        PartTimeTeacher t4 = new PartTimeTeacher("Fourth","Fourth","4",10,100_000);
        PartTimeTeacher t5 = new PartTimeTeacher("Fifth","Fifth","5",20,200_000);

        t1.setExperienceYear(12);
        t2.setExperienceYear(10);
        t3.setExperienceYear(10);
        t4.setExperienceYear(10);
        t5.setExperienceYear(11);
        t4.setDegree(Degree.BS);
        t5.setDegree(Degree.BS);

        List<Teacher> teacherList = Arrays.asList(t1,t2,t3,t4,t5);

        TeacherRepository teacherRepository = new TeacherRepository();
        teacherRepository.teachers = teacherList;

        teacherRepository.addCourseToTeacher(t4,course);
        teacherRepository.addCourseToTeacher(t4,course1);
        teacherRepository.addCourseToTeacher(t4,course2);
        teacherRepository.addSchoolToTeacher(t4,school1);
        teacherRepository.addCourseToTeacher(t5,course1);
        teacherRepository.addSchoolToTeacher(t5,school);
        teacherRepository.addSchoolToTeacher(t5,school1);
        teacherRepository.addSchoolToTeacher(t1,school3);
        teacherRepository.addSchoolToTeacher(t1,school1);
        teacherRepository.addSchoolToTeacher(t2,school3);
        teacherRepository.addSchoolToTeacher(t3,school1);

        //test 1
        teacherRepository.aboveAverageSalary().forEach(System.out::println);
        //test 2
        teacherRepository.moreThanTenYearsExperienceTeachers().forEach((teacherType, teachers) -> System.out.println(teacherType+"   "+Arrays.asList(teachers)));
        //test 3
        teacherRepository.partTimeTeachersFilteredList().forEach(System.out::println);
        //test4
        teacherRepository.schoolsFoundByTeachers().forEach(school6 -> System.out.println(school6.getName()));
        //test5
        teacherRepository.schoolTeachersMap().forEach((s, teachers) -> System.out.println(s+"  :  "+Arrays.asList(teachers)));







    }
}
