# Assignment

Deployed as a Spring Boot App and expose one endpoint: http://localhost:8080/connected?origin=city1&destination=city2
Your program should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response.
For Example:
city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany
http://localhost:8080/connected?origin=Boston&destination=Newark
Should return yes 
http://localhost:8080/connected?origin=Boston&destination=Philadelphia 
Should return yes 
http://localhost:8080/connected?origin=Philadelphia&destination=Albany 
Should return no
———————————————


Used Swagger for Documentation.
http://localhost:8080/swagger-ui.html#/city-controller
http://localhost:8080/v2/api-docs


