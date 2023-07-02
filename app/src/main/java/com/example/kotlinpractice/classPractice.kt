package com.example.kotlinpractice

open class Human( val name : String = "Morrison"){
    constructor(name : String, age : Int) : this(name){
        println("my Name is ${name}, ${age}years old")
    }
    //constructor를 통해서 부생성자를 만들수 있다.
    // : this(주 생성자의 파라미터) 를 위임 받아야한다.

    init{
      println("New human has been born!!")
    }
// init 클래스로 주 생성자가 생성된다. 주 생성자이기 부 생성자보다 무조건 먼저 생성된다.

//    ex.java
//    class Person{
//    public Person(String name){}
//    public Person(String name, int age){
//    this(name)}
//    }

    fun eatingHambuger(){
        println("I love it")
    }

    open fun hanging(){
        println("play League Of Legend")
    }
}

//코틀린에서 생성자 클래스를 생성하고 싶으면 constructor() 이 방식을 생성한다.
//constructor는 생략가능

class Korean : Human(){
    override fun hanging(){
        super.hanging()
        println("drink a soju")
        println("Hey ${name} ! How Do I look ?")
    }
}

//코틀린에서의 상속 JAVA는 extends, 상속을 받고 싶으면 부모 클래스에 open을 적어야한다
//오버라이딩을 싶을때도 역시 덮어쓰고싶은 클래스에 open을 적어야한다.
//super를 사용해 기존 상위 클래스의 내용도 사용가능하다.

fun main(){
    val human = Human("Kim")
    val theMen = Human()
    human.eatingHambuger()

    val korean = Korean()
    korean.hanging()

    val Kim = Human("Min-Jae", 26)
    println("Plz Call my name is ${theMen.name}")
}


