;; Largest palindrome product
;; ==========================
;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.
;; ==========================

(defn palindrome? [x]
  (let [string-number (str x)]
    (= (vec string-number) (reverse string-number))
  )
)

(let [numbers (range 100 1000)]
  (apply max (filter palindrome? 
    (distinct (flatten (map #(map (partial * %) numbers) numbers)))
  ))
)
