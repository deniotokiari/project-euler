;; Number letter counts
;; ====================
;; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
;; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
;; NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
;; ====================

(def numbers
    {
        1 "one"
        2 "two"
        3 "three"
        4 "four"
        5 "five"
        6 "six"
        7 "seven"
        8 "eight"
        9 "nine"
        10 "ten"

        11 "eleven"
        12 "twelve"
        13 "thirteen"
        14 "fourteen"
        15 "fifteen"
        16 "sixteen"
        17 "seventeen"
        18 "eighteen"
        19 "nineteen"

        20 "twenty"
        30 "thirty"
        40 "forty"
        50 "fifty"
        60 "sixty"
        70 "seventy"
        80 "eighty"
        90 "ninety"

        :hundred "hundred"

        :thousand "thousand"
    }
)


(defn number-to-string [n]
    (cond
        (< n 20)    (numbers n)
        (< n 100)   (let 
                        [
                            first-number    (quot n 10)
                            second-number   (mod n 10)
                        ]

                        (if (zero? second-number)
                            (numbers n)
                            (str (numbers (* 10 first-number)) "" (numbers second-number))
                        )       
                    )
        (< n 1000)  (let
                        [
                            first-number        (quot n 100)
                            second-two-numbers  (mod n 100)
                        ]
                      
                        (if (zero? second-two-numbers)
                            (str (numbers first-number) "" (numbers :hundred))
                            (str (number-to-string (* 100 first-number)) "and" (number-to-string second-two-numbers))
                        )
                    )
        (= n 1000) (str (numbers 1) "" (numbers :thousand))
    )
)


(let [start 1 end 1000]
    (apply + (map #(count (number-to-string %)) (range start (inc end))))
)