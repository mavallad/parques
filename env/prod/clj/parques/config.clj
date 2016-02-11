(ns parques.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[parques started successfully]=-"))
   :middleware identity})
