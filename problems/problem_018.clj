;; Maximum path sum I
;; ==================
;; By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
;; 3
;; 7 4
;; 2 4 6
;; 8 5 9 3
;; That is, 3 + 7 + 4 + 9 = 23.
;; Find the maximum total from top to bottom of the triangle below:
;; 75
;; 95 64
;; 17 47 82
;; 18 35 87 10
;; 20 04 82 47 65
;; 19 01 23 75 03 34
;; 88 02 77 73 07 63 67
;; 99 65 04 28 06 16 70 92
;; 41 41 26 56 83 40 80 70 33
;; 41 48 72 33 47 32 37 16 94 29
;; 53 71 44 65 25 43 91 52 97 51 14
;; 70 11 33 28 77 73 17 78 39 68 17 57
;; 91 71 52 38 17 14 91 43 58 50 27 29 48
;; 63 66 04 68 89 53 67 30 73 16 69 87 40 31
;; 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
;; NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
;; ==================

(require '[clojure.string :as str])

(def tree-string "75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")

(defn relax 
    ([coll] (relax coll (first coll) (last coll)))
    ([coll first last] 
        (cond 
            (< (count coll) 4) coll
            :else (flatten [first (map #(apply max %) (partition 2 (drop-last 1 (drop 1 coll)))) last])
        )
    )
)

(defn max-path
    ([tree] (max-path tree (first tree)))
    ([tree result]
        (if (= 1 (count tree))
            (apply max result)
            (let [new-result (atom [])]
                (do
                    (loop [i 0]
                        (let 
                            [
                                item-previous   (nth result i nil)
                                item-current    (nth (first tree) i nil)
                                item-left       (nth (nth tree 1 []) i nil)
                                item-right      (nth (nth tree 1 []) (inc i) nil)
                            ]

                            (when-not (nil? item-current)
                                (swap! new-result conj (apply + (filter  #(not (nil? %)) [item-previous item-left])))
                                (swap! new-result conj (apply + (filter  #(not (nil? %)) [item-previous item-right])))

                                (recur (inc i))  
                            )
                        )
                    )

                    (recur (drop 1 tree) (relax @new-result))
                )
            )  
        )
    )
)

(let [numbers-sequence  (
                            map (fn [items] (
                            map (fn [item] (Integer. item)) items)) (
                            map (fn [items] (filter (fn [item] (not (empty? item))) items)) (
                            map #(str/split % #" ") (str/split-lines tree-string)))
                        )
    ]
    (max-path numbers-sequence)
)