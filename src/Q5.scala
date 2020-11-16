val ratings = sc.textFile("FileStore/ratings.csv")
// ','를 기준으로 [userId, movieID, rating, timestamp]로 분리
val ratingInfo = ratings.map(a => a.split(','))          
// 1번째 인덱스와 두번째 인덱스의 값을 Pair로 저장 (2번째 인덱스의 값이 rating이면 조건 처리)
val pairs = ratingInfo.map(x => if(x(2)=="rating") (-1, -1.0) else (x(1), x(2).toDouble))
// Pair의 키(첫번째 값)를 기준으로 그룹화하여 밸류(두번째 값)에 있는 값들을 더하기 
// https://stackoverflow.com/questions/7142514 를 참조했습니다. 
val groupPairs = pairs.groupBy(_._1).mapValues(_.map(_._2).reduce(_ + _)) 
// Pair를 밸류(두번째 값)로 내림차순으로 정렬하고 100개의 데이터를 추출 
groupPairs.takeOrdered(100)(Ordering[Double].reverse.on(x=>x._2))     