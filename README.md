# sandbox.java.oxm
Sandbox for all Java-related Object-to-XML-Mapping (OXM) experiments using a wide range of frameworks

## Links

- Reading about OXM
  - [What is the best Java OXM library?](https://stackoverflow.com/questions/413597/what-is-the-best-java-oxm-library)

- Frameworks for OXM
  - [JiBX: Binding XML to Java Code](http://jibx.sourceforge.net/index.html)
  - [Introduction to JiBX](https://www.baeldung.com/jibx)
  - [Castor 1.3.3 - Reference documentation](https://castor-data-binding.github.io/castor/reference-guides/1.3.3/html-single/index.html)

- Plugins for Maven
  - [maven-jaxb2-plugin](https://github.com/highsource/maven-jaxb2-plugin)
  - [jaxb2-maven-plugin](https://www.mojohaus.org/jaxb2-maven-plugin/Documentation/v2.5.0/index.html)
  - [maven-jibx-plugin](http://jibx.sourceforge.net/maven-jibx-plugin/)
  - [castor-maven-plugin](https://www.mojohaus.org/castor-maven-plugin/)
  - [xmlbeans](https://xmlbeans.apache.org/guide/Maven.html)
    ```xml
    <plugin>
        <groupId>org.apache.xmlbeans</groupId>
        <artifactId>xmlbeans</artifactId>
        <version>5.0.0</version>
        <executions><execution><goals><goal>compile</goal></goals></execution>
        </executions>
        <configuration>
            <repackage>org.mtconnect.xmlbeans.version_1_3</repackage>
            <partialMethods>ALL,-GET_LIST,-XGET_LIST,-XGET_ARRAY</partialMethods>
            <mdefNamespaces>urn:mtconnect.org:MTConnectError:1.3</mdefNamespaces>
            <baseSchemaLocation>${project.basedir}/target/generated-sources/xsd</baseSchemaLocation>
            <buildSchemas>true</buildSchemas>
            <sourceDir>${project.basedir}/target/generated-sources/xsd</sourceDir>
            <sourceSchemas>MTConnectError_1.3.xsd</sourceSchemas>
            <javaTargetDir>${project.basedir}/target/generated-sources/xmlbeans</javaTargetDir>
            <classTargetDir>${project.basedir}/target/classes</classTargetDir>
            <verbose>true</verbose>
        </configuration>
    </plugin>
    ```

- Tasks for Ant
  - [xmlbean](http://xmlbeans.apache.org/guide/AntTask.html)
    ```xml
    <target name="compile" depends="init"
            description="compile the schemas">
        <taskdef name="xmlbean"
                 classname="org.apache.xmlbeans.impl.tool.XMLBean"
                 classpath="${user.home}/.m2/repository/org/apache/xmlbeans/xmlbeans/5.0.0/xmlbeans-5.0.0.jar" />
        <xmlbean />
    </target>
    ```

## Prerequisites

- Java SDK
- Maven

```shell
sudo apt install openjdk-17-jdk maven
```

## Build

### Cloning the Repository

The *GitHub* repository has to be checked out before it can be built.

```shell
git clone --recursive https://github.com/kjwenger/sandbox.java.oxm.git
cd sandbox.java.oxm
```

### Maven

#### Profiles

To chose of the many provided OXM frameworks one of the following profiles has to be specified for any Maven call:

- `jaxb2-maven`
- `maven-jaxb2`
- `jixb`
- `castor`
- `xmlbeans`

```shell
mvn install -P jaxb2-maven
```

### Ant

```shell
ant compile
```
