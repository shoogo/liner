# liner

1. 프로젝트 구성안내
>  + 개발언어   : Java 11
>  + 프레임워크 : SpringBoot
>  + DBMS      : MaraiaDB
  
2. 프로젝트 사용법
>  + SpringBoot 가 실행 가능한 환경에서 해당 프로젝트를 빌드
>  + 프로젝트를 war 파일로 배포하여 Tomcat 환경에서 구동
  
3. 프로젝트 기능설명
>  + 하이라이트 저장
>  + 하이라이트 수정
>  + 페이지 내 하이라이트 정보 가져오기
>  + 유저가 하이라이트한 정보와 페이지 가져오기
>  + 하이라이트 삭제
>  + 유저의 하이라이트 테마 변경
>  + 유저의 하이라이트 테마 수정 및 생성
>  + 유저의 하이라이트 테마 삭제
  
4. DB 설계(DDL.sql 참조)
>  - 제한 사항
>    - 포링키는 사용하지 않음. 데이터 정합성에 중요한 역할을 수행하긴 하나, 테스트 데이터 삽입에 불편함이 있기 때문에 사용하지 아니함.
>    - 별도의 히스토리 테이블을 만들지 않음.(실제 서비스에서는 수정과 삭제 이력에 대한 히스토리 테이블을 만들어야 할 것으로 판단)
>    - 히스토리 테이블의 부재로 삭제 대신 상태 FLAG 값을 사용.
>  + User : 회원 테이블. 회원 기반 시스템이기에 임시로 생성. 회원데이터는 직접 추가
>  + User_theme : 회원의 보유 테마 저장. 
>    + 유저와 유저의 테마는 1:n 관계로 파악. 유저의 테마정보를 별도의 테이블로 관리하는게 운영에 용이할 것으로 판단.
>    + 현재 사용 테마에 대한 컬럼 값만 변경하면 되기때문에 테마 변경에 따른 색의 변경은 필요 없음.
>  + Theme_info : 테마의 컬러와 순번을 저장. User_theme의 theme_id 를 포링키로 사용할 수 있다.
>    + 테마와 컬러의 관계는 1:n으로 판단. 유저 테마 테이블의 컬럼으로 색 칼럼을 추가할 수도 있었으나, 3~6개라는 확정되지 않은 색의 가지수와 향후 변할 수 있는 데이터이기에 별도의 테이블로 분리.
>  + User_highlight : 유저의 하이라이트 정보를 저장. 
>    + 가장 수정과 삽입이 빈번한 테이블로, page_info와 1:n 관계로 생성. 
>  + page_info : 유저의 저장 URL을 관리
>    + 유저의 페이지 정보를 관리하는 테이블. 하이라이트 테이블에 비해 상대적으로 삽입/수정이 적게 일어나기 때문에 별도의 테이블로 분리.
>  + Master_Theme : 기본 테마 등 시스템에서 관리하는 테마 정보를 저장
>    + 시스템에서 관리하는 기본적인 테마의 정보를 저장.
>    + 변경이 없는 데이터이기 때문에 DB가 아닌 properties 파일로 관리하여 서비스 로딩시 메모리에 올려두고 쓰는 것도 하나의 방법일듯하나 변경이 잦을지도 몰라 테이블로 구성
    

5. 제한사항

 > + 예외처리
 > + 테마 삭제
  
  

  
