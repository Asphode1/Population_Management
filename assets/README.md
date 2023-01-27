# Phần mềm Quản lý nhân khẩu Lệ Lệ

## Mục lục

1. [Yêu cầu](#yêu-cầu)
2. [Cấu Hình SQL Server](#cấu-hình-sql-server)
3. [Nhập cơ sở dữ liệu](#nhập-cơ-sở-dữ-liệu)
4. [Chạy chương trình](#chạy-chương-trình)
5. [Những người đóng góp](#những-người-đóng-góp)

6. [Giấy phép](#giấy-phép)

# Yêu cầu

[Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/#jdk19-windows), phiên bản 19.0.1 trở lên.

[Apache Maven](https://maven.apache.org/download.cgi), phiên bản 3.8.7.

Kiểm tra [trang hướng dẫn](https://www.tutorialspoint.com/maven/maven_environment_setup.htm) này để cài đặt Maven đúng cách.

Kiểm tra phiên bản JDK và Maven hiện tại trên PC của bạn bằng các lệnh sau trên cmd:

```ps1
javac -version
mvn -v
```

Nếu phiên bản hiện tại thấp hơn phiên bản yêu cầu, vui lòng cập nhật/cài đặt lại.

[SQL Server](https://www.microsoft.com/en-us/sql-server/sql-server-downloads), phiên bản 2019 trở lên, MSSQL Server hoặc SQL Server Express.

[SQL Server Management Studio (SSMS)](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16) phiên bản 19.

#### IDE ưu tiên để chạy/thử nghiệm: [Visual Studio Code](https://code.visualstudio.com/).

#### Extension được đề xuất để có hiệu suất tốt hơn:

[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

[JavaFX Support](https://marketplace.visualstudio.com/items?itemName=shrey150.javafx-support)

# Cấu hình SQL Server

## Kích hoạt Tài khoản SQL Server Authentication

Khởi động lại dịch vụ SQL Server sau mỗi bước để những thay đổi sau đây có hiệu lực.

### Thay đổi Chế độ Authentication:

1. Đăng nhập vào SQL server instance bằng SQL Server Management Studio (SSMS). Nhấp chuột phải vào phiên bản cơ sở dữ liệu và đi đến Properties.

2. Trên trang Server Properties, Nhấp vào Security. Bật chế độ SQL Server and Windows Authentication.

3. Tại mục "Server proxy account", chọn "Enable server proxy account", nhập "Proxy Accout" là `sa` và tạo một mật khẩu, sau đó nhấn OK.

### Kích hoạt đăng nhập Tài khoản SQL Server Auth:

1. Kết nối với phiên bản SQL Server bằng SSMS và chuyển đến Security > Logins.

2. Nhấp chuột phải vào tài khoản `sa` và đi đến Login Properties.

3. Nhấp vào trang Status. Tại mục Login, nhấn Enable để kích hoạt đăng nhập bằng tài khoản `sa`, Nhấn Ok.

4. Khởi động lại và đăng nhập vào SQL Server Instance trong SSMS bằng chế độ SQL Server Authentication. Nếu không thành công, hãy thử khởi động lại máy tính.

## Bật giao thức TCP/IP

1. Mở SQL Server Configuration Manager.

2. Chọn thẻ SQL Server Network Configuration, chọn giao thức của SQL Server instance đang sử dụng.

3. Nhấp chuột phải và mở Properties, thay đổi cài đặt Enabled thành Yes.

4. Di chuyển đến thẻ IP Addresses -> IPAll, nhập 1433 vào mục TCP Port. Nhấn OK.

# Nhập cơ sở dữ liệu

Chạy [QuanLyNhanKhauCreateTables.sql](../QuanLyNhanKhauCreateTables.sql) bằng SQL Server Management Studio.

Mở tệp [DatabaseConfig.txt](../DatabaseConfig.txt) và thay đổi cấu hình cơ sở dữ liệu của bạn (tên máy chủ và mật khẩu).

# Chạy chương trình

## Sử dụng cmd

Mở cmd và chạy lệnh sau:

```ps1
mvn clean javafx:run
```

## Sử dụng VSCode

1. Tạo thư mục <code>.vscode</code> bên trong thư mục làm việc và tạo một tệp có tên <code>tasks.json</code> bên trong.

2. sao chép các dòng sau vào <code>tasks.json</code>:

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

3. Mở Command Pallete bằng cách nhấn `Ctrl + Shift + P`, nhập `Task`, chọn `Task: Run task`.

4. Chọn `Run javafx`.

Lưu ý rằng có thể mất tới vài phút trong lần chạy đầu tiên.

# Những người đóng góp

1. [Mai Trung Kiên](https://github.com/Asphode1)
2. [Hồ Viết Đức Lương](https://github.com/LuongHvd)
3. [Lê Nam Khánh](https://github.com/khanhkhanhlele)
4. [Ngô Trần Anh Thư](https://github.com/Chercher16)
5. [Lê Vũ Minh Tâm](https://github.com/levuminhtam2002)

# Giấy phép

Được cấp phép theo giấy phép [MIT](../LICENSE.md)
