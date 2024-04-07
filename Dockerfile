
FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# ./gradlew build
# docker build -t cms-app .
#docker tag cms-app horleng/cms-app
# docker push horleng/cms-app
