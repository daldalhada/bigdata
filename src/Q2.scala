val movies = sc.textFile("/dataset/movielens/movies.csv")
// ','를 기준으로 [id, title, genre]로 분리  
val movieInfo = movies.map(movie => movie.split(','))   
// 1번째 인덱스인 title를 배열에 저장
val title = movieInfo.map(mi => mi(1))   
// RDD에 중복된 것을 삭제
val uniqueTitle = title.distinct() 
// RDD 원소 중 임의 원소를 반환함
uniqueTitle.takeSample(true, 10)  