object PrintPrimes {

  def main(args: Array[String]) {
    var msg = "Hello, world!"
    time(() => { println((2 to 100000).par.filter(isPrime)) } )
  }

  def time(f : () => Unit) = {
    val t1 = System.currentTimeMillis()
    f()
    println("Time Taken: " + (System.currentTimeMillis() - t1))
  }

  def isPrime(x : Int) : Boolean = {
    for (i <- 2 until x) {
        if ((x % i) == 0) {
            return false
        }
    }
    true
  }
}
