;; Digit fifth powers
;; ==================
;; Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
;; 1634 = 14 + 64 + 34 + 44
;; 8208 = 84 + 24 + 04 + 84
;; 9474 = 94 + 44 + 74 + 44
;; As 1 = 14 is not a sum it is not included.
;; The sum of these numbers is 1634 + 8208 + 9474 = 19316.
;; Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
;; ==================

(defn pow [n p] (apply *' (repeat p n)))

(defn sum-of-powers? [n p]
    (let 
        [
            digits  (map #(Integer. (str %)) (vec (str n)))
            sum     (apply +' (map #(pow % p) digits))
        ]

        (= n sum)
    )
)

(let
    [
        n               5
        largest_bound   (*' (count (vec (str (pow 9 n)))) (pow 9 n))
    ]

    (apply +' (filter #(sum-of-powers? % n) (range 2 (inc largest_bound))))
)