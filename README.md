# Spring 응답/에러 모델 구현 과제

## 필수 요구사항

Status.code: http status 가 아닌 서버에서 정의하는 code값이 담겨져 있어야 합니다.(정상응답에서는 항상 200)

Status.message: 정상응답시에는 “OK”, 에러 응답에서는 에러에대한 상세한 이유를 담아줍니다.

Metadata.resultCount: 정상 응답시에 나타나는 값입니다. results list 의 count 를 담아줍니다.

Results: 정상응답시에 나타나는 값입니다. 항상 list 형태로, 실제 응답으로 내주고싶은 정보가 표시됩니다.

Data: 에러 응답시에 나타나는 값으로, 에러 응답시에 frontend 에서 사용자에게 어떤 이유로 요청이 거부되었는지 메세지를 만들기 쉽게 필요한 데이터를 넣어줍니다.  ****

위의 응답(에러) 예시를 만족하는 응답을 가진 API 를 구현합니다.

### API 요구사항

- [X] 이름과 성적을 입력받아 저장하는 api
   - 성적의 입력은 특정 값(위 에러 응답일 경우에서는 6) 이 넘었을 경우에는 에러 응답이 나타나야 합니다.
- [X] 입력된 성적을 조회 하는 api
   - 성적 오름차순으로 조회가 되어야 합니다.
- [X] 특정 성적을 입력받아, 해당 성적의 학생만 조회하는 api

### 구현 요구사항

- [X] Controller 에서 응답 모델로 만들어 주어야 합니다. 
- [X] 에러응답을 만들기 위해서는 @ExceptionHander 를 사용하여 exception 의 데이터를 이용해야 합니다.
- [X] exceptionHander 에서 응답모델을 만들때 필요한 데이터가 포함시킬 수 있는 customException 을 구현 해야 합니다.
   - ex. CustomException(ErrorCode, massge, data) - ErrorCode 는 enum 으로 정의 합니다.


## 선택 요구사항

- [X] 에러 응답에서 다음의 경우에서도 정상적으로 data 가 응답의 결과로 나올 수 있도록 합니다.
  ![image](https://github.com/Jjuhui313/springResponseError/assets/94800969/7ea15c74-fe86-4d27-baf1-6b6b4481cea8)



## 결과
- 이름과 성적을 입력받아 저장하는 api
  - [정상 응답]
  <img width="557" alt="스크린샷 2024-01-16 오후 1 19 55" src="https://github.com/Jjuhui313/springResponseError/assets/94800969/363f45ca-8d3f-450c-994b-7deeb0ad6243">
<br/>

  - [에러 응답 (grade에 6 이상인 값을 넣었을 때)]
  <img width="546" alt="스크린샷 2024-01-16 오후 2 21 30" src="https://github.com/Jjuhui313/springResponseError/assets/94800969/b8467aa0-0845-413e-a864-56df8cc76a1b">
<br/><br/>


- 입력된 성적을 조회 하는 api
<img width="564" alt="스크린샷 2024-01-16 오후 1 21 14" src="https://github.com/Jjuhui313/springResponseError/assets/94800969/12bad17a-8d23-4fd4-bce2-910ded61478a">
<br/><br/>


- 특정 성적을 입력받아, 해당 성적의 학생만 조회하는 api
<img width="550" alt="스크린샷 2024-01-16 오후 1 21 28" src="https://github.com/Jjuhui313/springResponseError/assets/94800969/8a2f9042-01d7-4341-a70b-d56a0dc251e1">


