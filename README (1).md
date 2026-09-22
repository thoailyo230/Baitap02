# LAB1 - Bắt gói tin Telnet - SSH

## 1. Thông tin sinh viên

Họ và tên: Nguyễn Trường Thoại  
MSSV: 1050080203  
Lớp: 11_THMT  
Môn học: An toàn Hệ thống thông tin  
Tên bài Lab: Lab 1 - Bắt gói tin Telnet - SSH  
Video thực hành: https://youtu.be/pyyjD_QcTyo (Em đã làm đầy đủ các phần của bài Lab, tuy nhiên trong quá trình quay video em không để ý OBS đã dừng ghi nên video chỉ ghi lại được khoảng 57 phút đầu. Em có chụp lại các ảnh kết quả thực hành và đưa vào file Word để làm minh chứng. Mong thầy thông cảm ạ.)

## 2. Mục tiêu

Bài Lab thực hiện mô hình gồm Server, Client và Attacker trong cùng mạng nội bộ.

Mục tiêu chính:
- Thiết lập mô hình mạng trên VMware.
- Kết nối từ Client đến Server bằng Telnet và SSH.
- Sử dụng Wireshark để bắt và phân tích gói tin.
- So sánh mức độ bảo mật giữa Telnet và SSH.
- Kiểm tra dữ liệu có thể quan sát được khi bắt gói Telnet.
- Kiểm tra dữ liệu SSH sau khi được mã hóa.
- Thực hành SSH Public Key Authentication.

## 3. Mô hình mạng

Bài Lab sử dụng 3 máy ảo Kali Linux trên VMware Workstation.

Server:
- Tên máy: Kali-Server
- IP mạng LAB1: 10.0.0.1/24

Client:
- Tên máy: Kali-Client
- IP mạng LAB1: 10.0.0.2/24

Attacker:
- Tên máy: Kali-Attacker
- IP mạng LAB1: 10.0.0.3/24

Mỗi máy có 2 card mạng:
- Card NAT dùng để truy cập Internet.
- Card LAN Segment LAB1 dùng cho mạng thực hành.

Sau khi cấu hình, các máy đã ping được nhau với 0% packet loss.

## 4. Nội dung đã thực hiện

### 4.1. Thiết lập môi trường

- Clone máy Kali Linux thành 3 máy Server, Client và Attacker.
- Cấu hình VMware LAN Segment với tên LAB1.
- Đặt IP tĩnh cho từng máy.
- Kiểm tra kết nối giữa các máy bằng lệnh ping.
- Cài đặt Wireshark trên máy Attacker.

### 4.2. Bắt gói Telnet

Trên Server đã cài và bật dịch vụ Telnet.

Kiểm tra cổng 23:

```bash
sudo ss -ltnp | grep ':23'
```

Trên Client kết nối đến Server:

```bash
telnet 10.0.0.1
```

Sau khi đăng nhập, thực hiện một số lệnh kiểm tra như:

```bash
whoami
pwd
ls
mkdir lab1_telnet
echo HELLO_TELNET_LAB1
```

Trên Attacker mở Wireshark, chọn card mạng LAB1 và sử dụng bộ lọc:

```text
tcp.port == 23
```

Sau đó sử dụng Follow TCP Stream để xem dữ liệu trao đổi giữa Client và Server.

Kết quả cho thấy nội dung phiên Telnet có thể quan sát được ở dạng đọc được khi bắt đúng lưu lượng.

### 4.3. Telnet với mật khẩu phức tạp

Thay đổi mật khẩu của tài khoản thử nghiệm thành mật khẩu dài hơn 10 ký tự, gồm chữ, số và ký tự đặc biệt.

Sau đó thực hiện lại quá trình đăng nhập Telnet và bắt gói bằng Wireshark.

Kết quả cho thấy mật khẩu phức tạp không làm cho Telnet trở nên an toàn hơn về mặt mã hóa. Dữ liệu trao đổi của phiên Telnet vẫn có thể bị quan sát nếu bắt được lưu lượng.

