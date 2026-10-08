package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f26-teams>
        assertEquals("Alex Peroulas", Developer.getName());
    }

    @Test 
    public void getGithubId_returns_correct_github_id() {
        assertEquals("AlexPeroulas", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("f26-13", team.getName());
    }

    @Test 
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Alex"),"Team should contain Alex");
        assertTrue(t.getMembers().contains("Michael"),"Team should contain Michael");
        assertTrue(t.getMembers().contains("Kun"),"Team should contain Kun");
        assertTrue(t.getMembers().contains("Max"),"Team should contain Max");
        assertTrue(t.getMembers().contains("Akshaj"),"Team should contain Akshaj");
        assertTrue(t.getMembers().contains("Branden"),"Team should contain Branden");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
