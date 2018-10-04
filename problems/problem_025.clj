(defn fibonacci 
    ([n] (fibonacci n 0 1))
    ([n previous current]
        (if (> n 0)
            (recur (dec n) (-' (+' current previous) previous) (+' current previous))
            previous
        )
    )
)

(let 
    [
        n 1000
    ]

    ((first (drop-while #(< (count (str (% :value))) n) (map-indexed #(hash-map :index %1 :value (fibonacci %2)) (range)))) :index)
)