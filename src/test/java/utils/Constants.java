package utils;

public class Constants {

    // note: in here we keep the path of all the files things which will not change throughout the framework
//public ->so it can access throughout the project  static--> so we can call the method directly without creating an object final-->value are constant throughout the project String ->return type
    public static final String CONFIGURATION_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/config/config.properties"; /*this .getProperty("user.dir")will provide the root path and after /scr...
     will same among all team members.so by adding these two (both user.dir and  /src...config.properties)  for everyone on the team will the common path. */
    public static final int EXPLICIT_WAIT = 20;
    public static final int IMPLICIT_WAIT = 20;

    public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/Batch14Excel.xlsx";

    public static final String SCREENSHOT_FILEPATH =   System.getProperty("user.dir") + "/screenshots/";
}
