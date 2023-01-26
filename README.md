# Lele's Population Management (Phần mềm Quản lý nhân khẩu Lệ Lệ)

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

# SQL Server Configuration

## Enable the sa account in SQL Server

### To Change the Authentication Mode:

Follow the steps mentioned below to change the authentication mode from Windows Authentication to SQL Server and Windows Authentication. You need to remember that, the SQL Server service needs to restart to make this change effective.

1. Login to the SQL server instance using SQL Server Management Studio (SSMS). Right-click on the database instance, and go to Properties.

2. On the Server Properties page, Click on Security. Click on the radio button next to SQL Server and Windows Authentication mode, and click on OK to close the  Server Properties page.

As discussed earlier, we need to restart the SQL Server service to make this change effective. After restarting the SQL Server, the authentication mode will be changed to SQL Server and Windows Authentication mode.

### Enable the sa Login:

1. Connect to the SQL Server instance using SSMS and go to Security. Expand Security, go to Logins.

2. You can see the sa account is disabled when you install SQL Server using Windows Authentication mode.

3. Right-click on the sa account and go to Login Properties. Specify a complex password for the sa account. By default, the Enforce password policy is checked. (if you don’t want to provide a complex password for the sa account, you can uncheck this option. However, this is not recommended.)

4. Click on the Status page. By default, the sa account will be disabled. Click on the Enabled button to enable the sa account. Click on Ok to close the sa Login Properties.

Thus, sa account is enabled and you will be able to login to the SQL instance using the sa account.

## Enable the protocol TCP/IP and Open the port 1433

1. Open Computer Management (you can search for it at Start).

2. Click on Services and Application -> SQL Sercer Configuration Manager -> SQL Server Network Configuration -> Protocol for SQL Express (or MSSQL, depend on what version running on your computer).

3. Right-click and Enable the TCP/IP protocol, then click on Properties of this Protocol.

4. Move to IP Addresses -> IPALl (at the bottom), fill 1433 at TCP Port. Click OK to close.

5. Back to SQL Sercer Configuration Manager -> SQL Server Services. Right-click and Restart your SQL Server (SQLExpress or MSSQL).

# Import Database
Execute QuanLyNhanKhauCreateTables.sql using SQL Server Management Studio.

Open file DatabaseConfig.txt and change the configuration of your database (server name and password).

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

3. Open Command Pallete by pressing `Ctrl + Shift + P`, type in "Tasks", select "Task: Run task".

4. Select "Run javafx".

Note that it may take several minutes on the first run.