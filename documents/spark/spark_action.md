<h2> RDD actions </h2>


#### - RDD actions
    - RDD Transformation과 다르게 Action은 RDD가 아닌 실제 값을 반환 함
    - RDD 이외의 값리 리턴됨(Transformation의 경우 RDD를 반환 함)

#### - RDD actions - reduce
    - 입력으로 주어진 RDD 원소에 주어진 function을 실행하여 aggregation 진행
    - 교환법칙, 결합법칙이 성립되어야 함

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(10).png).


#### - RDD actions - reduce 응용
    - 장르 개수가 가장 많은 영화 구하기

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(11).png).

    - movieInfo.map(mi => mi(2).split('|'))     // 영화 장르가 담긴 배열 리턴
    - .map(x=>x.length).                        // 영화 장르의 길이를 리턴(Int)
    - reduce((x,y)=> Math.max(x,y))             // 영화 장르의 길이 최대값을 리턴(Int)


#### - RDD actions - collect
    - RDD의 모든 값을 확인 및 반환
    - 드라이버로 모든 값이 반환 됨으로 메모리 초과(OOM)에 유의

#### - RDD actions - take(N)
    - 첫 N개의 원소를 RDD로부터 반환

#### - RDD actions - takeOrdered(N)(OrderingMethod)
    - 정렬된 상태에서 N개 원소 반환(기본: 오름차순)


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(12).png).



#### - RDD actions - takeSample(withReplacement, num, seed)
    - RDD 원소 중 임의 원소를 반환함
    - withReplacement가 true라면 중복된 원소가 반환될 수 있음

#### - RDD actions - count
    - RDD에서 원소의 개수를 밴환

#### - RDD actions - coutByValue
    - 각 원소별로 발생하는 횟수를 카운트 후 결과 반환


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(13).png).


#### - RDD actions - saveAsTextFile(Path)
    - RDD의 결과물을 파일로 저장하는 API
    - 결과물은 리듀스를 실행하는 워커 갯수(파티션)에 따라 별개의 파일로 생성
    - 각각의 파티션은 Part-xxxxx 파일로 생성 됨


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(14).png).

    - 위의 사진에서는 저장하는 작업이 병렬로 실행되어서 파티션이 2개 생김


<br><br>

<h2> RDD partitions </h2>


#### - RDD partitions
    - 하둡 맵리듀스 프로그래밍에서 각 블락 별로 병렬 실행 됨
    - Spark RDD에서도 유사한 개념이 적용 됨(HDFS의 블락은 RDD의 파티션에 대응 함)

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(15).png).


#### - RDD Repartitions
    - Repartition은 네트워크를 통한 많은 자원의 통신을 필요함
    - coalesce(N) 메소드를 사용하면 데이터 전송을 최소화 하면서 파티션의 개수를 줄일 수 있음