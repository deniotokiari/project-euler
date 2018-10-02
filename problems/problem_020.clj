(defn factorial [n] (apply *' (range 1 (inc n))))

(let [n 100]
    (apply + (map #(Integer. (str %)) (vec (str (factorial n)))))
)