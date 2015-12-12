def tailCallFactorial(current:Int, result:Int): Int = {
  if(current==0) return result
  else tailCallFactorial(current-1, result*current)
}

def factorial(i:Int): Int = {
  return tailCallFactorial(i,1)
}

factorial(9)
factorial(7)

//def primes(i:Int): Seq[Int] = {
//  if(i==1) return 1 :: Nil
//  else return primes
//}