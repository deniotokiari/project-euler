;; Amicable numbers
;; ================
;; Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
;; If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
;; Evaluate the sum of all the amicable numbers under 10000.
;; ================

(defn deviders [n]
  (if (= 1 n) 
    [1]
    (let 
      [
        deviders-part-1 (filter #(zero? (rem n %)) (range 2 (inc (Math/floor (Math/sqrt n)))))
        deviders-part-2 (map #(/ n %) deviders-part-1)
      ]

      (sort (conj (distinct (concat deviders-part-1 deviders-part-2)) 1))
    )
  )
)

(defn get-amicable-numbers [n]
  (let
    [
      n-deviders                      (deviders n)
      possible-amicable-number        (apply + n-deviders)
      amicable-number-deviders        (deviders possible-amicable-number)
      amicable-number-amicable-number (apply + amicable-number-deviders)
    ]

    (cond
      (= n possible-amicable-number) nil
      (= n amicable-number-amicable-number) (sort [n possible-amicable-number])
      :else nil
    )
  )
)

(let [n 10000]
  (apply + (map #(apply + %) (distinct (filter #(not (nil? %)) (map #(get-amicable-numbers %) (range 2 n))))))
)
