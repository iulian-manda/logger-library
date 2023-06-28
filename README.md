# logger-library
## Possible Features
1. Add configuration for email server that sends the email
2. Add configuration for writing to file
3. Add buffering for logging the messages, in order to optimize the performance. It also optimizes
how many calls are sent to the email server / writing to file / calling external APIs

## Any improvements to our code that could simplify our Big O notation of every method?
As with feature number 3, adding buffering before sending the logs to an external service will improve
the performance. Currently, the code runs in O(N) and can be improved to O(logN)
The bottleneck is calling the external services.
