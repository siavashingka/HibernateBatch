# Getting Started
This is a PoC for testing how hibernate behaves on batch operations
### How to use

For running the project and assessing the results:

* At the root of the project run: `docker-compose up`
* Run the Application, it has a command line runner class which runs the tests automatically
* Look at the logs about statistics of the batch operations 

### Results
- Calling a save() method from a caller normal/transactional method -> Saves without batching
- Calling save() method inside a for loop from a normal caller method -> Saves in multiple goes without batching
- Calling save() method inside a for loop from a transactional caller method -> Saves in Batches
- Calling saveAll() method from a normal/transactional method -> Saves in Batches
