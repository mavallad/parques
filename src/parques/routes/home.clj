(ns parques.routes.home
  (:require [parques.db.core :as db]
            [parques.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [ring.util.response :as response]))

(defn home-page []
  (layout/render
    "home.html" {:parks (db/get-parks)}))

(defn about-page []
  (layout/render "about.html"))

(defn create-park! [{:keys [params]}]
  (db/create-park<! params)
  (response/redirect params))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/park" request (create-park! request))
  (GET "/about" [] (about-page)))

