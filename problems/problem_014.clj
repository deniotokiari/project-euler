;; Longest Collatz sequence
;; ========================
;; The following iterative sequence is defined for the set of positive integers:
;; n → n/2 (n is even)
;; n → 3n + 1 (n is odd)
;; Using the rule above and starting with 13, we generate the following sequence:
;; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
;; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
;; Which starting number, under one million, produces the longest chain?
;; NOTE: Once the chain starts the terms are allowed to go above one million.
;; ========================

(defn get-collatz-sequance
  ([n] (get-collatz-sequance n [n]))
  ([n current]
    (cond
      (= n 1)   current
      (even? n) (let [x (/ n 2)] (recur x (conj current x)))
      (odd? n)  (let [x (+ 1 (* 3 n))] (recur x (conj current x)))
    )
  )
)


(defn get-count-and-first-collatz-sequance [n] 
  (let 
    [
     sequence (get-collatz-sequance n)
     count (count sequence)
    ]

    [n count]
  )
)

(let [n 1000000]
  (first (first (sort #(> (last %1) (last %2)) (map #(get-count-and-first-collatz-sequance %) (range 1 n)))))
)
