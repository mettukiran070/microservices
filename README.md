# microservices
Developed microservices using the Java Spring boot

## Setup Prometheus & Grafana
1. docker-compose up
2. Check whether the endpoints are working or not Prometheus(http://localhost:9090/) & Grafana(http://localhost:3000/)
3. login to Grafana default username and password as admin
4. once you login. need to create a datasource
5. Select data source as prometheus and url is (http://prometheus:9090/) and click on save and test.
6. We can create or import the dash board
7. click on new and import enter the id as 12900 and save it