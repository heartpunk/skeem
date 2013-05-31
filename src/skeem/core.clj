(ns skeem.core
  (:gen-class))

(def ops {'+ +, '- -, '/ /, '* *})

(defn eval-skeem [exp & exps]
  (cond
    (and (list? exp) (ops (first exp)))
      (apply (ops (first exp)) (rest exp))))

(defn -main
  "This is where the skeeming happens..."
  [& args]
  (println (eval-skeem '(+ 1 2 3))))
