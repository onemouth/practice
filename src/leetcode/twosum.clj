(ns leetcode.twosum)


(defn twosum [nums target]
  (let [nums-indexed (map-indexed vector nums)
        target-map (reduce #(assoc %1 (- target (%2 1)) (%2 0)) (hash-map) nums-indexed)]
    ; %2: [idx, value]
    (reduce #(if (contains? target-map (%2 1))
               (reduced [(%2 0) (target-map (%2 1))])
               %1)
            [] nums-indexed)))

(= (twosum [2 7 11 15] 9) [0 1])

(twosum [3 2 4] 6)


; target-map (keep-indexed #(assoc target-map (- target %2) %1) nums)