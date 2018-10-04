;; Lexicographic permutations
;; ==========================
;; A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
;; 012   021   102   120   201   210
;; What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
;; ==========================

(require '[clojure.string :as str])

(defn factorial [n] (apply *' (range 1 (inc n))))

(defn to-factorial-radix-array 
  ([n] (to-factorial-radix-array n 2 [0]))
  ([n i result]
    (if-not (zero? n)
      (recur (quot n i) (inc i) (conj result (rem n i)))
      (reverse result)
    ) 
  )
)

(defn n-permutation 
  ([n col] (n-permutation (to-factorial-radix-array n) col []))
  ([factorial-number col result]
    (if (empty? factorial-number)
      result
      (let
        [
          index   (first factorial-number)
          number  (nth col index)
          new-col (keep-indexed #(if (not= index %1) %2) col)
        ]

        (recur (drop 1 factorial-number) new-col (conj result number))
      )
    )
  )
)

(str/join "" (map str (n-permutation 999999 [0 1 2 3 4 5 6 7 8 9])))
