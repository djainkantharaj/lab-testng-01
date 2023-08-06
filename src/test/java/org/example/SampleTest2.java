package org.example;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SampleTest2 {

     private static final Logger logger = getLogger(SampleTest2.class);

     private String sharedVariable;

     // Constructor to accept the sharedVariable value
     public SampleTest2(String sharedVariable) {
          this.sharedVariable = sharedVariable;
     }

     @Factory
     public static Object[] createInstances() {
          return new Object[]{
                  new SampleTest2("Initialized by first instance"),
                  new SampleTest2("Initialized by second instance")
          };
     }

     @BeforeClass
     public void setUp() {
          logger.info("Inside SampleTest2 BeforeClass: " + sharedVariable);
     }

     @Test
     public void testMethod1() {
          logger.info("SampleTest2.Method 1: " + sharedVariable);
     }

     @Test
     public void testMethod2() {
          logger.info("SampleTest2.Method 2: " + sharedVariable);
     }
}
