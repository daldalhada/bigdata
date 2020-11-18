<h2> 실습에 사용할 파일 업로드 하기 </h2>

#### - Databricks 이용하기
    - https://community.cloud.databricks.com
    - 노트북에서 Upload Data 선택 후 파일을 업로드
    - 업로드 완료 후 업로드 된 파일 경로 확인
      예) display(dbutils.fs.ls("파일 경로"))

![Spark](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(2).png).

#### - 스파크 쉘에서 데이터 로드

![Spark](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(3).png).

<br><br>


<h2> 6. 스파크 핵심 개념 </h2>

#### - Resilient Distributed Datasets(RDD)
    - 여러 노드에 걸쳐서 데이터를 분산 해주고 분산된 데이터에 대해서 병렬로 사용자 지정 함수를 실행하게 해주는 클래스
      (HDFS의 블락처럼 파일을 쪼갠 후 분산 저장 및 할당 해주는 기능을 기본으로 제공)
    - 스파크 작업의 시작점
    - 프로그래머는 RDD가 어디에 저장 되는지 지정 가능(RAM 또는 Disk)


#### - RDD Operations 
    - Transformation: 존재하는 RDD를 수정함, 새로운 RDD 객체를 리턴함
    - Action: RDD로 부터 연산 후 값을 반환 함, RDD 이외의 값을 리턴(예, List, int 등)
    - 스파크에서 Lazy evaluation: Transformation은 즉각적으로 실행되지 않음, 
      RDD에 Action이 실행될 경우 실제 데이터 처리 발생, 스파크 코어 엔진이 최적화 해줌

#### - Lazy evaluation 이점
    - 스파크에서 Lazy evaluation: Transformation은 즉각적으로 실행되지 않음
    - RDD에 Action이 실행될 경우 실제 데이터 처리 발생, 스파크 코어 엔진이 최적화 해줌


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(4).png).

    - 위의 코드에서 lazy evaluation이 없다면 movies.csv 파일 전체를 읽어 들여서 movies RDD를 생성하고 그 RDD에서 
      "action" 단어라 포함된 새로운 RDD 생성 후 Count 액션 실행
    - lazy evaluation을 사용하면 중간 결과인 movies가 필요 없고 바로 "action" 키워드의 첨가 여부 확인 후 Count 액션 실행


#### - RDD Lineage
    - 기본적으로 Spark는 메모리를 많이 씀 ==> 메모리는 휘발성 ==> 휘발성이기 때문에 서버에 문제가 생기면 데이터가 유실될 수 있음 ==> 
      재실행해서 방지해야 함
    - RDD 객체에 일어난 Transformation 들을 순차적으로 기록해둔 것
    - 드라이버 프로세스가 RDD의 lineage를 기록하고 있다가, 필요시 RDD들에 Transformation을 수행하여 특정 버전의 객체를 생성해 낼 수 있음. 

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(5).png).
  

<br><br>

<h2> RDD transformations </h2>


#### - RDD transformations - Map
    - MAP: 입력으로 주어진 RDD의 각 원소에 사용자가 정의한 함수를 실행한 RDD 반환, 각 원소마다 하나의 결과물이 생성될 수 있음

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(6).png).

    - textFile과 map은 transformation이기 때문에 즉각적으로 연산이 일어나지 않음
    - take라는 action을 수행해야 실행이 됨


#### - Spark map and flatmap
    - MAP 함수는 하나의 원소에 입력으로 주어진 함수를 실행 후 각 원소의 결과물이 리스트로 생성될 경우 리스트를 그대로 반환함
     (최종 결과물 - Array[Array[T]])
    - MAP과 달리, flatMap은 함수 실행 후 각 원소에서 나온 결과물을 합해서 전체가 하나의 list로 반횐 됨
      (최종 결과물 - Array[T]) 
  
![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(7).png).

    - 즉, map은 하나의 원소 실행 결과물이 하나의 결과 리스트를 반환하고(N records => N lists)
    - flatMap은 전체에 걸쳐서 하나의 결과물을 반환한다.(N records => 1 list)


#### - RDD transformations - Filter
    - filter(function): 주어진 함수의 결과가 true를 리턴하는 원소만 반환

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(8).png).


#### - RDD transformations - Others
    - RDD1.union(RDD2): RDD1 and RDD2의 원소를 합해서 하나의 RDD 반환, 원소 중복
    - RDD1.distinct(): RDD1의 원소 중 중복된 것을 삭제
    - RDD1.intersection(RDD2): RDD1 and RDD2에서 공통된 원소 반환
    - RDD1.subtract(RDD2): RDD1에 있는 원소 중 RDD2의 원소를 삭제한 RDD 반환


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(9).png).

    - parallelize:  driver에 있는 객체, 로컬 객체를 RDD화 해서 분산 시켜줌, 즉, 굳이 파일 시스템을 involve 하지 않게 편하게 사용 


<br><br>
