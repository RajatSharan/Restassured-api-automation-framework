package utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertionUtill {

//    private SoftAssert softAssert;

    /*NOTE: Currently implemented using Singleton design pattern.
softAssert is an instance variable initialized in the private constructor.
Access SoftAssertionUtill methods via getInstance() to avoid NullPointerException.
To change from Singleton to static utility class, refactor to initialize softAssert statically
or pass SoftAssert instance explicitly to avoid shared state issues in parallel tests.
*/

    private static SoftAssert softAssert;

    private SoftAssertionUtill() {
    }

//    public SoftAssertionUtill() {
//
//        softAssert = new SoftAssert();
//
//    }

    public static SoftAssert getInstance() {
        if (softAssert == null) {
            softAssert = new SoftAssert();
        }
        return softAssert;
    }

    public static void assertTrue(boolean condition, String message) {
        try {
            getInstance().assertTrue(condition, message);
        } catch (AssertionError e) {

            getInstance().fail(message);
        }
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            softAssert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            softAssert.fail(message);
        }
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        try {
            softAssert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            softAssert.fail(message);
        }
    }

    public static void assertFalse(boolean condition, String message) {
        try {
            softAssert.assertFalse(condition, message);
        } catch (AssertionError e) {

            softAssert.fail(message);
        }
    }

    public static void assertAll() {
        softAssert.assertAll();
    }
}