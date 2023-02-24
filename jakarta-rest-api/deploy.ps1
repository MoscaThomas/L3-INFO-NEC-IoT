$PROJECT_DIR = pwd

docker run -it --rm `
    --name payara-full-server-5.2022.1 `
    -v ${PROJECT_DIR}/app:/opt/payara/deployments `
    -p 8085:8080 `
    --network IOT `
    payara/server-full:5.2022.1-jdk11