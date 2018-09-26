;; 10001st prime
;; =============
;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;; What is the 10 001st prime number?
;; =============

(defn prime? [x] 
  (empty? 
    (filter #(zero? (mod x %)) 
      (range 2 (inc (int (Math/floor (Math/sqrt x)))))
    )
  )
)


(defn get-n-prime [n]
  (last (take n (filter prime? (drop 2 (range)))))
)

(get-n-prime 10001)
