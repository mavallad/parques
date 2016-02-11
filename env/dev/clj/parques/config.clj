(ns parques.config
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [parques.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[parques started successfully using the development profile]=-"))
   :middleware wrap-dev})
