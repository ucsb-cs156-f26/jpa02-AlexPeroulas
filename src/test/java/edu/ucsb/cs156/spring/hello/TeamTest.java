package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void check_team_equals()
    {
        assert(team.equals(team));
    }

    @Test
    public void check_team_not_equals()
    {
        assert(!team.equals(new Team("other-team")));
    }

    @Test 
    public void check_team_equals_other_object()
    {
        assert(!team.equals("not a team"));
    }
    
    @Test
    public void check_team_equals_with_same_name_and_members(){
        Team other = new Team("test-team");
        assertEquals(true, team.equals(other));
    }

    @Test 
    public void check_team_not_equal_with_same_name_but_dif_members()
    {
        Team other = new Team("test-team");
        team.addMember("OrangeBlue");
        assertEquals(false, team.equals(other));
    }

    @Test 
    public void check_team_to_string()
    {
        team.addMember("Alex");
        team.addMember("Bob");
        assert("Team(name=test-team, members=[Alex, Bob])".equals(team.toString()));
    }

    @Test 
    public void check_team_hash_code()
    {
        assert((team.getName().hashCode() | team.getMembers().hashCode()) == team.hashCode());    
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
