mvn install:install-file -DgroupId=org.apache.httpcomponents -DartifactId=httpclient -Dversion=4.5.2 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\httpclient-4.5.2.jar

mvn install:install-file -DgroupId=org.apache.httpcomponents -DartifactId=httpcore -Dversion=4.4.4 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\httpcore-4.4.4.jar

mvn install:install-file -DgroupId=com.fasterxml.jackson.core -DartifactId=jackson-annotations -Dversion=2.8.1 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\jackson-annotations-2.8.1.jar

mvn install:install-file -DgroupId=com.fasterxml.jackson.core -DartifactId=jackson-core -Dversion=2.8.1 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\jackson-core-2.8.1.jar

mvn install:install-file -DgroupId=com.fasterxml.jackson.core -DartifactId=jackson-databind	 -Dversion=2.8.1 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\jackson-databind-2.8.1.jar

mvn install:install-file -DgroupId=joda-time -DartifactId=joda-time -Dversion=2.7 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\joda-time-2.7.jar

mvn install:install-file -DgroupId=java-sdk-core -DartifactId=java-sdk-core -Dversion=2.0.1 -Dpackaging=jar -Dfile=D:\IdeaWorkspace\idea-Ultimate\synthetical-demo\consolebackstagedemo\libs\java-sdk-core-2.0.1.jar




	<!--DMS Kafka dependency-->
    <dependency>
      <groupId>java-sdk-core</groupId>
      <artifactId>java-sdk-core</artifactId>
      <version>2.0.1</version>
    </dependency>

    <dependency>
      <groupId>org.apache.httpcomponents</groupId>
      <artifactId>httpclient</artifactId>
      <version>4.5.2</version>
    </dependency>

    <dependency>
      <groupId>org.apache.httpcomponents</groupId>
      <artifactId>httpcore</artifactId>
      <version>4.4.4</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.8.1</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.8.1</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.8.1</version>
    </dependency>

    <dependency>
      <groupId>joda-time</groupId>
      <artifactId>joda-time</artifactId>
      <version>2.7</version>
    </dependency>