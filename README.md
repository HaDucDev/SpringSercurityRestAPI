# SpringSercurityRestAPI

Ví dụ chỉ dùng Spring security không dùng thêm JWT
*Spring Security + Mysql

Cấc bước khởi chạy dự án
1. Mở dự án với intelij idea
2. Tạo một database có tên springsecurity ở Mysql
3. Chỉnh sửa cấu hình application.properties phù hợp với máy tính của bạn
4. Chạy dự án

Một số API Test

1 GET http://localhost:8080/books/

![image](https://user-images.githubusercontent.com/73648565/168218176-2c0c3658-6906-4678-9687-757fab2b599a.png)


2 GET http://localhost:8080/books/1

![image](https://user-images.githubusercontent.com/73648565/168218375-1ace2527-fec2-4805-be4c-225e7d26410d.png)

{
    "title": "Spring 123",
    "author": "Cranmese",
    "coverPhotoURL": "https://salt.tikicdn.com/cache/400x400/ts/product/5f/d7/35/d6a086d2450d364198cd07ebef63d8a7.jpg",
    "isbnNumber": 9999999999,
    "price": 999999,
    "language": "English 1234"
}
3 POST http://localhost:8080/books
 ![image](https://user-images.githubusercontent.com/73648565/168219017-943ab306-9e09-4114-8e1f-c17edd192d1c.png)

 
4 PUT http://localhost:8080/books/1
![image](https://user-images.githubusercontent.com/73648565/168219334-648ab65b-8aeb-4f4d-8fc5-614b2c8807f9.png)

5 DELETE http://localhost:8080/books/7
 ![image](https://user-images.githubusercontent.com/73648565/168218511-76de4328-e52d-477e-836e-12a9a0341e7c.png)


Nguồn image sử dụng dữ liệu: Tiki
- Code tham khảo:https://www.youtube.com/watch?v=WorfSfWEyvs
