## 프로젝트 기획 내용

> POS SYSTEM

POS SYSTEM은 카페를 이용하는 사람들이 주문을 할 수 있도록 돕는 프로그램이다. 사용자와 관리자 화면으로 나뉘며, 사용자 화면은 사용자가 지점별 위치를 지도를 통해 확인하고 지점을 선택한 뒤 주문할 제품을 고르고 결제를 하면 거스름돈이 화면에 표시된다. 주문이 끝나면 사용자가 구입할 수 있는 제품의 수량도 변한다. 관리자 화면은 사용자가 구매한 제품별 매출을 계산한 차트가 화면에 보여진다. 이 밖에 검색기능을 통해서 웹 검색과 동영상 검색이 가능하고 관리자가 위치한 지역의 날씨 정보를 제공한다.



## 시스템 구성도

![1](https://user-images.githubusercontent.com/24764210/97164700-e00ee200-17c5-11eb-9a78-affe83648436.png) 

## 사용 소프트웨어

- Java 8
- 오라클 - 11g
- HTML
- CSS
- Apache-Tomcat
- JSP



## 데이터베이스 구축 SQL문

```sql
-- Café products Table

CREATE TABLE CAFE_PRODUCTS(
	PRODUCT_ID CHAR(5), 
	NAME VARCHAR(20),
	PRICE NUMBER(5),
	STOCK NUMBER(4), 
	PICTURE VARCHAR(30) 
);

-- Charts Table

CREATE TABLE CHART_DATAS(
	BUYDAY VARCHAR(20),
	NAME VARCHAR(20), 
	SUM NUMBER(10)
);
```



## 구동 화면

- 사용자 화면

  ![2](https://user-images.githubusercontent.com/24764210/97165226-b904e000-17c6-11eb-9289-072ea0ffe224.png) 

  - 지점 선택 화면

     ![3](https://user-images.githubusercontent.com/24764210/97165230-ba360d00-17c6-11eb-9945-996070e1411c.png) 

  - 메뉴 선택 화면

    ![4](https://user-images.githubusercontent.com/24764210/97165231-ba360d00-17c6-11eb-81f5-11fb8ac94c55.png) 

  - 결제 화면


    ![5](https://user-images.githubusercontent.com/24764210/97165232-bacea380-17c6-11eb-9dce-9105bfaab5e8.png)

    ![6](https://user-images.githubusercontent.com/24764210/97165234-bb673a00-17c6-11eb-8f51-f5cce8905f00.png)  

- 관리자 페이지

  - 서버에 저장된 데이터를 월별 매출 그래프로 변환하여 출력 

    ![7](https://user-images.githubusercontent.com/24764210/97165236-bb673a00-17c6-11eb-99cc-0aa8a3109d6b.png) 

  - 서버에 저장된 데이터를 품목별 매출 그래프로 변환하여 출력하는 페이지

    ![8](https://user-images.githubusercontent.com/24764210/97165238-bbffd080-17c6-11eb-8231-bb7909208f85.png) 

  - 기상청 날씨 예보 API를 이용한 날씨 자동 업데이트

    ![9](https://user-images.githubusercontent.com/24764210/97165239-bbffd080-17c6-11eb-947c-53643e9b00ee.png) 

  - 웹 검색어 입력

    ![10](https://user-images.githubusercontent.com/24764210/97165241-bc986700-17c6-11eb-969e-3ae1a866d31e.png) 

  - 카카오 오픈api를 이용한 웹 검색

    - 제목 클릭시 해당 화면으로 이동

      ![11](https://user-images.githubusercontent.com/24764210/97165242-bc986700-17c6-11eb-973f-389048b8bdb3.png) 

  - 카카오 오픈api를 이용한 영상 검색

    - 제목 클릭시 해당 화면으로 이동

      ![12](https://user-images.githubusercontent.com/24764210/97165243-bd30fd80-17c6-11eb-9c7a-c9ff0bb49a09.png) 

