;; Lattice paths
;; =============
;; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
;; How many such routes are there through a 20×20 grid?
;; =============

(defn factorial [n] (reduce *' (range 1 (inc n))))


(defn pascal-number [n m] (/ (factorial n) (*' (factorial m) (factorial (- n m)))))


(let [grid 20]
    (pascal-number (+ grid grid) grid)
)