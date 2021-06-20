package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
/*        return students.keySet().stream()
                .filter(v -> v.getAccount().equals(account))
                .findFirst()
                .orElse(null);*/
        Optional<Student> rsl = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
/*        Optional<Subject> rsl = Optional.empty();
        var s = findByAccount(account);
        if (s.isPresent()) {
            students.get(s).stream().filter(st -> st.getName().equals(name)).findFirst();
        }
        return rsl;
        */
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent() && rsl.isPresent()) {
            Set<Subject> subjects = students.get(s);
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}