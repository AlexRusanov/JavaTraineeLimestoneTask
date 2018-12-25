package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Created by alexandrrusanov on 12/25/18.
 */
public class Test {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Valery", "Popov"));
        students.add(new Student("Semyon","Korzhev"));
        students.add(new Student("Peter","Ivanov"));
        students.add(new Student("Maria","Semenova"));
        students.add(new Student("Kolya","Nesterenko"));

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Mathematics", true));
        subjects.add(new Subject("Physics", true));
        subjects.add(new Subject("Astronomy", true));
        subjects.add(new Subject("History", true));
        subjects.add(new Subject("Ethics", false));

        List<Mark> marks = new ArrayList<>();
        for (Student student:students) {
            if (student.getFirstName().equals("Maria")){
                for (Subject subject:subjects){
                    if (!subject.getName().equals("History") & subject.isMandatory()) {
                        marks.add(new Mark(student, subject, 3));
                    }else marks.add(new Mark(student, subject, 5));
                }
            }else{
                for (Subject subject:subjects) {
                    if (subject.isMandatory()) marks.add(new Mark(student, subject, 3));
                }
            }
        }

        Map<Student, List<Mark>> marksMap = marks.stream().collect(Collectors.groupingBy(Mark::getStudent));
        for (Map.Entry<Student, List<Mark>> entry: marksMap.entrySet()) {
            System.out.printf("%s %s\n", entry.getKey(), entry.getValue().stream().map(Mark::toString).collect(Collectors.joining(" ")));
        }
    }
}
