(ns trying-out-compojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (GET "/" [] "Hello World")
           (GET "/greet" [& data]
             (let [name (:name data)]
               (if name
                 (str "Hello " name "!")
                 "Hello Stranger!")))
           (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
