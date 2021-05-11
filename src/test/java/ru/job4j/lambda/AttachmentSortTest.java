package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class AttachmentSortTest {
    @Test
    public void cmpStr() {
        Comparator<Attachment> cmpText = (left, right) -> right.getName().compareTo(left.getName());
     List<Attachment> lst = Arrays.asList(
             new Attachment("image 123", 250),
             new Attachment("image 4", 108),
             new Attachment("image 23", 116)
     );
        List<Attachment> exp = Arrays.asList(
                new Attachment("image 4", 108),
                new Attachment("image 23", 116),
                new Attachment("image 123", 250)
        );
        Collections.sort(lst, cmpText);
        assertThat(lst, is(exp));
    }
    @Test
    public void cmpLengthStr() {
        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(right.getName().length(), left.getName().length());
        List<Attachment> lst = Arrays.asList(
                new Attachment("image 123", 108),
                new Attachment("image 4", 250),
                new Attachment("image 23", 116)
        );
        List<Attachment> exp = Arrays.asList(
                new Attachment("image 123", 108),
                new Attachment("image 23", 116),
                new Attachment("image 4", 250)
        );
        Collections.sort(lst, cmpDescSize);
        assertThat(lst, is(exp));
    }
}