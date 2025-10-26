# java-racingcar-precourse

## 구현 기능 목록

### 입력 기능 - `InputView`
  - [X] `InputView`
    - 쉼표(,) 기준 자동차 이름 입력받는 기능
    - 시도할 횟수를 입력받는 기능

### 유효성 검증 및 이름 분리 - `NameParser`, `TrialValidation`

  - [X] `NameParser` 이름의 유효성 검증 및 분리
    - 입력된 이름이 비어있는지 확인
    - 공백 없이 알파벳과 쉼표(,)만으로 구성되어 있는지 확인
    - 입력이 (이름,이름,이름 ...) 형태인지 확인
    - 각 자동차의 이름이 5자를 넘어가지 않는지 확인
    - 중복되는 이름이 있는지 확인
    - 모든 유효성 검사를 통과한 후 쉼표(,)를 기준으로 분리

    
  - [X] `TrialValidation` 시도 횟수 검증
    - 숫자를 입력했는지 확인
    - 자연수인지 확인
    <br/>

### 랜덤 값 생성기 - `RandomNumber`
  - [X] `RandomNumber` 랜덤 값 생성
    - 0~9 사이의 정수

### 자동차 객체 생성 - `Car`, `MakeCar`
  - [X] `Car` 자동차 객체
    - 이름, 랜덤값 생성기, 현재 위치 포함
    

  - [X] `MakeCar` 모든 `Car`객체 생성 및 저장
    - 모든 자동차 이름에 대해 `Car` 객체 생성 후 `List` 형태로 저장

### 자동차 레이싱 - `Racing`
  - [X] `Racing`
    - 모든 자동차에 대해 랜덤 값 추출 후 전진 혹은 정지

### 우승자 찾기 - `Winner`
  - [X] `Winner` 우승한 차량 이름 
    - 공동 우승자가 있다면 모두 반환

### 출력 기능 - `OutputView`
  - [X] `OutputView` 
    - 모든 시도에 대한 결과 출력
    - 우승자 출력

### 컨트롤러 - `RacingController`
  - [X] `RacingController`
    - 모든 기능을 조합

---

## 테스트 목록 

### 입력 및 유효성 테스트
  - [ ] `NameTrialValidationTest` 입력과 유효성 검증에 대한 테스트
    - `NameParser` 
      - 이름이 정상적으로 분리되는지 테스트
      - 조건에 맞지 않은 입력이 들어왔을 때 `IllegalArgumentException`을 발생시키는지 테스트
    - `TrialValidation`
      - 조건에 맞지 않은 입력이 들어왔을 때 `IllegalArgumentException`을 발생시키는지 테스트

### 자동차 테스트
  - [ ] `CarTest` 자동차의 전진과 정지 테스트
    - `Car`
    - `MakeCar`
    - `Racing`
      - 랜덤 값이 주어졌을 때 전진 혹은 정지 하는지 테스트
      - 주행 완료 후 최종 위치가 올바른지 테스트

### 우승자 테스트
  - [ ] `WinnerTest` 우승자 판별 테스트
    - `Winner`
      - 공동 우승자 포함 올바르게 판별하는지 테스트