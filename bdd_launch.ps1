docker run --name my-mysql -d --rm `
    --network IOT --network-alias mysql `
    -e MYSQL_ROOT_PASSWORD=root `
    -e MYSQL_DATABASE=IOT `
    -p 3306:3306 `
    -p 33060:33060 `
    -v database-volume:/var/lib/mysql `
    mysql:8.0.27 
     

docker exec -it `
    my-mysql `
    bash 