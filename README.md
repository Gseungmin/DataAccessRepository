# DataAccessProject
Spring의 DB 접근 기술을 비교 분석하고 테스트하는 프로젝트입니다! 😸

## 🙋‍♂️ 이 프로젝트는 이걸 사용했어요!
### Spring Framework 및 Spring Boot
### JDBC Template
### MyBatis
### JPA
### SpringDataJpa
### QueryDsl

## 클래스 다이어그램
![classdomain](https://user-images.githubusercontent.com/87487149/178133744-d114ab9d-24d3-4b35-83e6-8e9ec1dad00e.png)

## 😸 의존관계! 이렇게 주입했어요!
- ### JDBC Template
  - #### SQL을 직접 사용해야하는 단점을 있지만 JDBC를 직접 사용하는 것보다 코드의 중복을 없애줘요!
  ![Jdbc](https://user-images.githubusercontent.com/87487149/178133993-9b09fc55-62cd-40b9-90b1-9e7898219aab.png)
- ### MyBatis
  - #### SQL을 직접 사용해야하는 단점을 있지만 JDBC Template의 장점을 그대로 가져가면서 동적쿼리 문제를 해결해줘요!
  ![Mybatis](https://user-images.githubusercontent.com/87487149/178134104-03f1d46b-0481-4c5f-87b8-9f5d8f82f3b2.png)
- ### JPA
  - #### SQL을 작성하지 않아도 되지만 동적쿼리에 여전히 문제가 발생해요!
  ![Jpa](https://user-images.githubusercontent.com/87487149/178134227-21854495-afe7-41aa-90d6-6e4e5f8b82c5.png)
- ### SpringDataJpa
  - #### JPA를 더욱 더 편리하게 사용하게 해줘요! 단 여기서 다형성을 지키기 위해 인해 구조가 살짝 복잡해요!
  - #### 아래 JpaRepository는 Spring이 직접 구현한 Repository로 제가 구현한 위의 JpaRepository와는 완전 다른것입니다!
  ![SprindData](https://user-images.githubusercontent.com/87487149/178134323-cbc2f04d-deee-420b-910a-4f5254bd8b22.png)
- ### QueryDsl
  - #### SQL을 자바 코드로 작성해 컴파일 시점 오류를 잡아주며 ORM기술의 동적쿼리 문제를 해결해줘요!
  ![Quer](https://user-images.githubusercontent.com/87487149/178134563-52b196f4-0743-4610-b0d0-8e850f565aa8.png)
- ### JPA+SpringDataJpa+QueryDsl
  - #### 기본적으로 JPA와 SpringDataJpa를 사용하고 동적쿼리에 대해서는 QueryDsl을 사용해요!
  ![recommend](https://user-images.githubusercontent.com/87487149/178134821-9023e224-e958-4f7b-b96b-8ed9cd97041c.png)


# 😸 아래 블로그를 참조해주세요!
각 DB기술의 장단점을 간단하게 정리해두었습니다! 코드 하나하나 절대 분석하지 말고 흐름을 따라 어떤 장점이 있는지 확인해보세요!



## 😄프로젝트 실행 시 주의사항
- 해당 프로젝트는 임베디드 DB 테스트 환경을 사용하므로 별도의 DB를 설치하지 않아도 테스트 환경을 실행할 수 있어요!
- TEST해보고 싶은 DataAccess기술에 대해서는 Config설정 파일을 수정해줘야 해요! 아래 영상을 참조해주세요!

