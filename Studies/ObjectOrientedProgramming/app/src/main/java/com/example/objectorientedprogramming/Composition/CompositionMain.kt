package com.example.objectorientedprogramming.Composition

fun main() {
    val category1 = Category(1,"Dram")
    val category2 = Category(2,"Comedy")
    val director1 = Director(1,"Nuri Bilge Ceylan")
    val director2 = Director(2,"Quentin Tarantino")
    val movie1 = Movie(1,"Django",2013,category1,director2)
    val movie2 = Movie(2,"Kış Uykusu",2017,category1,director1)
    val movie3 = Movie(3,"Kralın Dönüşü",2006,category2,director1)

    val movies = ArrayList<Movie>()
    movies.add(movie1)
    movies.add(movie2)
    movies.add(movie3)

    for(movie in movies){
        println("******${movie.movie_name}******")
        println("Category: ${movie.movie_category.category_name}, Directed by ${movie.movie_director.director_name} in ${movie.movie_year}")
    }
}