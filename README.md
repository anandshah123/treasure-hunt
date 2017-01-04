# Treasure hunt (for programmatic hunters)
The online treasure hunt host app for programmatic treasure hunters. The repository to host programmatic treasure hunt event.

## Problem statement:
``Steal as much money as you can from castle.`` Build an algorithm which maximizes team’s treasure

## Description: 
Imagine a castle with many ``rooms`` filled with treasure chests, protected by their ``guards``. Your objective as a team would be to knock each door for guard to open it and snatch as much money as you can in every shot. Obviously team having maximum money in their chest would be the winner. So the overall steps to play are

1.	Get the castle ``treasure rooms`` map
2.	Knock door of any ``room`` to ask ``guard`` to open it
3.	Take as much money as you want from that room and move to the next room
4.	Understand which room has got more money and prepare strategy to get max treasure from castle

Obviously ``guards`` are smart and they will create obstacles for you for preventing you to steal their money.
They will

1.	Switch ``important`` treasure chests locations (move treasure from one ``room`` to other)
2.	Lock doors of ``room`` if too many teams are stealing treasure from same room
3.	Create ``resistance`` for teams to steal more money
4.	Misguide teams by throwing few ``coins`` to empty rooms

## Programming guide/hints:

-	Everything is a json based REST service (ie. ``Accept`` & ``Content-Type`` headers with value ``application/json`` is required)
-	Team is uniquely identified at ``rooms`` by basic authentication. (This is the username/password that team will provide while doing team registration)

## Starting point:

-	Team can GET castle ``rooms map`` always at: http://eureka.server:8761/eureka/apps
-	To GET money from any ``room`` pattern will be: http://treasure-app.server:10001/treasure/earn


## Architecture

![Treasure hunt application system architecture](treasure-hunt-parent/Treasure hunt castle architecture.png?raw=true "Treasure hunt application system architecture")
