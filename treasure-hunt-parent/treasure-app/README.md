# [treasure-hunt-parent](..) &gt; Treasure App
Treasure app has two end points
1. Config (http://server:port/treasure/config)
This end point is used for doing various configurations.
2. Earn (http://server:port/treasure/earn) This end point provides rewards as per the configurations

# Configurations end point ``/treasure/config`` 
Request Type: POST

Content-Type: application/json

Authorization: Basic base64Token of user having ADMIN role

Body
``` javascript
{
  "responseDelay": 0,
  "minPoints": 10,
  "maxPoints": 100,
  "rateLimit": 1000,
  "firstNLucky": 0,
  "firstNLuckyPoints": 0
}
```

Response (The new config just set)

``` javascript
{
  "responseDelay": 0,
  "minPoints": 10,
  "maxPoints": 100,
  "rateLimit": 1000,
  "firstNLucky": 0,
  "firstNLuckyPoints": 0
}
```

Description

Note: Config can be changed anytime while app is running. App will start using next request to ``/treasure/earn`` endpoint

| Property | Type | Default | Description |
|---------|-------------|------|-----|
| responseDelay | long | 0 | Delays every ``/earn`` response by x milliseconds. No impact if 0 |
| minPoints | int | 0 | Minimum points in random range of ``reward`` |
| maxPoints | int | 10 |  Maximum points in random range of ``reward`` |
| rateLimit | int | 1000 | Maximum per user hits allowed per second to endpoint ``/earn`` |
| firstNLucky | int | 0 | Like early bird. Distributes ``firstNLuckyPoints`` to first N visitors of ``/earn``|
| firstNLuckyPoints | int | 0 | The ``reward`` to distribute to ``firstNLucky`` |

# Earn reward endpoint ``/treasure/earn``

Request Type: GET

Content-Type: application/json

Authorization: Basic base64Token of user having USER role

Response

``` javascript
{
    "money": 15
}
```