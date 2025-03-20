# WebApp 簡易客戶管理系統
## 專案簡介
這是一個基於 CRUD 的簡易客戶管理系統，旨在提供一個基本的用戶管理介面，支援客戶資料的查看、修改、刪除等功能。系統使用，以便用戶在更新客戶資料時能夠立即同步到所有連接的用戶。
![image](https://github.com/Poplollipop/webapp/blob/main/demo.png)

## 技術
- **前端**: HTML, CSS, JavaScript
- **後端**: Java (Spring Boot)
- **資料庫**: MySQL


## 功能說明
客戶列表查看
新增、編輯、刪除客戶資料
即時更新客戶資料


## 啟動指南
1. 安裝所需依賴：`mvn install`
2. 啟動後端：`mvn spring-boot:run`

   ## 文件結構
```
/webapp
 ├── src
 │    ├── main
 │    │    └── java
 │    │        └── com
 │    │            └── bmt
 │    │                └── webapp
 │    │                    ├── controllers
 │    │                    │    ├── ClientsController.java
 │    │                    │    └── HomeController.java
 │    │                    ├── models
 │    │                    │    ├── Client.java
 │    │                    │    └── ClientDo.java
 │    │                    ├── repositories
 │    │                    │    └── ClientRepository.java
 │    │                    └── resources
 │    │                        └── templates
 │    │                            ├── clients
 │    │                            │    ├── create.html
 │    │                            │    ├── edit.html
 │    │                            │    └── index.html
 │    │                            └── index.html
 ├── pom.xml
 ├── README.md
 ├── .gitignore

```

## 總結
這個簡易客戶管理系統提供了基礎的 CRUD 功能，包括顯示、創建、編輯、刪除客戶資料。系統還包含一個首頁，供用戶導航到客戶列表頁面。客戶資料通過 ClientRepository 與資料庫進行交互，並通過 ClientsController 控制頁面的顯示與資料操作。
