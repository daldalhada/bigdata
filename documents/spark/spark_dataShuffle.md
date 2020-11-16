<h2> Spark 데이터 셔플 </h2>


#### - 파티션간 데이터를 네트워크로 상호 전송 함
    - reduceByKey, groupByKey, repartition
    - Spark RDD에서도 유사한 개념이 적용 됨(HDFS의 블락은 RDD의 파티션에 대응 함)

#### - 많은 자원 필요
    - Disk I/O, (de)serialization, network I/O (all-to-all)
    - 활용시 주의 필요


#### - PiarRDDFunctions
    - RDD에서의 Key-Value 쌍은 다양한 응용에 활용 됨
    - key 별로 aggregation 또는 grouping을 가능하게 함
    - <Key, Value> RDD를 활용한 API(reduceByKey, groupByKey, aggregationByKey 등)
    - Scala의 Tuple2(Pir)를 활용하여 Key-Value 쌍 표현 가능

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(16).png).

#### - keyValue pair RDDs를 활용한 Transformation
    - groupByKey(): 주어진 <K, V>에 대해서 출력으로 <K, Iterable<V>>을 반환함
    - reduceByKey(func): 주어진 <K, V>에 대해서 <K, V>를 반환 함, 입력으로 주어진 함수(func)를 입력 데이터인 (K, V)에서 <V, V>를 실행 함
    - mapValues(func): Value들에 입력으로 주어진 func함수를 적용


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(17).png).


#### - keyValue pair RDDs functions
    - keys(): Key-Value 쌍에서 key만을 반환
    - values(): Key-Value 쌍에서 values만을 반환
    - sortByKey(): Key를 기준으로 정렬 해줌


![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(18).png).


#### - 2개의 K-V 쌍에 대한 작업
    - subtractByKey(other_rdd): othter_rdd에 존재하는 key값을 원본 RDD에서 삭제 함
    - join(oter_rdd): 같은 Key값을 기준으로 하나의 RDD로 변환(innter join), 각 key값에 대해서 가능한 모든 value들의 조합을 만들어 냄(cartesian)
    - cogroup(other_rdd): 같은 key값을 기준으로 하나의 RDD로 변환(outer join), 각 key값에 대해서 결과가 하나의 CompactBuffer로 반환 됨
  
    ※ CompactBuffer는 스칼라에서 새롭게 만든 효율적인 list임

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(19).png).



#### - KeyValue Pair RDD를 활용한 Genre Counter

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(20).png).


<br>
#### - Monte-Carlo 기법

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(21).png).

![Spark Core](https://github.com/daldalhada/bigdata/blob/main/images/spark/spark(22).png).

