# Scoreboard assigment

## Key Design Principles

- KISS (Keep it simple, stupid)
- YAGNI (You aren't gonna need it) - I'm not adding any extra features, just what is required
- Accordingly, to open-close principle all classes except factory and model are package
  private, yet behaviour can be modified by providing custom comparator.


## Assumptions
- At first, I wanted to implement simple Event Sourcing solution, and publish-subscribe pattern to emmit
  changes to scoreboard observers, but then I read in the assigment description that implementation should
  be as simple as possible.

- I assume that this class should be thread safe so I used ConcurrentHashMap to store games.

- As this project is supposed to be used as a library, I implemented it in framework-agnostic way. 

### Notes

I don't like requirement 
> Update score. This should receive a pair of absolute scores: home team score and away team score.

because it enforces clumsy API like `scoreboard.updateScore("home", "away", 1, 2)` instead of `scoreboard.homeTeamScored(3)` which I find more natural. 

Adding an interface for Game class would be overengineering in my opinion, so I left it as it is. 

IMO tests readability is very important, so I introduced fluent API, helper methods and matchers. 


