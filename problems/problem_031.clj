(let 
    [
        result (atom 0)
    ]

    (loop [i0 200]
        (loop [i1 i0]
            (loop [i2 i1]
                (loop [i3 i2]
                    (loop [i4 i3]
                        (loop [i5 i4]
                            (loop [i6 i5]
                                (when (>= i6 0) 
                                    (swap! result inc) 
                                    (recur (- i6 2))
                                )
                            )
                        
                            (when (>= i5 0) (recur (- i5 5)))
                        )

                        (when (>= i4 0) (recur (- i4 10)))
                    )

                    (when (>= i3 0) (recur (- i3 20)))
                )

                (when (>= i2 0) (recur (- i2 50)))
            )

            (when (>= i1 0) (recur (- i1 100)))
        )

        (when (>= i0 0) (recur (- i0 200)))
    )

    @result
)