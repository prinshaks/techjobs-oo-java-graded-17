package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
        public void testSettingJobId() {
        Job job1=new Job();
        Job job2=new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester",job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());

        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location );
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        Job job4=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(false,job4.equals(job5));
    }

    @Test
    public void  testToStringStartsAndEndsWithNewLine(){
        //lineSeparator gives \r\n in Windows
        Job job6=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(System.lineSeparator(),job6.toString().substring(0,2) );
        assertEquals(System.lineSeparator(),job6.toString().substring(job6.toString().length()-2) );

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job6=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = job6.toString().split(System.lineSeparator());
        assertEquals("ID: " + job6.getId(),lines[1]);
        assertEquals("Name: "+ job6.getName(),lines[2]);
        assertEquals("Employer: " + job6.getEmployer(),lines[3]);
        assertEquals("Location: " + job6.getLocation(),lines[4]);
        assertEquals("Position Type: "+ job6.getPositionType(),lines[5]);
        assertEquals("Core Competency: " + job6.getCoreCompetency(),lines[6]);

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job7=new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String[] lines2 = job7.toString().split(System.lineSeparator());
        assertEquals("Name: Data not available",lines2[2]);
        assertEquals("Employer: Data not available" ,lines2[3]);
        assertEquals("Location: Data not available" ,lines2[4]);
        assertEquals("Position Type: Data not available",lines2[5]);
        assertEquals("Core Competency: Data not available" ,lines2[6]);
    }

}