### 4.4. Bắt gói SSH

Trên Server đã cài OpenSSH Server:

```bash
sudo apt install openssh-server -y
sudo service ssh start
sudo ss -ltnp | grep ':22'
```

Trên Client kết nối đến Server:

```bash
ssh uitlab@10.0.0.1
```

Ở lần kết nối đầu tiên đã kiểm tra host key fingerprint trước khi chấp nhận kết nối.

Sau khi đăng nhập thực hiện các lệnh:

```bash
whoami
pwd
ls
mkdir lab1_ssh
echo HELLO_SSH_LAB1
```

Trên Attacker sử dụng Wireshark với bộ lọc:

```text
tcp.port == 22
```

Sau đó dùng Follow TCP Stream để kiểm tra phiên SSH.

Kết quả cho thấy Wireshark vẫn quan sát được địa chỉ IP, port, thời gian và kích thước gói tin, nhưng nội dung lệnh và thông tin đăng nhập không xuất hiện ở dạng plaintext như Telnet.

### 4.5. SSH Public Key Authentication

Trên Client tạo cặp khóa:

```bash
ssh-keygen -t ed25519 -C "lab1-client"
```

Sao chép public key lên Server:

```bash
ssh-copy-id -i ~/.ssh/id_ed25519.pub uitlab@10.0.0.1
```

Sau đó kiểm tra đăng nhập:

```bash
ssh uitlab@10.0.0.1
```

Public key được lưu trên Server, còn private key được giữ trên Client.

## 5. Kết quả

Sau khi hoàn thành bài Lab, em đã thực hiện được:
- Xây dựng mô hình Server, Client và Attacker.
- Cấu hình mạng LAB1 và kiểm tra kết nối thành công.
- Cài đặt và sử dụng Telnet Server.
- Bắt gói Telnet bằng Wireshark.
- Phân tích phiên Telnet bằng Follow TCP Stream.
- Thực hiện lại Telnet với mật khẩu phức tạp.
- Cài đặt và sử dụng SSH Server.
- Bắt gói SSH bằng Wireshark.
- So sánh dữ liệu quan sát được giữa Telnet và SSH.
- Kiểm tra host key fingerprint khi kết nối SSH.
- Thực hành SSH Public Key Authentication.

Qua kết quả thực hành, Telnet không mã hóa nội dung phiên nên dữ liệu có thể bị đọc khi lưu lượng bị bắt. SSH sử dụng mã hóa nên nội dung lệnh và thông tin đăng nhập không thể đọc trực tiếp bằng Wireshark như Telnet.

## 6. Lưu ý khi chạy lại bài

Khởi động đủ 3 máy ảo và kiểm tra IP:

Server:
```text
10.0.0.1
```

Client:
```text
10.0.0.2
```

Attacker:
```text
10.0.0.3
```

Kiểm tra kết nối bằng ping.

Kiểm tra Telnet:

```bash
sudo ss -ltnp | grep ':23'
```

Kiểm tra SSH:

```bash
sudo ss -ltnp | grep ':22'
```

Bộ lọc Wireshark cho Telnet:

```text
tcp.port == 23
```

Bộ lọc Wireshark cho SSH:

```text
tcp.port == 22
```

Telnet chỉ được sử dụng trong mạng LAB1 phục vụ thực hành, không sử dụng trên mạng Internet thực tế.

## 7. Kết luận

Qua bài Lab, em hiểu rõ hơn sự khác nhau giữa Telnet và SSH.

Telnet có thể dùng để truy cập từ xa nhưng không có cơ chế mã hóa dữ liệu phiên, vì vậy có nguy cơ lộ thông tin nếu lưu lượng bị bắt.

SSH an toàn hơn do dữ liệu được mã hóa và có cơ chế xác thực host key. SSH cũng hỗ trợ xác thực bằng public key thay cho việc chỉ sử dụng mật khẩu.

Bài Lab giúp em hiểu rằng mật khẩu mạnh không thể thay thế cho một giao thức truyền dữ liệu an toàn.
