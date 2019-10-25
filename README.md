# fips140ext Extension
fips140ext is a custom MuleSoft 4.x extension that provides support for the fips-140 JCE ciphers available with the bouncycastle.org fips libraries. 

To use this extension:
1. Ensure you have Java JDK 1.8 and maven installed on your system 
2. Download this project from github or clone this repository with the following git command:
    ~~~
    git clone https://github.com/mulesoft-consulting/fips140ext.git
    ~~~
3. Build the Mule extension with the following maven command:
    ~~~
    mvn clean install -DskipTests
    ~~~
4. Add the following dependency snippet to the <dependencies/> section of your Mule project's pom.xml file:
    ~~~{.xml
    <dependency>
        <groupId>org.mulesoft.custom</groupId>
        <artifactId>fips140ext</artifactId>
        <version>1.0.0</version>
        <classifier>mule-plugin</classifier>
    </dependency>
    ~~~
5. Copy the initFips.xml file from the root of this project to the root directory of your Mule project. This XML file initializes the 
fips-140 extension as a new cryptography provider in the JVM.  



