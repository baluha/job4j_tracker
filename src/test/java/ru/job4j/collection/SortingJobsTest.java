package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;
import static org.hamcrest.Matchers.lessThan;

public class SortingJobsTest {
private Job getUp;
private Job brushTeeth;
private Job fixBugs;
private Job writeCode;
private Job writingCodeRightNow;
private Job goWalk;

@Before
 public void setup() {
    getUp = new Job("getUp", 1);
    brushTeeth = new Job("brush teeth", 2);
    fixBugs = new Job("fix bugs", 3);
    writeCode = new Job("write code", 2);
    writingCodeRightNow = new Job("write code", 1);
    goWalk = new Job("go walk", 2);
}

    @Test
    public void byNameAscending() {
        List<Job> jobs = Arrays.asList(getUp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(brushTeeth, fixBugs, getUp);
        Collections.sort(jobs, new JobDescByNameAscending());
        assertThat(jobs, is(exp));
    }

    @Test
    public void byNameDescending() {
        List<Job> jobs = Arrays.asList(getUp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(getUp, fixBugs, brushTeeth);
        Collections.sort(jobs, new JobDescByNameDescending());
        assertThat(jobs, is(exp));
    }

    @Test
    public void byPriorityAscending() {
        List<Job> jobs = Arrays.asList(getUp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(getUp, brushTeeth, fixBugs);
        Collections.sort(jobs, new JobDescByPriorityAscending());
        assertThat(jobs, is(exp));
    }

    @Test
    public void byPriorityDescending() {
        List<Job> jobs = Arrays.asList(getUp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(fixBugs, brushTeeth, getUp);
        Collections.sort(jobs, new JobDescByPriorityDescending());
        assertThat(jobs, is(exp));
    }

    @Test
    public void byNameAndPriorityAscending() {
        Comparator<Job> ascending = new JobDescByNameAscending()
                .thenComparing(new JobDescByPriorityAscending());
        int rsl = ascending.compare(goWalk, writeCode);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void byNameAndPriorityAscendingSecond() {
        Comparator<Job> ascending = new JobDescByNameAscending()
                .thenComparing(new JobDescByPriorityAscending());
        int rsl = ascending.compare(writingCodeRightNow, writeCode);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void byNameAndPriorityDescending() {
        Comparator<Job> ascending = new JobDescByNameDescending()
                .thenComparing(new JobDescByPriorityDescending());
        int rsl = ascending.compare(writeCode, goWalk);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void byNameAndPriorityDescendingSecond() {
        Comparator<Job> ascending = new JobDescByNameDescending()
                .thenComparing(new JobDescByPriorityDescending());
        int rsl = ascending.compare(writeCode, writingCodeRightNow);
        assertThat(rsl, lessThan(0));
    }
}