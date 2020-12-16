# Questions level 4

Q) singleton pattern is used in the class that defines the database. What is the purpose of this pattern?   
A) The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.

Q) Why should you load the data in a background thread?  
A) so the ui can have the best possible performance in the main thread

Q) What are the three major components of ROOM and what are their responsibilities?  
A) Database, DAO, enitity. database defines list of entitites and its DAO. DAO mediates the acces to objects in the database and its tables. Entity is the class that is being saved in the database.

Q) How can you extract the current database so that you can see the table, columns, and data?   
A) you can export it with the command line interface and look ath the table, colums and data through a sqlLite viewer
