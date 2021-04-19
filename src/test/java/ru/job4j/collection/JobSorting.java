package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;
import static org.hamcrest.Matchers.lessThan;


public class JobSorting {
private Job getAp;
private Job brushTeeth;
private Job fixBugs;
private Job writeCode;
private Job writingCodeRightNow;
private Job goWalk;

@Before
 public void setup () {
    getAp = new Job("getUp" , 1);
    brushTeeth = new Job("brush teeth", 2);
    fixBugs = new Job("fix bugs", 3);
    writeCode = new Job("write code", 2);
    writingCodeRightNow = new Job("write code", 1);
    goWalk = new Job("go walk",2);
}

/*    Job getAp = new Job("getUp" , 1);
    Job brushTeeth = new Job("brush teeth", 2);
    Job fixBugs = new Job("fix bugs", 3);
    Job writeCode = new Job("write code", 2);
    Job writingCodeRightNow = new Job("write code", 1);
    Job goWalk = new Job("go walk",2);*/

    @Test
    public void ByNameAscending() {
        List<Job> jobs = Arrays.asList(getAp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(brushTeeth, fixBugs, getAp);
        Collections.sort(jobs, new JobDescByNameAscending());
        assertThat(jobs, is (exp));
    }

    @Test
    public void ByNameDescending() {
        List<Job> jobs = Arrays.asList(getAp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(getAp, fixBugs, brushTeeth);
        Collections.sort(jobs, new JobDescByNameDescending());
        assertThat(jobs, is (exp));
    }

    @Test
    public void ByPriorityAscending() {
        List<Job> jobs = Arrays.asList(getAp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(getAp, brushTeeth, fixBugs);
        Collections.sort(jobs, new JobDescByPriorityAscending());
        assertThat(jobs, is (exp));
    }

    @Test
    public void ByPriorityDescending() {
        List<Job> jobs = Arrays.asList(getAp, fixBugs, brushTeeth);
        List<Job> exp = Arrays.asList(fixBugs, brushTeeth, getAp);
        Collections.sort(jobs, new JobDescByPriorityDescending());
        assertThat(jobs, is (exp));
    }

    @Test
    public void ByNameAndPriorityAscending() {
        Comparator<Job> ascending = new JobDescByNameAscending().thenComparing(new JobDescByPriorityAscending());
        int rsl = ascending.compare(goWalk, writeCode);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ByNameAndPriorityAscendingSecond() {
        Comparator<Job> ascending = new JobDescByNameAscending().thenComparing(new JobDescByPriorityAscending());
        int rsl = ascending.compare(writingCodeRightNow, writeCode);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ByNameAndPriorityDescending() {
        Comparator<Job> ascending = new JobDescByNameDescending().thenComparing(new JobDescByPriorityDescending());
        int rsl = ascending.compare(writeCode, goWalk);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ByNameAndPriorityDescendingSecond() {
        Comparator<Job> ascending = new JobDescByNameDescending().thenComparing(new JobDescByPriorityDescending());
        int rsl = ascending.compare(writeCode, writingCodeRightNow);
        assertThat(rsl, lessThan(0));
    }
}