## White Night

**개요**

WhiteNight는 사용자가 동기부여 문구를 조회하고, 이를 즐겨찾기하거나 체크리스트로 관리할 수 있는 웹 애플리케이션입니다.

하루의 시작을 동기부여와 목표 달성으로 지원하는 도구입니다.

---

### **프로젝트 목적**

- **동기부여 문구 제공**: 사용자에게 매일 새로운 동기부여 문구를 제공합니다.
- **즐겨찾기 기능**: 마음에 드는 문구를 즐겨찾기에 추가하여 나중에 확인할 수 있습니다.
- **테스크 관리**: 즐겨찾기한 문구에 체크리스트(테스크)를 추가하고, 완료 여부를 관리할 수 있습니다.

---

### **주요 기능**

- **랜덤 문구 조회**
    - 사용자가 버튼을 클릭하여 **랜덤 문구**를 조회합니다.
- **즐겨찾기 추가**
    - 마음에 드는 문구를 **즐겨찾기에 추가**하여 저장합니다.
- **체크리스트 관리**
    - 즐겨찾기한 문구에 **체크리스트(테스크)**를 추가하고, 완료 여부를 관리합니다.

---

### **기술 스택**

- **백엔드**:
    - **Spring Boot**
    - **MyBatis**
- **프론트엔드**:
    - **HTML, CSS, JavaScript**
    - **Fetch API**
- **데이터베이스**:
    - **MariaDB (MySQL)**
- **버전 관리**:
    - **Git**

---

### **프로젝트 구조**

- **Controller**: 사용자 요청을 처리하고, 서비스와 연결되는 역할.
- **Service**: 비즈니스 로직을 처리하는 역할.
- **DAO (Data Access Object)**: 데이터베이스와의 연결을 담당하며, MyBatis 매퍼를 사용.
- **VO (Value Object)**: 데이터를 캡슐화한 객체.
- **Mapper (MyBatis XML)**: SQL 쿼리를 작성하여 DB와 연동.

---

---

### **서비스 설명**

**WhiteNight**는 매일 새로운 **동기부여 문구**를 제공하여 사용자가 **목표 달성**을 위한 동기를 얻을 수 있도록 돕습니다.

사용자는 **즐겨찾기 기능**을 통해 마음에 드는 문구를 저장하고, **체크리스트**를 사용하여 목표를 체계적으로 관리할 수 있습니다.

---

### **프로젝트 관리 및 진행상황**

- **프로젝트 기획 (1일)**
    - 프로젝트 컨셉 정의 및 요구사항 분석
    - 주요 기능 기획 (게시글, 좋아요, 댓글 등)
- **기능 개발 및 수정 (2일)**
    - 데이터베이스 설계 및 테이블 정의
    - 사용자 계정, 게시글 CRUD, 좋아요, 댓글 기능 개발
    - 디버깅 및 성능 테스트

---
### **문제 해결 설명**

- **즐겨찾기 기능 구현 문제**
    
    문제: 즐겨찾기 추가 시 테스크 정보가 함께 저장되어, 즐겨찾기와 테스크가 분리되지 않는 문제가 발생했습니다.
    
    해결: 즐겨찾기 추가와 테스크 추가 기능을 명확히 분리하여, 즐겨찾기 추가 시 quoteId와 quoteText만 저장되도록 수정했습니다. 각 기능이 독립적으로 작동하도록 로직을 변경했습니다.
    

- **문구 조회 및 추가 관련 문제**
    
    **문제**: 랜덤 문구를 조회할 때 서버에서 데이터가 제대로 반환되지 않거나 빈 문구가 표시되는 문제가 있었습니다.
    
    **해결**: 서버에서 랜덤 문구를 JSON 형식으로 정확히 반환하도록 수정하고, 클라이언트에서 데이터를 받아 UI에 반영하는 로직을 구현했습니다. 이를 통해 랜덤 문구가 정확히 표시되도록 개선했습니다.

### **배운 점**

- **API 설계 및 구현**: RESTful API의 설계와 POST, GET 요청에 대한 이해를 강화.
- **비동기 처리**: **Fetch API**를 사용한 클라이언트와 서버 간 비동기 데이터 전송 구현.
- **서비스와 컨트롤러 분리**: 프로젝트의 **비즈니스 로직**을 서비스 계층에서 처리하고, 컨트롤러는 요청을 처리하는 역할에 집중.
- **MyBatis**: **XML 매퍼**를 사용하여 데이터베이스와의 효율적인 연동.

---

### **향후 계획**

- **사용자 인증 기능** 추가: **Spring Security**와 **JWT**를 활용한 사용자 인증 및 권한 부여 기능을 추가할 예정.
- **문구 카테고리 기능**: 문구를 **카테고리별로 분류**하여, 사용자가 관심 있는 카테고리의 문구를 더 쉽게 찾을 수 있도록 개선할 예정.
- **테스크 필터링 및 통계**: 사용자가 완료한 테스크와 진척도를 **필터링**하여 **통계**를 제공하는 기능을 추가할 예정.
