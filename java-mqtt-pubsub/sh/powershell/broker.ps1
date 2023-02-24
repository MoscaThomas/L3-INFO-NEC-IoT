$CURRENT_DIR = $(split-path $(pwd) -leaf)

docker run -d --rm -it `
    --name "$CURRENT_DIR-broker" `
    -p 15672:15672 -p 5672:5672  `
    --net IOT `
    rabbitmq:3.11.6-management-alpine