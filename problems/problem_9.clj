;; Special Pythagorean triplet
;; ===========================
;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a**2 + b**2 = c**2
;; For example, 32 + 42 = 9 + 16 = 25 = 52.
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.
;; ===========================

(defn pythagorean-triplet? [a b c]
  (and
    (< a b c)
    (=
      (* c c)
      (+ (* a a) (* b b))
    )
  )
)

(let [quartet-sum 1000]
  (apply * (first (drop-while #(not (and (pythagorean-triplet? (first %) (second %) (last %)) (= quartet-sum (apply + %))))
    (for
      [
        a (drop 1 (range quartet-sum))
        b (drop 2 (range quartet-sum))
        c (drop 3 (range quartet-sum))
      ]
      [a b c]
    )
  )))
)
