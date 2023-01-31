#!/bin/bash
$WORKDING_DIR = pwd
$CURRENT_DIR = $(split-path $(pwd) -leaf)

$CONTAINER_RUNTIME_NAME="$CURRENT_DIR-openjdk-11-pubsub-consumer"


docker run -d -it --rm `
    -v $WORKDING_DIR/app:/app `
    --net host `
    --name $CONTAINER_RUNTIME_NAME `
    openjdk:11


docker exec -it  `
    -w /app `
    $CONTAINER_RUNTIME_NAME `
    /bin/bash -c "java -cp /app/app-jar-with-dependencies.jar Consumer" -or 
        docker stop $CONTAINER_RUNTIME_NAME; exit 1
    


docker stop "$CONTAINER_RUNTIME_NAME"