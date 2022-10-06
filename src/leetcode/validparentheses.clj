(ns leetcode.validparentheses)


(def ^:private par-map {\{ \}
                        \( \)
                        \[  \]})


(defn is-valid [s]
  (let [stack (reduce (fn [stack ch]
                        (cond
                          (contains? par-map ch) (conj stack (par-map ch))
                          (not= (peek stack) ch) (reduced stack)
                          :else (pop stack)))
                      '() s)]
    (if (zero? (count stack))
      true
      false)))