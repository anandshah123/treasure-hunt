# [treasure-hunt-parent](..) &gt; Treasure hunt team registration

The module exposing team registration form based web application.

Endpoint of submission: /treasure/register

Form field description

| Property | Type | Default | Description | Validations|
|---------|-------------|------|-----|----|
| username | String | ``null`` | The unique username for a team. All requests to ``/treasure/earn`` has to be made with this username in basic authentication header | Unique, Primary Key |
| password | String | ``null`` | The password for a team. All requests to ``/treasure/earn`` has to be made with this password in basic authentication header | Not Null |
| team_name | String | ``null`` | The team name | Not null |
| team_members | CSV String | ``null`` | List of team member names separated by comma. Example: ``John Walter, Robert Brown`` | Not Null |
| user_role | String | ROLE_USER | The ``hidden`` field. Default ROLE assigned to every team | Not Null |
