package ru.job4j.turistadresslist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Profile profile = new Profile(
                new Address("Moscow", "Krasnopresnenskaya", 3, 3)
        );
        Profile profile2 = new Profile(
                new Address("Moscow", "Krasnopresnenskaya", 3, 2)
        );
        Profile profile3 = new Profile(
                new Address("Moscow", "Krasnopresnenskaya", 3, 1)
        );
        List<Profile> profiles = List.of(profile, profile2, profile3);
        List<Address> exp = profiles.stream()
                .map(pr -> pr.getAddress())
                .collect(Collectors.toList());
        Profiles func = new Profiles();
        List<Address> rsl = func.collect(profiles);
        assertThat(exp, is(rsl));

    }
}