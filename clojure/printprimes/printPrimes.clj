(ns printPrimes
  (:require [clojure.core.reducers :as r])
  (:gen-class))

(defn is-prime?
  [number]
  (not-any?
    (fn [x] (zero? (rem number x)))
    (range 2 number)))

(defn -main
  [& args]
  (println "Hello world!")
  (->> 100000
       (range 2)
       vec
       shuffle
       (r/filter is-prime?)
       r/foldcat
       count
       time))

(-main)
