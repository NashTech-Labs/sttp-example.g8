package com.knoldus

import com.google.gson.Gson
import com.softwaremill.sttp._

trait BookData {

  def getAllBook: List[Book] = {
    val gson = new Gson
    val request = sttp.get(uri"http://localhost:3000/books")
    implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()
    gson.fromJson(request.send().unsafeBody, classOf[Array[Book]]).toList
  }

  def getBooksByAuthor(author: String): List[Book] = {
    val gson = new Gson
    println(uri"http://localhost:3000/books?author=$author")
    val request: Request[String, Nothing] = sttp.get(uri"http://localhost:3000/books?author=$author")
    implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()
    gson.fromJson(request.send().unsafeBody, classOf[Array[Book]]).toList
  }

}

object BookData extends BookData

case class Book(author: String, country: String, imageLink: String, language: String, link: String, pages: Int, title: String, year: Int)