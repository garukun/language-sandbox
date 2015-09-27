(ns printPrimes)

(require '[clojure.core.reducers :as r])

(defn is-prime?
  [number]
  (loop [x 2]
    (if (zero? (unchecked-remainder-int number x))
      (= x number)
      (recur (inc x)))))

(defn -main
  [& args]
  (println "Hello world!")
  (->> 100000
       (range 2)
       vec
       (r/filter is-prime?)
       r/foldcat
       count
       time))

(-main)
