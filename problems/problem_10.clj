;; Summation of primes
;; ===================
;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; Find the sum of all the primes below two million.
;; ===================

(defn prime? [x] 
  (empty? 
    (filter #(zero? (mod x %)) 
      (range 2 (inc (int (Math/floor (Math/sqrt x)))))
    )
  )
)

(let [number 2000000]
  (reduce + (filter prime? (range 2 (inc number))))
)
