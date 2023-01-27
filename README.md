# Lele's Population Management

[README Tiếng Việt](assets/README.md)

## Table of Contents

1. [Requirements](#requirements)
2. [SQL Server Configuration](#sql-server-configuration)
3. [Import Database](#import-database)
4. [Run the program](#run-the-program)
5. [Contributors](#contributors)
6. [License](#license)

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

[SQL Server](https://www.microsoft.com/en-us/sql-server/sql-server-downloads), version 2019 or later, MSSQL Server or SQL Server Express.

[SQL Server Management Studio (SSMS)](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16) version 19.

#### Preffered IDE for running/testing: [Visual Studio Code](https://code.visualstudio.com/).

#### Recommended extensions for better performance:

[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[JavaFX Support](https://marketplace.visualstudio.com/items?itemName=shrey150.javafx-support)

# SQL Server Configuration

## Enable SQL Server Auth Account

Make sure to restart the SQL Server service after every step to make these changes effective.

### Change the Authentication Mode:

Follow the steps mentioned below to use SQL Server Authentication.

1. Login to the SQL server instance using SQL Server Management Studio (SSMS). Right-click on the database instance, go to Properties.

2. On the Server Properties page, Click on Security. Enable SQL Server and Windows Authentication mode.

3. Under "Server proxy account", Click "Enable Proxy Account", enter "Proxy account" as `sa` and create a password, then click Ok.

### Enable the SQL Server Auth Login:

1. Connect to the SQL Server instance using SSMS and expand Security > Logins directory.

2. Right-click on the `sa` account, select Properties.

3. Head to the Status page. Enable Login settings for the account. Click Ok.

4. Restart and login to SQL Server Instance in SSMS Using SQL Server Authentication mode with created account. If failed, try restarting the computer.

## Enable TCP/IP Protocol

1. Open SQL Server Configuration Manager.

2. Select SQL Server Network Configuration tab, select the protocol of the SQL Server instance currently using (normally the service with Running State).

3. Right-click TCP/IP protocol, open Properties, change the Enabled settings to Yes.

4. Head to IP Addresses tab, in the IPAll settings (at the bottom), type 1433 in TCP Port. Click OK.

# Import Database

Execute [QuanLyNhanKhauCreateTables.sql](QuanLyNhanKhauCreateTables.sql) using SQL Server Management Studio.

Open file [DatabaseConfig.txt](DatabaseConfig.txt) and change the configuration of your database (server name and password).

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

3. Open Command Pallete by pressing `Ctrl + Shift + P`, type in `Task`, select `Task: Run task`.

4. Select `Run javafx`.

Note that it may take several minutes on the first run.

# Contributors

1. [Mai Trung Kiên](@Asphode1)
2. [Hồ Viết Đức Lương](@LuongHvd)
3. [Lê Nam Khánh](@khanhkhanhlele)
4. [Ngô Trần Anh Thư](@Chercher16)
5. [Lê Vũ Minh Tâm](@levuminhtam2002)

# License

Licensed under the [MIT](LICENSE.md) license.
