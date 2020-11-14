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

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/list/spark/spark(1).png).


<br><br>


<h2> 5. 실습에 사용할 파일 업로드 하기 </h2>

#### - Databricks 이용하기
    - https://community.cloud.databricks.com
    - 노트북에서 Upload Data 선택 후 파일을 업로드
    - 업로드 완료 후 업로드 된 파일 경로 확인
      예) display(dbutils.fs.ls("파일 경로"))

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/list/spark/spark(2).png).


<br><br>

