# portfolio-backend
The backend code of my personal web portfolio that call the GitHub API and get the each project's information and updates an existing AWS postgres database. This is done using the SpringBoot framework, making calls to the GitHub API every hour to retrieve the data.
## How to run the app 
 Portfolio API handles retrieves all journal entries for viewing from the Postgresql database (hosted on AWS EC2) and the JournalEntry API handles retrieves specific journal entries with the specific components (http://portfolioprojectapi-env.eba-jxm8s5sp.us-east-1.elasticbeanstalk.com//git/proj). The API can be run locally in the following steps:
1. Fork or downlocad the app folder in the repository
2. Go to the portfolio-backend directory where the source code is stored.
3. Make sure maven and jvm are installed. If maven is not installed, download maven from the following link https://maven.apache.org/download.cgi and configure the package based on the instructions here https://maven.apache.org/install.html pertaining towards your OS.
4. The API is configured to run on port 5000 in the application.yml file. This can be changed to any available port to avoid conflicts by changing the port number within the application.yml file.
5. The API may then be run with the play/run button of the used IDE or, both can be compiled to jar files using the mvwn command and run with the commands  `java -jar executable.jar` where the executable.jar is the compiled jar file for the components.
