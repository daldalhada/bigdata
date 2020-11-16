val ratings = sc.textFile("/dataset/movielens/ratings.csv")
// ','를 기준으로 [userId, movieID, rating, timestamp]로 분리
val ratingInfo = ratings.map(a => a.split(','))
// 2번째 인덱스인 tag를 배열에 저장(2번째 인덱스의 값이 rating이면 조건 처리)
// 헤더 제거하는 방법을 늦게 알았습니다.
val ratingArray = ratingInfo.map(tag => if(tag(2)=="rating") 0 else tag(2).toDouble)
// 배열의 길이를 변수에 저장
val ratingCount = ratingArray.count()
// 배열의 있는 값을 모두 더해 변수에 저장
val ratingSum = ratingArray.reduce((a, b) => a+b)
// 값을 나누어서 평점을 변수에 저장
val average = ratingSum/(ratingCount-1)                                                   