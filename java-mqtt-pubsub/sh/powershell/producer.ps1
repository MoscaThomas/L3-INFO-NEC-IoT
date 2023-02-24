$WORKDING_DIR = pwd
$CURRENT_DIR = $(split-path $(pwd) -leaf)

$CONTAINER_RUNTIME_NAME="$CURRENT_DIR-openjdk-11-pubsub-producer"


docker run -d -it --rm `
    -v $WORKDING_DIR/app:/app `
    --network IOT `
    --name $CONTAINER_RUNTIME_NAME `
    -e broker_host=java-mqtt-pubsub-broker `
    openjdk:11


docker exec -it  `
    -w /app `
    $CONTAINER_RUNTIME_NAME `
    /bin/bash -c "java -cp /app/app-jar-with-dependencies.jar Producer" -or 
        docker stop $CONTAINER_RUNTIME_NAME; exit 1
    


docker stop "$CONTAINER_RUNTIME_NAME"