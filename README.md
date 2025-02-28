VitalSwapCache

HOW TO COMPILE PACKAGE

 - "src" folder needs to be in the directory where the command is called
 - compile package [windows] [javac -cp ".;" src/vitalswapcache/*.java -d .]
 - compile package [others] [javac -cp ".:" src/vitalswapcache/*.java -d .]
 

HOW TO BUILD A EXECUTABLE JAR FILE

 - the MANIFEST file (manifest.mf) needs to be in the directory where the command is called 
 - to create executable jar file [jar -cvfm vitalswapcache.jar MANIFEST.MF vitalswapcache/*.class]


HOW TO RUN THE EXECUTABLE JAR FILE (VitalSwapCache)

 - java -jar vitalswapcache.jar

