$PROJECT_DIR = pwd

docker run -it --rm `
    --name maven-3.8.6-openjdk-11-slim `
    -v ${PROJECT_DIR}:/opt/maven/ `
    -v ${PROJECT_DIR}/repository:/root/.m2/repository `
    -w /opt/maven `
    maven:3.8.6-openjdk-11-slim `
    mvn clean install