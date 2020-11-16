val movies = sc.textFile("/dataset/movielens/movies.csv")
 // ','를 기준으로 [id, title, genre]로 분리 
val movieInfo = movies.map(movie => movie.split(','))   
// 2번째 인덱스인 genre를 '|'로 분리해 배열 리턴  
val genres = movieInfo.flatMap(mi => mi(2).split('|'))      
// 주어진 genre가 있으면 Key-Value pair로된 배열 만들기 
val genreOne = genres.map(g => (g, 1))             
// 주어진 genre Value에 1 값을 더함  
val genreCounter = genreOne.reduceByKey((x,y) => (x+y))            
// Tuple의 첫 번째 원소에 Action이 포함된 것을 필터링
val actionMovie = genreCounter.filter(m => m._1.contains("Action"))
actionMovie.collect()