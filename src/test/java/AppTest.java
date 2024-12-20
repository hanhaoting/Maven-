package com.example.student;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testStudent() {
        Student student = new Student("John", 20, "001");
        assertEquals("John", student.getName());
        assertEquals(20, student.getAge());
        assertEquals("001", student.getId());
    }
}
