# SampleProject
Sample Android Application that communicates with PHP-MYSQL

The Project has 2 components viz. "server" and "Android Application" named "Sample Application"

## Server
* The PHP script "db_credentials.php" contains configuration information for connecting with the MYSQL instance running on system.
* The PHP script "create.php" needs to be run initially (only once). It creates a database named "SAMPLE", table TUser in SAMPLE, 2 stored procedures for inserting and getting the records.
* The PHP script "get.php" expects  GET request with URL parameter "id" i.e. get.php?id=2 for getting the record
* The PHP script "post.php" expects a POST request with URL param "json_string" containing the data to be inserted into the DB.

##Android Application - Sample Application
The Application has a sliding drawer that can be drawn from the left with 3 sections viz. Set IP, GET, POST

* Set IP - Type the IP in the TextBox displayed and click on button "Fix IP" to provide IP of the server that has a MYSQL instance running (must be on system as of now).
* GET - Type the id and hit submit to get the record corresponding to that ID.
* POST - Type the record information in form given and hit submit. An Alert is displayed telling about status of query execution.
