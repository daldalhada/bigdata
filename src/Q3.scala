val tags = sc.textFile("/dataset/movielens/tags.csv")
// ','를 기준으로 [userId, movieID, tag, timestamp]로 분리
val tagsInfo = tags.map(arr => arr.split(','))   
// 2번째 인덱스인 tag를 배열에 저장
val tagSplit = tagsInfo.map(tag => tag(2))   
// 주어진 tag가 있으면 Key-Value pair로된 배열 만들기
val tagArray = tagSplit.map(tag => (tag, 1))  
// 주어진 tag Value에 1 값을 더함
val tagCounter = tagArray.reduceByKey((x,y) => (x+y)) 
// 2번째 Value인 tag의 개수를 기준 내림차순으로 정렬하여 1개의 값을 가져오기 
tagCounter.takeOrdered(1)(Ordering[Int].reverse.on(x=>x._2))      