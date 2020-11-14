<h1> Spark 등장 배경</h1>

<br><br>

<h2> 1. Hadoop MapReduce 플랫폼의 특성 </h2>

#### - 확장성이 있고 문제 발생시 이를 잘 대처해줌
#### - 하지만, 작업 중간에 결과물을 디스크에 지속적으로 기록해서 처리 속도가 느려짐
#### - 또한, 반복적인 작업에 좋지 않음(대부분은 기계학습 작업)
#### - 그리고, 스크립트 기반의 인터페이스가 native하게 지원 안됨

<br><br>

<h2> 2. 스파크의 목적 및 장점 </h2>

#### - 디스크가 아닌 메모리를 사용하여 처리 시간 단축
    - 반복적 작업에 좋음 ==> 기계 학습 작업
    - Interactive 한 작업에 좋음(RAM의 working sets)
#### - 다양한 API 지원
    - 하둡은 Map/Reduce API만 지원
#### - 다양한 워크로드 지원
    - 기계 학습, 스트림 처리, SQL 등
#### - 하둡 시스템의 장점 계승
    - 확장성, 안정성, 데이터 전송 최소화

<br><br>


<h2> 3. 스파크의 특징 </h2>

#### - 다양한 언어의 API 지원
    - Scala, Java, Python, R
#### - 다양한 데이터 저장소 지원
    - HDFS, Local file system, S3, Databases 등
#### - Interactive 쉘을 지원
    - SparkShell: 스칼라 기반 쉘
    - PySpark: 파이썬 기반 쉘
    - sparkR: R기반 쉘

<br><br>


<h2> 4. 스파크 구조 </h2>

#### - Spark 코어
    - 스파크에서 프로그램 실행을 위한 핵심 API 실행을 지원
    - 확장성 및 안정성 보장
    - 다양한 API를 지원
    - Spark Core의 API를 활용한 다양한 응용이 개발 됨

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(1).png).


#### - Spark 세부 구조
    - 스파크는 분산 처리 환경에서 다양한 데이터 스토리지에서 동작
    - 복잡한 시스템의 추상화(병렬/분산 처리, 기기 실패 처리, 데이터 분배, 작업 분배)
    - 스파크 모듈들(드라이버, Spark Context(SC), Worker nodes, Executor, Cluster manager)

#### - Spark 구성 요소
    - 드라이버: 스파크 작업을 시작하는 프로세스(Scala Interpreter 동작), 스파크 작업의 시작점, 스파크 관련 병렬 작업을 수행하는 SparkContext 객체 생성
    - SparkContext(SC): 스파크 코어 관련 기능을 내포하는 객체, 스파크 클러스와 연결 함, 하나의 JVM(드라이버)에 하나의 SC 객체 존재, 스파크 쉘에서 SparkContext는 자동 생성되고 변수명은 "SC"임
    - Worker nodes: 스파크 작업을 수행하는 분산기기, 하나의 호스트 기기에 하나의 워커 노드 존재
    - Executor: 워커 내에서 동시에 실행되는 JVM 프로세스, 하나의 워커에 여러 개의 Executor 존재 가능, RAM을 활용한 중간 데이터 저장 기능, 각각의 Executor는 서로 다른 CPU의 메모리 할당을 받을 수 있음


<br><br>

<h2> 5. 스파크 핵심 개념() </h2>

#### - Resilient Distributed Datasets(RDD)
    - 여러 노드에 걸쳐서 데이터를 분산 해주고 분산된 데이터에 대해서 병렬로 사용자 지정 함수를 실행하게 해주는 클래스(HDFS의 블락처럼 파일을 쪼갠 후 분산 저장 및 할당 해주는 기능을 기본으로 제공)
    - 스파크 작업의 시작점
    - 프로그래머는 RDD가 어디에 저장 되는지 지정 가능(RAM 또는 Disk)


#### - RDD Operations 
    - Transformation: 존재하는 RDD를 수정함, 새로운 RDD 객체를 리턴함
    - Action: RDD로 부터 연산 후 값을 반환 함, RDD 이외의 값을 리턴(예, List, int 등)
    - 스파크에서 Lazy evaluation: Transformation은 즉각적으로 실행되지 않음, RDD에 Action이 실행될 경우 실제 데이터 처리 발생, 스파크 코어 엔진이 최적화 해줌

#### - Lazy evaluation 이점
    - 스파크에서 Lazy evaluation: Transformation은 즉각적으로 실행되지 않음
    - RDD에 Action이 실행될 경우 실제 데이터 처리 발생, 스파크 코어 엔진이 최적화 해줌


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(4).png).

    - 위의 코드에서 lazy evaluation이 없다면 movies.csv 파일 전체를 읽어 들여서 movies RDD를 생성하고 그 RDD에서 "action" 단어라 포함된 새로운 RDD 생성 후 Count 액션 실행
    - lazy evaluation을 사용하면 중간 결과인 movies가 필요 없고 바로 "action" 키워드의 첨가 여부 확인 후 Count 액션 실행
  

<br><br>


<h2> 6. 실습에 사용할 파일 업로드 하기 </h2>

#### - Databricks 이용하기
    - https://community.cloud.databricks.com
    - 노트북에서 Upload Data 선택 후 파일을 업로드
    - 업로드 완료 후 업로드 된 파일 경로 확인
      예) display(dbutils.fs.ls("파일 경로"))

![Spark](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(2).png).

#### - 스파크 쉘에서 데이터 로드

![Spark](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(3).png).

<br><br>


