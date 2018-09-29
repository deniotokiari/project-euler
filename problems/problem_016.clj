;; Power digit sum
;; ===============
;; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;; What is the sum of the digits of the number 2^1000?
;; ===============

(let 
    [
        n 2 
        pow 1000
        result (apply *' (repeat pow n))
    ]
    
    (apply +' (map #(Integer. (str %)) (vec (str result))))
)