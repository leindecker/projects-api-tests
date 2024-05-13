package base.util;

public class FileUtil {

    public static String getContractsBasePath(final String pack, final String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }

}
