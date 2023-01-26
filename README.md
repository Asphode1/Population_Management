# Lele's Population Management (Phần mềm Quản lý nhân khẩu Lệ Lệ)

(TIẾNG VIỆT PHÍA DƯỚI)

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

#### Preffered IDE for running/testing: [Visual Studio Code](https://code.visualstudio.com/).

#### Recommended extension for better performance:

[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[JavaFX Support](https://marketplace.visualstudio.com/items?itemName=shrey150.javafx-support)

# SQL Server Configuration

## Enable the sa account in SQL Server

### To Change the Authentication Mode:

Follow the steps mentioned below to change the authentication mode from Windows Authentication to SQL Server and Windows Authentication. You need to remember that, the SQL Server service needs to restart to make this change effective.

1. Login to the SQL server instance using SQL Server Management Studio (SSMS). Right-click on the database instance, and go to Properties.

2. On the Server Properties page, Click on Security. Click on the radio button next to SQL Server and Windows Authentication mode, and click on OK to close the Server Properties page.

As discussed earlier, we need to restart the SQL Server service to make this change effective. After restarting the SQL Server, the authentication mode will be changed to SQL Server and Windows Authentication mode.

### Enable the sa Login:

1. Connect to the SQL Server instance using SSMS and go to Security. Expand Security, go to Logins.

2. You can see the sa account is disabled when you install SQL Server using Windows Authentication mode.

3. Right-click on the sa account and go to Login Properties. Specify a complex password for the sa account. By default, the Enforce password policy is checked. (if you don’t want to provide a complex password for the sa account, you can uncheck this option. However, this is not recommended.)

4. Click on the Status page. By default, the sa account will be disabled. Click on the Enabled button to enable the sa account. Click on Ok to close the sa Login Properties.

Thus, sa account is enabled and you will be able to login to the SQL instance using the sa account.

## Enable the protocol TCP/IP and Open the port 1433

1. Open Computer Management (you can search for it at Start).

2. Click on Services and Application -> SQL Server Configuration Manager -> SQL Server Network Configuration -> Protocol for SQL Express (or MSSQL, depend on what version running on your computer).

3. Right-click and Enable the TCP/IP protocol, then click on Properties of this Protocol.

4. Move to IP Addresses -> IPALl (at the bottom), type 1433 in TCP Port. Click OK to close.

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


# Yêu cầu

[Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/#jdk19-windows), phiên bản 19.0.1 trở lên.

[Apache Maven](https://maven.apache.org/download.cgi), phiên bản 3.8.7.

Kiểm tra [trang hướng dẫn](https://www.tutorialspoint.com/maven/maven_environment_setup.htm) này để cài đặt Maven đúng cách.

Kiểm tra phiên bản JDK và Maven hiện tại trên PC của bạn bằng các lệnh sau trên cmd:

```ps1
javac -version
mvn -v
```

nếu phiên bản hiện tại thấp hơn phiên bản yêu cầu, vui lòng cập nhật/cài đặt lại.

[SQL Server](https://www.microsoft.com/en-us/sql-server/sql-server-downloads), phiên bản 2019 trở lên, MSSQL Server hoặc SQL Server Express.

#### IDE ưu tiên để chạy/thử nghiệm: [Visual Studio Code](https://code.visualstudio.com/).

#### Extension được đề xuất để có hiệu suất tốt hơn:

[Gói tiện ích mở rộng cho Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[Hỗ trợ JavaFX](https://marketplace.visualstudio.com/items?itemName=shrey150.javafx-support)

# Cấu hình SQL Server

## Kích hoạt tài khoản sa trong SQL Server

### Thay đổi Chế độ Authentication:

Thực hiện theo các bước được đề cập bên dưới để thay đổi chế độ Authentication từ Windows Authentication sang SQL Server and Windows Authentication. Dịch vụ SQL Server cần khởi động lại để thay đổi này có hiệu lực.

1. Đăng nhập vào SQL server instance bằng SQL Server Management Studio (SSMS). Nhấp chuột phải vào phiên bản cơ sở dữ liệu và đi đến Properties.

2. Trên trang Server Properties, Nhấp vào Security. Nhấp vào nút bên cạnh chế độ SQL Server and Windows Authentication và nhấp vào OK để đóng trang Server Properties.

Khởi động lại dịch vụ SQL Server để thay đổi trên có hiệu lực. Sau khi khởi động lại SQL Server, chế độ xác thực sẽ được thay đổi thành chế độ SQL Server and Windows Authentication.

### Kích hoạt đăng nhập tài khoản sa:

1. Kết nối với phiên bản SQL Server bằng SSMS và chuyển đến Security. Mở rộng Security, đi tới Logins.

2. Bạn có thể thấy tài khoản sa bị vô hiệu hóa khi cài đặt SQL Server bằng chế độ Windows Authentication.

3. Nhấp chuột phải vào tài khoản sa và đi đến Login Properties. Chọn một mật khẩu đủ phức tạp cho tài khoản sa. 

4. Nhấp vào trang Status. Theo mặc định, tài khoản sa sẽ bị vô hiệu hóa. Nhấp vào nút Enable để kích hoạt tài khoản sa. Chọn Ok để đóng sa Login Properties.

Bây giờ, bạn sẽ có thể đăng nhập vào phiên bản SQL bằng tài khoản sa.

## Bật giao thức TCP/IP và Mở cổng 1433

1. Mở Computer Management (có thể tìm ở Start).

2. Nhấp vào Services and Application -> SQL Server Configuration Manager -> SQL Server Network Configuration -> Protocol for SQL Express (hoặc MSSQL, tùy thuộc vào phiên bản đang chạy trên máy tính của bạn).

3. Nhấp chuột phải và Enable giao thức TCP/IP, sau đó nhấp vào Properties của giao thức này.

4. Di chuyển đến IP Addresses -> IPALl (ở dưới cùng), điền 1433 tại TCP Port. Nhấn OK để đóng lại.

5. Quay lại Sercer Configuration Manager -> SQL Server Services. Nhấp chuột phải và Khởi động lại Máy chủ SQL của bạn (SQLExpress hoặc MSSQL).

# Nhập cơ sở dữ liệu
Chạy QuanLyNhanKhauCreateTables.sql bằng SQL Server Management Studio.

Mở tệp DatabaseConfig.txt và thay đổi cấu hình cơ sở dữ liệu của bạn (tên máy chủ và mật khẩu).

# Chạy chương trình

## Sử dụng cmd

Mở cmd và thực hiện lệnh sau:
```ps1
mvn clean javafx:run
```

## Sử dụng VSCode

1. Tạo thư mục <code>.vscode</code> bên trong thư mục làm việc và tạo một tệp có tên <code>tasks.json</code> bên trong.

2. Sao chép các dòng sau vào <code>tasks.json</code>:

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

3. Mở Command Pallete bằng cách nhấn `Ctrl + Shift + P`, nhập "Tasks", chọn "Task: Run task".

4. Chọn "Run javafx".

Lưu ý rằng có thể mất vài phút trong lần chạy đầu tiên.