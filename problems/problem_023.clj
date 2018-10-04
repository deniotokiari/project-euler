;; Non-abundant sums
;; =================
;; A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
;; A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
;; As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
;; Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
;; =================

(defn deviders [n]
  (if (= 1 n) 
    [1]
    (let 
      [
        deviders-part-1 (filter #(zero? (rem n %)) (range 2 (inc (Math/floor (Math/sqrt n)))))
        deviders-part-2 (map #(/ n %) deviders-part-1)
      ]

      (sort (distinct (concat [1] deviders-part-1 deviders-part-2)))
    )
  )
)

(defn abundant? [n] (> (apply +(deviders n)) n))

(defn has? [col n] 
  (if (some #(= n %) col)
    true
    false
  )
)

(let  [
        n                 28123
        abundant-numbers  (filter abundant? (range 1 (inc n)))
        abundant-sums     (distinct (filter #(< % n) (for [i abundant-numbers j abundant-numbers] (+ i j))))
      ]

      (apply +' (remove #(has? abundant-sums %) (range 1 n)))
)
