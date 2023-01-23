# Lele's Population Management

# Requirements
[Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/#jdk19-windows), version 19.0.1 or later.

[Apache Maven](https://maven.apache.org/download.cgi), version 3.8.7.

Check this [tutorial page](https://www.tutorialspoint.com/maven/maven_environment_setup.htm) to install Maven correctly.

Check the current JDK and Maven version of your PC using these commands:
```ps1
javac -version
mvn -v
```

if the current version is lower than required version, please update/reinstall.

#### Preffered IDE for running/testing: [Visual Studio Code](https://code.visualstudio.com/).
#### Recommended extension for better performance:
[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[JavaFX Support](https://marketplace.visualstudio.com/items?itemName=shrey150.javafx-support)


# Run the program
## Using cmd
Open cmd and execute following command:
```ps1
mvn clean javafx:run
```

## Using VSCode Tasks

1. Create folder <code>.vscode</code> inside working directory and create a file named <code>tasks.json</code> inside.

2. Copy following lines into <code>tasks.json</code>:
```json
{
	"version": "2.0.0",
	"tasks": [
		{
			"label": "Run javafx",
			"command": "mvn clean javafx:run",
			"type": "shell",
			"presentation": {
				"reveal": "always",
				"group": "build"
			},
			"problemMatcher": []
		}
	]
}


```

3. Open Command Pallete by pressing ```Ctrl + Shift + P```, type in "Tasks", select "Task: Run task".

4. Select "Run javafx".

Note that it may take several minutes on the first run.
