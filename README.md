# MVC 패턴 연습과 CRUD 연습
2018년 과제 겸 MVC 패턴과 CRUD 연습

## 준비사항

* JDK (>=8)
* gradle or Intellij
* Spring Boot (>=2.x)

## 실행방법

* RestCrudApplication 실행
* web에서의 localhost:8080 으로 실행

## TODO

- [x] 도메인 생성
- [x] 컨트롤러
- [x] 서비스
- [x] 레퍼지토리

## CRUD 스펙
* Domain
    * Basic
        * idx
        * name
        * label
        * email
        * phone
        * constructor
    * Profile
        * idx
        * network
        * userName
        * url
        * createDat
        * constructor
* Repository
    * BasicRepository
    * ProfileRepository
* Controller
    * BasicController
        * basicService
        * profileService
        * constructor
        * list
        * read
        * add
        * form
        * showUpdateform
        * updateBasic
        * deleteBasic
    * ProfileController
        * profileService
        * basicService
        * constructor
        * read
        * add
        * form
        * showUpdateform
        * updateProfile
        * deleteProfile
* Service
    * BasicService
        * basicRepository
        * constructor
        * findBasicAll
        * save
        * delete
        * findBasicByIdx
    * ProfileService
        * profileRepository
        * constructor
        * findProfileAll
        * save
        * delete
        * findProfileByIdx