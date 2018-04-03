(ns hqs.handler
  (:require [hiccup.core :as hiccup]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def index
  (hiccup/html [:h1 "Hello World"]))

(defroutes app-routes
  (GET "/" [] index)
  (route/not-found (hiccup/html
     "Sites you are seeking," [:br]
     "From your path they are fleeing," [:br]
     "Their winter has come." [:br] "404")))

(def app
  (wrap-defaults app-routes site-defaults))

