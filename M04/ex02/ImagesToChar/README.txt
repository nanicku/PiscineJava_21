rm -rf target
rm -rf lib

mkdir target

mkdir lib


curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar

curl -o lib/JCDP-4.0.1.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.1/JCDP-4.0.1.jar

jar -xf lib/jcommander-*.jar; mv com target; rm -rf META-INF
jar -xf lib/JCDP-*.jar; cp -R com target; rm -rf META-INF com

javac -d target -sourcepath src/java -cp lib/JCDP-4.0.1.jar:lib/jcommander-1.82.jar:. src/java/edu/school21/printer/*/*.java

cp -R src/resources target/.

jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

chmod 777 target/images-to-chars-printer.jar

java -jar target/images-to-chars-printer.jar  --white=RED --black=GREEN