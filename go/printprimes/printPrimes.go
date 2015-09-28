package main
import (
  "time"
  "fmt"
)

func printPrimes(load int) {
  results := make([]int, 0, load)
  prime := make(chan int)

  for i := 1; i <= load; i++ {
    go checkPrime(prime, i)
  }

  for i := 1; i <= load; i++ {
    if n := <- prime; n != 0 {
      results = append(results, n)
    }
  }

  fmt.Printf("%v\n", results)
}

func checkPrime(prime chan<- int, n int) {
  for i := 2; i < n; i++ {
    if n % i == 0 {
      prime <- 0
      return
    }
  }
  prime <- n
}

func main() {
  start := time.Now()
  printPrimes(100000)
  fmt.Printf("Time taken: %s\n", time.Since(start))
}
