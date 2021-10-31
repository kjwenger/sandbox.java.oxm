package org.mtconnect;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class TestSuite {

    public static void readLoggingProperties() throws IOException {
        final ClassLoader classLoader = TestSuite.class.getClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(
                "logging.properties");
        if (inputStream == null) return;
        LogManager.getLogManager().readConfiguration(inputStream);
        inputStream.close();
    }

}
