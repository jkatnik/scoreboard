# Scoreboard assigment

## Key Design Principles

- KISS (Keep it simple, stupid)
- YAGNI (You aren't gonna need it)

## Assumptions
At first, I wanted to implement simple Event Sourcing solution, and publish-subscribe pattern to emmit
changes to scoreboard observers, but then I read in the assigment description that implementation should
be as simple as possible.

### Notes

I don't like requirement 
> Update score. This should receive a pair of absolute scores: home team score and away team score.

because it enforces clumsy API like `scoreboard.updateScore("home", "away", 1, 2)` instead of `scoreboard.homeTeamScored(3)` which I find more natural. 
