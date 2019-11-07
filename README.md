# java-vmw-ranking-api
REST API to retrieve and persist user entry.
## Environment Variables
| KEY | Description |
----|----
| SPRING_DATASOURCE_URL | This is URL for Spring JPA datasource, such as jdbc:postgresql://<Postgres Server>/ |
| SPRING_DATASOURCE_USERNAME | Name of postgres user |
| SPRING_DATASOURCE_PASSWORD | Passowrd of postgres user |
## User Entry Format ##
- ID: automatically assigned identifier, Integer.
- Name: dispay name of a user and non-unique, String.
- Score: value of score, Integer.
### Example
    {
      "id": 1
      "name": "Masashi"
      "score": 100
    }
