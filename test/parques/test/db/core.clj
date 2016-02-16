(ns parques.test.db.core
  (:require [parques.db.core :as db]
            [parques.db.migrations :as migrations]
            [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [conman.core :refer [with-transaction]]
            [config.core :refer [env]]
            [mount.core :as mount]))

(defn submap? [m1 m2]
  "Checks whether m contains all entries in sub."
  (and (every? (set (keys m1)) (keys m2))
     (every? #(= (m1 %)(m2 %)) (keys m2))))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'parques.db.core/*db*)
    (migrations/migrate ["migrate"])
    (f)))

(deftest test-parks
  (with-transaction [t-conn db/*db*]
    (jdbc/db-set-rollback-only! t-conn)
    (def park-returned (db/create-park<!
               {:name    "Sam"
                :city    "Madrid"
                :address "Oña 96"
                :latitude 14.222
                :longitude 44.33
                :floor_type_id 1
                :description "nada"}))
    (is (submap? park-returned
                {:name    "Sam"
                :city    "Madrid"
                :address "Oña 96"
                :latitude 14.222
                :longitude 44.33
                :floor_type_id 1
                :description "nada"}))

    (def park-returned2 (db/get-park {:id (:id park-returned)}))
    (is (submap? (first park-returned2)
                {:name    "Sam"
                :city    "Madrid"
                :address "Oña 96"
                :latitude 14.222
                :longitude 44.33
                :floor_type_id 1
                :description "nada"}))))
