package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixArrayToListTest {

    @Test
    public void toList() {
        MatrixArrayToList matrixArrayToList = new MatrixArrayToList();
        Integer[][] matrix = new Integer[][]{
                {1,2}, {3,4}
        };
        List<Integer> rsl = matrixArrayToList.lst(matrix);
        List<Integer> exp = List.of(1,2,3,4);
        assertThat(rsl, is(exp));
    }

}