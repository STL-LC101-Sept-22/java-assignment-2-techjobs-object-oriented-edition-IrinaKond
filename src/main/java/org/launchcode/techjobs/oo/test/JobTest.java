package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertNotEquals(test_job1.getId(), test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
       Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertTrue(test_job.getName() instanceof String);
       assertTrue(test_job.getEmployer() instanceof Employer);
       assertTrue(test_job.getLocation() instanceof Location);
       assertTrue(test_job.getPositionType() instanceof PositionType);
       assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
       assertEquals("Product tester", test_job.getName());
       assertEquals("ACME", test_job.getEmployer().getValue());
       assertEquals("Desert", test_job.getLocation().getValue());
       assertEquals("Quality control", test_job.getPositionType().getValue());
       assertEquals("Persistence", test_job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job1.equals(test_job2));
        assertFalse(test_job2.equals(test_job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobToString = test_job.toString();
        assertEquals(jobToString.charAt(0), '\n');
        assertEquals(jobToString.charAt(jobToString.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobToString = test_job.toString();
        String jobToStringExpected = "\nID: " + test_job.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";
        assertEquals(jobToStringExpected, jobToString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job.setName(null);
        String jobToString = test_job.toString();
        String jobToStringExpected = "\nID: "   + test_job.getId() + "\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";
        assertEquals(jobToStringExpected, jobToString);

    }
    @Test
    public void testToStringContainsOnlyIdField() {
        Job test_job = new Job();
        String jobToString = test_job.toString();
        String jobToStringExpected = "OOPS! This job does not seem to exist.";
        assertEquals(jobToStringExpected, jobToString);
    }


}
