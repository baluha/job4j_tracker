package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(s -> s.getSubjects())
                .flatMap(sj -> sj.stream())
                .mapToInt(sc -> sc.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double score = pupil.getSubjects().stream()
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0D);
            return new Tuple(pupil.getName(), score);
        })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}