(ns printPrimes
  (:require [clojure.core.reducers :as r])
  (:gen-class))

(defn is-prime?
  "A naive implementation of prime checking.
  Uses loop-recur instead of lazy seqs for performance."
  [number]
  (loop [x 2]
    (if (zero? (unchecked-remainder-int number x))
      (= x number)
      (recur (inc x)))))

(defn pfilter
  "A parallelized filter over a collection for a drop-in
  replacement for the vanilla filter. Inspired by pmap."
  [f coll]
  (r/foldcat (r/filter f (vec coll))))

(defn -main
  [& args]
  (println "Hello world!")
  (time (count (pfilter is-prime? (range 2 100000)))))

; allows `lein exec` to call this like a script
(-main)
