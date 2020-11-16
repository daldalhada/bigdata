val ratings = sc.textFile("FileStore/ratings.csv")
val movies = sc.textFile("FileStore/shared_uploads/eightlover@kookmin.ac.kr/movies.csv")
// ','를 기준으로 [userId, movieID, rating, timestamp]로 분리
val ratingInfo = ratings.map(arr => arr.split(','))
// 1번째 인덱스와 두번째 인덱스의 값을 Pair로 저장 (2번째 인덱스의 값이 rating이면 조건 처리)
val ratingpairs = ratingInfo.map(x => if(x(2)=="rating") ("movieId", -1.0) else (x(1), x(2).toDouble))
// ','를 기준으로 [movieId, title, genre]로 분리 로 분리
val movieInfo = movies.map(arr => arr.split(',')) 
// 1번째 인덱스와 두번째 인덱스의 값을 Pair로 저장
val moviepairs = movieInfo.map(x => (x(0), x(1)))
// movieId를 기준으로 두 Pair를 Join
val join = ratingpairs.join(moviepairs)
// movieId를 기준으로 그룹화
val groupPairs = join.groupBy(_._1)
// 평점의 개수가 100개 이상인 데이터를 필터링
val filterPairs = groupPairs.filter(m => m._2.size > 99)
// 배열의 두 번째값에 해당하는 Iterable의 첫 번째 값인 평점을 reduce 작업
val ratingPairs = filterPairs.mapValues(_.map(_._2)).mapValues(_.map(_._1).reduce(_ + _))
// 배열의 두 번째값에 해당하는 Iterable의 두 번째 값인 영화제목을 Set으로 설정하고 중복을 제거
val titlePairs = filterPairs.mapValues(_.map(_._2)).mapValues(_.map(_._2).toSet)
// movieId를 기준으로 ratingPairs, titlePairs인 두 Pair를 Join
val join2 = ratingPairs.join(titlePairs)
// Join한 결과 값을 평점을 기준으로 내림차순하여 10개의 데이터를 추출
val OrderFilter = join2.takeOrdered(10)(Ordering[Double].reverse.on(x=>x._2._1))       