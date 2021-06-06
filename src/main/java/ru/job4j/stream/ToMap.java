package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {
    public Map<String, Student> map(List<Student> students) {
        return students
                .stream()
                .collect(
                        Collectors.toMap(
                        Student::getSurname,
                        Function.identity(), (student, student1) -> student
                )
                );
    }
}
