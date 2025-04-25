package homework_2

fun main(){
    println(temperatureConverter(25.0))
    println(calculateArea(25.7,30.5))
    println(calculateFactorial(5))
    println(countLetters("Mert",'m'))
    println(sumOfInteriorAngles(3))
    println(calculateSalary(30))
    println(calculateFee(140))
}

fun temperatureConverter(degree:Double): Double{
    return degree*1.8 +32;
}
fun calculateArea(height: Double, width: Double): Double{
    return height*width;
}

fun calculateFactorial(number:Int): Int{
    if(number==0){
        return 1;
    }
    return number * calculateFactorial(number-1)
}

fun countLetters(word: String,letter:Char): Int{
    var count = 0
    for(letter1 in word){
        if(letter1.lowercaseChar() == letter.lowercaseChar()){
            count++
        }
    }
    return count
}

fun sumOfInteriorAngles(edgeNumber:Int):Int{
    return (edgeNumber-2)*180
}

fun calculateSalary(days: Int):Int{
    val totalHours = days*8
    return if(totalHours<160){
        totalHours * 10
    }else{
        160 * 10 + (totalHours-160) * 20
    }
}

fun calculateFee(quota: Int):Int{
    return if(quota>50){
        100 + (quota-50)*4
    }else{
        100
    }
}