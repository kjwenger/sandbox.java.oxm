package org.mtconnect.castor.version_1_3;

import org.exolab.castor.xml.Unmarshaller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mtconnect.TestSuite;
import org.mtconnect.castor.version_1_3.devices.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUnMarshalling {

    private final static Logger logger =
            Logger.getLogger(TestUnMarshalling.class.getName());

    private static final String SMS_TESTBED_NIST_GOV_VDS =
            "gov/nist/smstestbed/vds/MTConnectDevices.xml";
    private static final String
            MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES =
            "MTConnectDevices did not contain any elements: <Devices>";

    public static class UnMarshalled implements Serializable {

    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSuite.readLoggingProperties();
    }

    @Test
    void testUnmarshalledRaw() throws Exception {
        doTestUnmarshalledRaw();
    }

    @Disabled
    @Test
    void testVolatileDataStreamRaw() throws Exception {
        doTestMTConnectDevicesRaw();
    }

    @Disabled
    @Test
    void testVolatileDataStream() throws Exception {
        doTestMTConnectDevices();
    }

    @Disabled
    @Test
    void testVolatileDataStream2() throws Exception {
        doTestMTConnectDevices2();
    }

    private void doTestUnmarshalledRaw() throws Exception {
        Unmarshaller unmarshaller = new Unmarshaller(UnMarshalled.class);
        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final InputStream inputStream = url.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Object unMarshalled = unmarshaller.unmarshal(inputStreamReader);
        logger.log(Level.INFO, String.format(
                "TestUnMarshalling#testReadXml()" +
                        " unMarshaled = %s\n",
                unMarshalled));
    }

    private void doTestMTConnectDevicesRaw() throws Exception {
        Unmarshaller unmarshaller = new Unmarshaller(MTConnectDevices.class);
        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final InputStream inputStream = url.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Object unMarshalled = unmarshaller.unmarshal(inputStreamReader);
        logger.log(Level.INFO, String.format(
                "TestUnMarshalling#testReadXml()" +
                        " unMarshaled = %s\n",
                unMarshalled));
//        MTConnectDevices mtConnectDevices = (MTConnectDevices) unMarshalled;
//        final DevicesType devices = mtConnectDevices.getDevices();
//        final List<DeviceType> deviceList = devices.getDevice();
//        assertNotEquals(0, deviceList.size(),
//                MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES);
    }

    private void doTestMTConnectDevices() throws Exception {
        Unmarshaller unmarshaller = new Unmarshaller(MTConnectDevices.class);
        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final InputStream inputStream = url.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        MTConnectDevices mtConnectDevices = (MTConnectDevices) unmarshaller.unmarshal(inputStreamReader);
//        final DevicesType devices = mtConnectDevices.getDevices();
//        final List<DeviceType> deviceList = devices.getDevice();
//        assertNotEquals(0, deviceList.size(),
//                MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES);
    }

    private void doTestMTConnectDevices2() throws Exception {
        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final InputStream inputStream = url.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        MTConnectDevices mtConnectDevices = MTConnectDevices.unmarshal(inputStreamReader);
//        final DevicesType devices = mtConnectDevices.getDevices();
//        final List<DeviceType> deviceList = devices.getDevice();
//        assertNotEquals(0, deviceList.size(),
//                MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES);
    }

}