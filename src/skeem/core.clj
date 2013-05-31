(ns skeem.core
  (:gen-class)
  (:refer-clojure :exclude [char])
  (:use [the.parsatron]))

(def ^:dynamic stack [])

(defn extract
  "Extract information from the Parser's current state. f should be a
   fn of one argument, the parser's current state, and any value that
   it deems worthy of returning will be returned by the entire parser.
   No input is consumed by this parser, and the state itself is not
   altered."
  [f]
  (fn [state _ _ eok _]
    (eok (f state) state)))

(defn examine
  "Return the Parser's current state"
  []
  (extract identity))

(defparser op []
  (choice
    (char \+)
    (char \-)
    (char \/)
    (char \*)))
(defparser digits [] (many1 (digit)))
(defparser integer []
  (print (digits))
  (char \ )
  (digits))
(defparser whitespace [] (many1 (char \ )))
(defparser integer-and-trailing-whitespace []
  (integer)
  (whitespace))
(defparser integer-list []
  (many1 (integer-and-trailing-whitespace))
  (attempt (integer)))
(defparser sexp []
  (char \()
  (op)
  (whitespace)
  (integer-list)
  (char \)))
(defparser prog []
  (sexp)
  (eof))

(defn a-test []
  (run (integer) "123"))

(defn -main
  "This is where the skeeming happens..."
  [& args]
  (print (a-test)))
