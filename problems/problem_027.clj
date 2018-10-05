(defn pow [n p] (apply *' (repeat p n)))

(defn prime? [x]
    (if (or (neg? x) (zero? x))
        false
        (empty? (filter #(zero? (mod x %)) (range 2 (inc (int (Math/floor (Math/sqrt x)))))))
    )
)

(defn prime-seq [a b]
  (take-while #(prime? %) (map #(+ (pow % 2) (* a %) b) (range)))
)

(let 
    [
        bound-start     -999
        bound-end       999
     
        a               (range bound-start (inc bound-end))
        b               (range bound-start (inc bound-end))
      
        max-prime-seq   (last 
                                (sort-by :count 
                                    (map #(hash-map :count (count (% :seq)) :map %) 
                                        (remove #(empty? (% :seq)) 
                                            (map #(hash-map :a (% :a) :b (% :b) :seq (prime-seq (% :a) (% :b))) 
                                                (for [i a j b] (hash-map :a i :b j))
                                            )
                                        )
                                    )
                                )
                        )

        max-a           ((max-prime-seq :map) :a)
        max-b           ((max-prime-seq :map) :b)
    ]
  
    (* max-a max-b)
)