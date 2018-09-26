;; Largest prime factor
;; ====================
;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?
;; ====================

(defn prime? [x] 
  (empty? 
    (filter zero? 
      (map #(mod x %) 
        (range 2 (inc (int (Math/floor (Math/sqrt x)))))
      )
    )
  )
)


(let [n 600851475143]
  (apply max 
    (filter #(and (zero? (mod n %)) (prime? %)) 
      (range 2 (inc (int (Math/floor (Math/sqrt n)))))
    )
  )
)
