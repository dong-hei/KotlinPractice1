package com.example.kotlinpractice

fun main(){
    nullcheck()
    forAndWhile()
    helloWorld()
    ignoreNulls("")
    println(add(4,5))
    checkNum(0)
    //3. String Template, 변수를 출력하고싶을때는 달러사인($) + 변수명을 사용하면된다
    //굳이 달러사인을 쓰고싶다면 \$ (백틱+달러)를 사용하자
    val name = "DK"
    var age = ",29"
    println("my name is ${name + age}Nice to meet u")
    println("It's 3\$")
}

//1.함수
fun helloWorld(){
    println("hello World")
}
fun add(a : Int, b: Int) : Int {
    return a+b
}
// 계산을 하고싶다면
// (변수명 : 타입) 무언가를 리턴해야한다면 () : Int는 리턴이 불가능 하다.

//2. val vs var
//val = value 불변하는것 => 값이 지정되어있으면 불변
//var = variable 변할수있는것
fun h1(){
    val a : Int = 11
    var b : Int = 9

    val c = 100
    var name = "Kim"
    //값을 적지않아도 Int or String인지 자동추론하기에 생략해도 된다 그러나 val과 var는 반드시 구분해줘야한다
}


//4. 조건식 maxBy와 maxBy2는 같다.
fun maxBy(a : Int, b: Int) : Int{
    if (a > b){
        return a
    }else(
            return b
    )
}

fun maxBy2(a : Int, b: Int) = if(a>b) a else b

fun checkNum(score : Int){
    when(score){
        0 -> println("오답")
        1,2 -> println("정답")
        else -> println("합격")
    }
    var b = when(score){
        0 -> "Nothing"
        1 -> "One"
        else -> "Num"
    }// 이런식으로 리턴식으로 쓰일수있다.

    println("b : ${b}")

    when (score){
        in 95..100 -> println("A+")
        in 90..94 -> println("A")
        in 80..89 -> println("B")
        in 50..79 -> println("pass")
        else -> println("No Pass")
    }
}

// when은 스위치 역할

//Expression vs Statement
//자바와 코틀린의 가장 큰 차이
//Expression 값을 만들면 표현식이다.
//ex.if(a>b) a else b
//코틀린의 모든 함수는 리턴값이 없어보여도 : Unit을 반환하기 때문에 Expression이다

//Statement 문장
//자바에서는 void 형태의 리턴값이 없는 함수가 존재하는데
//이 경우는 Expression이 아니라 Statement로 사용된다.
//고로 If문이 자바에서는 Only Statement로 사용될수밖에없는데

//Kotlin에서는 Expression, Statement 둘다 사용가능하다.
// ex. when(score){
//        0 -> println("오답")
//        1,2 -> println("정답")
//        else -> println("합격")
//    }

//5. Array and List

// Array : 이미 할당이 되었기때문에 처음에 크기 지정을 해주어야 한다.

// List 1. List -> 수정 불가능 (읽기전용) 2. MutableList -> 수정 가능

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3,4,5)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",11L)
    
    array[0] = 2
    //가능

//    list[0] = 2
    //불가능
    var result = list.get(0)
    // I 이기 때문에 값에 넣을순있지만 변경시키는것은 불가능하다.

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(13)

//    arrayList = arrayListOf() 이런식으로 재할당 불가능하다.

// 고유값이 불변하기 때문에 val을 사용해도 된다.
// (항상 arrayList을 가리키기때문에 arrayList를 val을 사용해도된다.
}

// 6. 반복문 For / while

fun forAndWhile(){
    val playerName = arrayListOf("Kim", "Son", "Ahn", "Yang")

    for (name in playerName){
        println("${playerName}")
    }

    //withIndex를 붙이면 Index와 name을 함께사용할수있다.
    for ((index,name) in playerName.withIndex()){
        println("${index+1}번째 선수 : ${name}")
    }

    //step 2발자국씩 더 가봐 여기서는 1,3,5,7,9
    //downTo 1 10,9,8,7,6,5,4,3,2,1
    //until 100 = 1..99 (100은 제외)
    //1..100 1부터 100까지

    var sum : Int = 0
    for (i in 1..10 step 2){
        sum += i
    }
    println(sum)

    var index = 0
    while (index < 10){
        println("correct index : ${index}")
        index++
    }
}

//7.NonNull 과 Nullable
//Java와 Kotlin의 다른점

fun nullcheck() {
    //Null Pointer Exception 자바로 코딩을 하면 많이 나는 오류 : Runtime Exception
    //NPE가 런타임오류라 귀찮았으니까 코틀린은 컴파일오류로 만들어줄게

    var name : String = "DK"

    var nullName : String? = null
    //?붙여주면 nullable 타입이되고 (고로 nullable타입을 생성하고싶으면 타입을 생략해서는 아니된다.)
    // ?를 붙이지 않으면 Not Null 컴파일오류가 뜬다.;

    //var nullNameInUpperCase = nullName?.toUpperCase()
    //Not null 함수에도 ?를 써주면 nullable 타입이 된다.

    // ?: 엘비스 프레슬리 연산자 lastName이 없으면(?:) "이것을 사용해라"

    val lastName : String? = null

    val fullName = name + "" + (lastName?: "Null lastName")
    println(fullName)

    //!! 이거 절대 Null 아니야라고 컴파일러에게 어필한다.
    //되도록이면 삼가해야하는이유 : 확실하게 Null이 아닌 이상 사용하면
    //Null Point Exception 오류가 날수있다.
}

fun ignoreNulls(str: String?){
    val NotNull : String = str!!
    val upper = NotNull.toUpperCase()

    val email : String? = "kbs245677@gmail.com"
    email?.let{
        println("my email is ${email}")
    }
    //let 나의 email을 내부로 이동시켜준다. email이 Null이 아니라면 이동시켜준다
}

//8. Class