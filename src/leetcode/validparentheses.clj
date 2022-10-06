(ns leetcode.validparentheses)


(def ^:private par-map {\{ \}
                        \( \)
                        \[  \]})


(defn is-valid [s]
  (let [stack (atom '())]
    (reduce (fn [_ ch]
              (cond
                (or (= ch \{)
                    (= ch \()
                    (= ch \[)) (do (swap! stack conj (par-map ch))
                                   false)
                (not= (peek @stack) ch) (reduced false)
                :else (do (swap! stack pop)
                          (if (= (count @stack) 0)
                            true
                            false))))
            true s)))