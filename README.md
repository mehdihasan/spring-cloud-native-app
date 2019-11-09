# spring-cloud-native-app



## for the config server
**Download full-strength JCE(Java Cryptography Extension) from the link below**
### ON MacOS
1. download the JCE from this link: http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. check out your java home running this command: /usr/libexec/java_home -v
3. go to (java home) + /Home/jre/lib/security folder (mine one was /Library/Java/JavaVirtualMachines/jdk1.8.0_92.jdk/Contents/Home/jre/lib/security)
4. backup the local_policy and us_export_policy JAR 
5. copy the downloaded JARs into this location 

### On Ubuntu
1. If you install Java via ppa:webupd8team/java repo through terminal then you are in a good shape. You just need to run the following command: 
sudo apt install oracle-java8-unlimited-jce-policy
 
