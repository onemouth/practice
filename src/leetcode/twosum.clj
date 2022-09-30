(ns leetcode.twosum)

(defn twosum [nums target]
  (let [nums-indexed (map-indexed vector nums)
        target-map (atom (hash-map))]
    (reduce (fn [_ [idx val]] (if (contains? @target-map val)
                                (reduced [(@target-map val) idx])
                                (do (swap! target-map assoc (- target val) idx)
                                    [])))
            [] nums-indexed)))

(= (twosum [2 7 11 15] 9) [0 1])

; [1 2]
(twosum [3 2 4] 6)

; [0 1]
(twosum [3 3] 6)

(twosum [3 3] 7)