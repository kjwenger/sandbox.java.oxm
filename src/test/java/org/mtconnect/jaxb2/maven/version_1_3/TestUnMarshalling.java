package org.mtconnect.jaxb2.maven.version_1_3;

import org.junit.jupiter.api.Test;
import org.mtconnect.jaxb2.maven.version_1_3.devices.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnMarshalling {

    private final static Logger logger =
            Logger.getLogger(TestUnMarshalling.class.getName());

    private static final String SMS_TESTBED_NIST_GOV_VDS =
            "gov/nist/smstestbed/vds/MTConnectDevices.xml";
    private static final String
            MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES =
            "MTConnectDevicesType did not contain any elements: <Devices>";

    @Test
    void testVolatileDataStreamRaw() throws Exception {
        doTestMTConnectDevicesTypeRaw();
    }

    @Test
    void testVolatileDataStream() throws Exception {
        doTestMTConnectDevicesType();
    }

    @SuppressWarnings("rawtypes")
    private void doTestMTConnectDevicesTypeRaw() throws Exception {
        final JAXBContext jaxbContext =
                JAXBContext.newInstance(MTConnectDevicesType.class);

        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
        final Object unMarshaled = jaxbUnMarshaller.unmarshal(url);
        logger.log(Level.INFO, String.format(
                "TestUnMarshalling#testReadXml()" +
                        " unMarshaled = %s\n",
                unMarshaled));
        assertTrue(unMarshaled instanceof JAXBElement,
                "Unmarshalling did not create a JAXBElement instance");
        final JAXBElement jaxbElement = (JAXBElement) unMarshaled;
        logger.log(Level.INFO, String.format(
                "TestUnMarshalling#testReadXml()" +
                        " jaxbElement.getDeclaredType() = %s," +
                        " jaxbElement.getName() = %s," +
                        " jaxbElement.getScope() = %s," +
                        " jaxbElement.getValue() = %s\n",
                jaxbElement.getDeclaredType(),
                jaxbElement.getName(),
                jaxbElement.getScope(),
                jaxbElement.getValue()));
        final MTConnectDevicesType mtConnectDevices = (MTConnectDevicesType)
                jaxbElement.getValue();
        final DevicesType devices = mtConnectDevices.getDevices();
        final List<DeviceType> deviceList = devices.getDevice();
        assertNotEquals(0, deviceList.size(),
                MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES);
    }

    @SuppressWarnings("unchecked")
    private void doTestMTConnectDevicesType() throws Exception {
        final JAXBContext jaxbContext =
                JAXBContext.newInstance(MTConnectDevicesType.class);
        final URL url = TestUnMarshalling.class.getClassLoader().getResource(SMS_TESTBED_NIST_GOV_VDS);
        final Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
        final JAXBElement<MTConnectDevicesType> jaxbElement =
                (JAXBElement<MTConnectDevicesType>)
                        jaxbUnMarshaller.unmarshal(url);
        final MTConnectDevicesType mtConnectDevices = jaxbElement.getValue();
        final DevicesType devices = mtConnectDevices.getDevices();
        final List<DeviceType> deviceList = devices.getDevice();
        assertNotEquals(0, deviceList.size(),
                MTCONNECT_DEVICES_TYPE_DID_NOT_CONTAIN_ANY_ELEMENTS_DEVICES);
        for (DeviceType device : deviceList) {
            logger.log(Level.INFO, String.format(
                    "TestUnMarshalling#testReadXml()" +
                            " device.getId() = %s," +
                            " device.getName() = %s\n",
                    device.getId(),
                    device.getName()));
            assertNotEquals("", device.getId(),
                    "DevicesType did not have an ID");
            final ComponentsType components = device.getComponents();
            final List<JAXBElement<? extends ComponentType>> componentList =
                    components.getComponent();
            for (JAXBElement<? extends ComponentType> componentElement
                    : componentList) {
                final ComponentType component = componentElement.getValue();
                logger.log(Level.INFO, String.format(
                        "TestUnMarshalling#testReadXml()" +
                                " component.getId() = %s," +
                                " component.getSampleInterval() = %g," +
                                " component.getSampleRate() = %g\n",
                        component.getId(),
                        component.getSampleInterval(),
                        component.getSampleRate()));
            }
        }
    }

}