# Room Reservations API

API for the Rooom Reservations UI Practice Project, providing full CRUD over the Reservations domain.

Default configuration:
```
server:
  port: 8085

datasource:
   platform: postgres
   url: jdbc:postgresql://localhost:5433
   username: postgres
   password: root
   driverClassName: org.postgresql.Driver

```

Example post body
```
{
    "guestEmail": "bross@gmail.com",
    "checkInDate": "03-18-2024",
    "numberOfNights": 2
}
```
